package com.ywjs.mapper;

import com.ywjs.model.entity.ElementNode;
import com.ywjs.model.entity.ElementNodeExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElementNodeMapper {
    
    void insertBatch(List<ElementNode> list);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELEMENT_NODE_TBL
     *
     * @mbggenerated Wed Nov 13 18:21:09 CST 2019
     */
    int countByExample(ElementNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELEMENT_NODE_TBL
     *
     * @mbggenerated Wed Nov 13 18:21:09 CST 2019
     */
    int deleteByExample(ElementNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELEMENT_NODE_TBL
     *
     * @mbggenerated Wed Nov 13 18:21:09 CST 2019
     */
    int deleteByPrimaryKey(Integer nodeidNdl);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELEMENT_NODE_TBL
     *
     * @mbggenerated Wed Nov 13 18:21:09 CST 2019
     */
    int insert(ElementNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELEMENT_NODE_TBL
     *
     * @mbggenerated Wed Nov 13 18:21:09 CST 2019
     */
    int insertSelective(ElementNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELEMENT_NODE_TBL
     *
     * @mbggenerated Wed Nov 13 18:21:09 CST 2019
     */
    List<ElementNode> selectByExample(ElementNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELEMENT_NODE_TBL
     *
     * @mbggenerated Wed Nov 13 18:21:09 CST 2019
     */
    ElementNode selectByPrimaryKey(Integer nodeidNdl);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELEMENT_NODE_TBL
     *
     * @mbggenerated Wed Nov 13 18:21:09 CST 2019
     */
    int updateByExampleSelective(@Param("record") ElementNode record, @Param("example") ElementNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELEMENT_NODE_TBL
     *
     * @mbggenerated Wed Nov 13 18:21:09 CST 2019
     */
    int updateByExample(@Param("record") ElementNode record, @Param("example") ElementNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELEMENT_NODE_TBL
     *
     * @mbggenerated Wed Nov 13 18:21:09 CST 2019
     */
    int updateByPrimaryKeySelective(ElementNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELEMENT_NODE_TBL
     *
     * @mbggenerated Wed Nov 13 18:21:09 CST 2019
     */
    int updateByPrimaryKey(ElementNode record);
}