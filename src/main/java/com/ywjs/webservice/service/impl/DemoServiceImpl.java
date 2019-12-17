package com.ywjs.webservice.service.impl;

import com.ywjs.webservice.service.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String test(String param) {
        //System.out.println("webservice 服务端接收参数： " + param);
        //"webservice 服务端返回数据:"+param;
        return "你好 , "+param;
    }
}
