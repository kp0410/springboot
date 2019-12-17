package com.ywjs.model.vo;

import java.io.Serializable;

/**
 * @author zhouwei
 * @create 2019-12-10 11:45
 */
public class ProjectVO implements Serializable {

    //工程表ID
    //工程名称
    private Long projectid;
    private String projectname;

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
