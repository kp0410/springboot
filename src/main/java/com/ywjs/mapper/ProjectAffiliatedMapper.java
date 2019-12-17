package com.ywjs.mapper;

import com.ywjs.model.entity.ProjectAffiliated;
import com.ywjs.model.entity.ProjectAffiliatedExample;
import com.ywjs.model.vo.ProjectaffVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectAffiliatedMapper {

    List<ProjectaffVO> selectAllToProjectAff();
    //查询倒数记录
    ProjectAffiliated selectReverse(Long condition);
    
    int selectMaxKey();
    
    int countByExample(ProjectAffiliatedExample example);

    int deleteByExample(ProjectAffiliatedExample example);

    int deleteByPrimaryKey(Long projectidProaff);

    int insert(ProjectAffiliated record);

    int insertSelective(ProjectAffiliated record);

    List<ProjectAffiliated> selectByExample(ProjectAffiliatedExample example);

    ProjectAffiliated selectByPrimaryKey(Long projectidProaff);

    int updateByExampleSelective(@Param("record") ProjectAffiliated record, @Param("example") ProjectAffiliatedExample example);

    int updateByExample(@Param("record") ProjectAffiliated record, @Param("example") ProjectAffiliatedExample example);

    int updateByPrimaryKeySelective(ProjectAffiliated record);

    int updateByPrimaryKey(ProjectAffiliated record);
}