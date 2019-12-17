package com.ywjs.mapper;

import com.ywjs.model.entity.Element;
import com.ywjs.model.entity.ElementExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @ClassName ElementMapper
 * @Description 元件拓扑表mapper
 * @Author 周伟
 * @Date 2019年12月3日 上午11:45:19
 */
public interface ElementMapper {
    
    void insertBatch(List<Element> list);
    
    int countByExample(ElementExample example);

    int deleteByExample(ElementExample example);

    int deleteByPrimaryKey(Integer elementidEle);

    int insert(Element record);

    int insertSelective(Element record);

    List<Element> selectByExample(ElementExample example);

    Element selectByPrimaryKey(Integer elementidEle);

    int updateByExampleSelective(@Param("record") Element record, @Param("example") ElementExample example);

    int updateByExample(@Param("record") Element record, @Param("example") ElementExample example);

    int updateByPrimaryKeySelective(Element record);

    int updateByPrimaryKey(Element record);
}