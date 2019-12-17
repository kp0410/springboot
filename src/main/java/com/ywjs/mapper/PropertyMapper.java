package com.ywjs.mapper;

import com.ywjs.model.entity.Property;
import com.ywjs.model.entity.PropertyExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropertyMapper {
    
    List<Property> selectAll();
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    int countByExample(PropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    int deleteByExample(PropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    int deleteByPrimaryKey(Integer propertyidPro);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    int insert(Property record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    int insertSelective(Property record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    List<Property> selectByExample(PropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    Property selectByPrimaryKey(Long propertyidPro);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    int updateByExampleSelective(@Param("record") Property record, @Param("example") PropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    int updateByExample(@Param("record") Property record, @Param("example") PropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    int updateByPrimaryKeySelective(Property record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    int updateByPrimaryKey(Property record);
}