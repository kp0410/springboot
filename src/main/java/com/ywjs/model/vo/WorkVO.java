package com.ywjs.model.vo;

/**
 * @author zhouwei
 * @create 2019-12-10 11:51
 */
public class WorkVO {

    //工况表编号
   private Long workid;
    //工况名称
    private String workname;
    //工况表外键（工程表ID）
    private Long projectaffid;

    public Long getWorkid() {
        return workid;
    }

    public void setWorkid(Long workid) {
        this.workid = workid;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public Long getProjectaffid() {
        return projectaffid;
    }

    public void setProjectaffid(Long projectaffid) {
        this.projectaffid = projectaffid;
    }
}
