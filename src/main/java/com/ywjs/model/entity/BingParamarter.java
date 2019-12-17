package com.ywjs.model.entity;

public class BingParamarter extends BaseEnitiy {

    private String name;
    private String filename;
    private int type;
    private int issum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIssum() {
        return issum;
    }

    public void setIssum(int issum) {
        this.issum = issum;
    }
}
