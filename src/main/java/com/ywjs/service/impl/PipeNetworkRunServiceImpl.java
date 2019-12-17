/** 
 * @file: PipeNetworkRunServiceImpl.java 
 * @Package： com.ywjs.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月22日 下午2:58:59 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ywjs.mapper.EarlyWarningMapper;
import com.ywjs.mapper.PropertyMapper;
import com.ywjs.model.entity.EarlyWarning;
import com.ywjs.model.entity.EarlyWarningExample;
import com.ywjs.model.entity.Property;
import com.ywjs.service.PipeNetworkRunService;


/**
 * @ClassName PipeNetworkRunServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用) 
 * @Author 周伟
 * @Date 2019年11月22日 下午2:58:59
 */
@Service("pipeNetworkRunService")
@Transactional(rollbackFor = Exception.class)
public class PipeNetworkRunServiceImpl implements PipeNetworkRunService {

    /** 预报警及案例库*/
    @Autowired
    EarlyWarningMapper earlyWarningMapper;
    /** 属性dao接口 */
    @Autowired
    PropertyMapper propertyMapper;
    
    @Override
    public void saveEarlyWarning(EarlyWarning earlyWarning) {
        earlyWarningMapper.insertSelective(earlyWarning);
    }

    @Override
    public List<EarlyWarning> getEarlyWarning() {
        EarlyWarningExample example = new EarlyWarningExample();
        example.setOrderByClause("EARWARID_EARWAR desc");
        List<EarlyWarning> listEarlyWarning = earlyWarningMapper.selectByExample(example);
        //根据属性编号获取属性名称
        for (int i = 0; i < listEarlyWarning.size(); i++) {
            Property property = propertyMapper.selectByPrimaryKey(Long.parseLong(listEarlyWarning.get(i).getPropertyidPro()));
            // 将属性名称添加到列表相应对象中
            listEarlyWarning.get(i).setPropertyName(property.getTitle());
        }
        return listEarlyWarning;
    }

    @Override
    public void deleteBatchEarlyWarning(Long[] ids) {
        if(ids != null && ids.length > 0){
            for (Long i : ids) {
                earlyWarningMapper.deleteByPrimaryKey(i);
            }
        }       
    }

}
