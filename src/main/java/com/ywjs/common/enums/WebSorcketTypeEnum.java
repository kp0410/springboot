package com.ywjs.common.enums;

/**
 * @author zhouwei
 * @create 2019-12-11 11:41
 */
public enum WebSorcketTypeEnum {

    RealTimePush("0", "实时推送"),
    HydratesAnalyze("1", "水合物分析");

    private String flag = null;
    private String name = null;

    private WebSorcketTypeEnum(String flag, String name) {
        this.flag = flag;
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
