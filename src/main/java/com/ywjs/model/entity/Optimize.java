package com.ywjs.model.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName Optimize
 * @Description TODO(管理运行方案优化实体) 
 * @Author 周伟
 * @Date 2019年11月26日 下午4:12:30
 */
public class Optimize implements Serializable {
    private String optimidOptim; //id

    private String optimnameOptim; //方案名称

    private String optimusernameOptim; //用户名

    private Long workidWork; //工况id

    private Long workidendWork; //优化后工况id

    private Date createdateOptim; //创建时间

    private String remarkOptim; //备注

    private static final long serialVersionUID = 1L;

    public String getOptimidOptim() {
        return optimidOptim;
    }

    public void setOptimidOptim(String optimidOptim) {
        this.optimidOptim = optimidOptim == null ? null : optimidOptim.trim();
    }

    public String getOptimnameOptim() {
        return optimnameOptim;
    }

    public void setOptimnameOptim(String optimnameOptim) {
        this.optimnameOptim = optimnameOptim == null ? null : optimnameOptim.trim();
    }

    public String getOptimusernameOptim() {
        return optimusernameOptim;
    }

    public void setOptimusernameOptim(String optimusernameOptim) {
        this.optimusernameOptim = optimusernameOptim == null ? null : optimusernameOptim.trim();
    }

    public Long getWorkidWork() {
        return workidWork;
    }

    public void setWorkidWork(Long workidWork) {
        this.workidWork = workidWork;
    }

    public Long getWorkidendWork() {
        return workidendWork;
    }

    public void setWorkidendWork(Long workidendWork) {
        this.workidendWork = workidendWork;
    }

    public Date getCreatedateOptim() {
        return createdateOptim;
    }

    public void setCreatedateOptim(Date createdateOptim) {
        this.createdateOptim = createdateOptim;
    }

    public String getRemarkOptim() {
        return remarkOptim;
    }

    public void setRemarkOptim(String remarkOptim) {
        this.remarkOptim = remarkOptim == null ? null : remarkOptim.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", optimidOptim=").append(optimidOptim);
        sb.append(", optimnameOptim=").append(optimnameOptim);
        sb.append(", optimusernameOptim=").append(optimusernameOptim);
        sb.append(", workidWork=").append(workidWork);
        sb.append(", workidendWork=").append(workidendWork);
        sb.append(", createdateOptim=").append(createdateOptim);
        sb.append(", remarkOptim=").append(remarkOptim);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}