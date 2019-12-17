package com.ywjs.model.dto;

import java.io.Serializable;
/**
 * @ClassName OpenProjectDTO
 * @Description 获取管段模拟结果 参数
 * @Author 黄存磊
 * @Date 2019年12月1日 下午5:40:48
 */
public class PiPeidList implements Serializable {
    public String getPipeid() {
        return pipeid;
    }

    public void setPipeid(String pipeid) {
        this.pipeid = pipeid;
    }

    public String getPipename() {
        return pipename;
    }

    public void setPipename(String pipename) {
        this.pipename = pipename;
    }

    private String pipeid;
    private  String  pipename;

    public PiPeidList(String pipeid, String pipename) {
        this.pipeid = pipeid;
        this.pipename = pipename;
    }

    public PiPeidList(){}
}
