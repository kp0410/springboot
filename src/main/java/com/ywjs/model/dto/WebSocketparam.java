package com.ywjs.model.dto;

import java.io.Serializable;
import java.util.List;
/**
 * @ClassName OpenProjectDTO
 * @Description WebSocket接受的参数
 * @Author 黄存磊
 * @Date 2019年12月1日 下午5:40:48
 */
public class WebSocketparam implements Serializable {
    //1:获取管段模拟结果 参数
    //2:
    private  String paramtype;
    // 获取管段模拟结果 参数
    private List<PiPeidList> pipeidlist;
    // 获取节点模拟结果 参数
    private List<ElementName> elementNameList;

    public List<ElementName> getElementNameList() {
        return elementNameList;
    }

    public void setElementNameList(List<ElementName> elementNameList) {
        this.elementNameList = elementNameList;
    }

    public String getParamtype() {
        return paramtype;
    }

    public void setParamtype(String paramtype) {
        this.paramtype = paramtype;
    }

    public List<PiPeidList> getPipeidlist() {
        return pipeidlist;
    }

    public void setPipeidlist(List<PiPeidList> pipeidlist) {
        this.pipeidlist = pipeidlist;
    }
}
