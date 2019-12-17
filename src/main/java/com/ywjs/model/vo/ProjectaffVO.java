package com.ywjs.model.vo;

import java.io.Serializable;

/**
 * @author zhouwei
 * @create 2019-12-10 11:48
 */
public class ProjectaffVO implements Serializable {

    //工程备份表ID
    private Long projectaffid;
    //工程备份表外键（工程表ID）
    private Long  projectid;
    //备份名称：备份1、备份2、备份3、
    private String projectname;

    public Long getProjectaffid() {
        return projectaffid;
    }

    public void setProjectaffid(Long projectaffid) {
        this.projectaffid = projectaffid;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }
}
