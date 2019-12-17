package com.ywjs.webservice.config;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.ywjs.webservice.service.DemoService;
import com.ywjs.webservice.service.impl.DemoServiceImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/saop/*");
        servletRegistrationBean.setName("webService");
        return servletRegistrationBean;
    }
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public DemoService demoJsonService(){
        return new DemoServiceImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), demoJsonService());
        endpoint.publish("/ws");
        //endpoint.getInInterceptors().add(new WsInterceptor()); //add webservice inteceptor
        return endpoint;
    }
    
    
    /**
     * 在将CXF集成之后，WebService服务能够正常访问，但是原先的http服务不能访问 查阅资料后发现在springboot程序中默认注册的是
     * dispatcherServlet，在发不了WebService服务之后，相当于手动配置
     * ServletRegistrationBean，这时springboot不会再去注册默认的dispatcherServlet，解决办法就是需要我们在启动类里手动去注册一个dispatcherServlet
     */
    @Bean
    public ServletRegistrationBean restServlet() {
        // 注解扫描上下文
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        // 项目包名
        applicationContext.scan("com.ywjs.controller");
        DispatcherServlet rest_dispatcherServlet = new DispatcherServlet(applicationContext);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(rest_dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/*");
        return registrationBean;
    }
}
