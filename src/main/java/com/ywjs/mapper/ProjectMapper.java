package com.ywjs.mapper;

import com.ywjs.model.entity.Project;
import com.ywjs.model.entity.ProjectExample;
import com.ywjs.model.vo.ProjectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {

    List<ProjectVO> selectAllToProjectVO();

    void insertSelectiveBatch(List<Project> list);

    List<Project> selectAll();

    int countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(Long projectidPro);

    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(Long projectidPro);

    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}
