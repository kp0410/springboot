package com.ywjs.service.impl;


import com.ywjs.mapper.BaseDao;
import com.ywjs.mapper.BingParamarterDao;
import com.ywjs.model.entity.BingParamarter;
import com.ywjs.model.query.QueryBingParamarter;
import com.ywjs.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
@WebService(//对外发布的服务名serviceName="BingParamarterService",
        targetNamespace="http://impl.service.ywjs.com"//,指定你想要的名称空间，通常使用使用包名反转
        //endpointInterface="com.ywjs.service.impl.BingParamarterService"
        )
//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
@Service
@Transactional
public class BingParamarterService extends BaseService<BingParamarter, QueryBingParamarter> {

    @Autowired
    private BingParamarterDao bingParamarterDao;

    @Override
    protected BaseDao<BingParamarter, QueryBingParamarter> getDao() {
        return bingParamarterDao;
    }

}