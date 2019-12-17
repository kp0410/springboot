package com.ywjs.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhouwei
 * @create 2019-12-10 14:08
 */
public class GetProjectandAffandWorkVO implements Serializable {

    List<ProjectVO> projectlist ;
    List<ProjectaffVO> projectafflist ;
    List<WorkVO> worklist ;

    public List<ProjectVO> getProjectlist() {
        return projectlist;
    }

    public void setProjectlist(List<ProjectVO> projectlist) {
        this.projectlist = projectlist;
    }

    public List<ProjectaffVO> getProjectafflist() {
        return projectafflist;
    }

    public void setProjectafflist(List<ProjectaffVO> projectafflist) {
        this.projectafflist = projectafflist;
    }

    public List<WorkVO> getWorklist() {
        return worklist;
    }

    public void setWorklist(List<WorkVO> worklist) {
        this.worklist = worklist;
    }
}
