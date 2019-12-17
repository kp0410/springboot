package com.ywjs;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@EnableAsync  //开启异步注解功能
@EnableScheduling //开启基于注解的定时任务
@EnableTransactionManagement //开启事务的支持
@EnableCaching //开启基于注解的缓存
@SpringBootApplication
@MapperScan("com.ywjs.mapper")
@EnableSwagger2Doc //swagger2测试注解
//@ImportResource("classpath:transaction.xml")
public class YwjsApplication {
    
    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.put("org.apache.cxf.stax.maxChildElements", "500000");
        SpringApplication.run(YwjsApplication.class, args);
    }

}
