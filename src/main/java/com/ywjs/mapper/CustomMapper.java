/** 
 * @file: CustomMapper.java 
 * @Package： com.ywjs.mapper 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月27日 上午10:28:34 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.mapper;

import com.ywjs.model.vo.GetProjectandAffandWorkVO;
import com.ywjs.model.vo.SimulationlistVO;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CustomMapper
 * @Description TODO(这里用一句话描述这个类的作用) 
 * @Author 周伟
 * @Date 2019年11月27日 上午10:28:34
 */
public interface CustomMapper {

    List<GetProjectandAffandWorkVO> getProjectandAffandWorkVO();
    
    List<SimulationlistVO> selectJointSimulation(HashMap<String,Long> map);
    
    List<SimulationlistVO> selectSimulationByAffId(Long id);

    int deleteAllRealtimesimResult();
}
