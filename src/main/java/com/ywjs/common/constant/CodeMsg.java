package com.ywjs.common.constant;

public class CodeMsg {

    private int code;
    private String msg;

    // 通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(200, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(201, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg PARAMETER_VALIDATION = new CodeMsg(500102, "参数错误！");
    public static CodeMsg REFLECT_ERROR = new CodeMsg(500103, "反射异常！");
    

    // 各个模块 5002XX

    // 管网物理模型500200
    public static CodeMsg PGGWMO_DELBYPROJECTID_ERROR = new CodeMsg(500200, "该工程名已存在，请重新输入！");
    public static CodeMsg PGGWMO_HTTPCLIENT_ERROR = new CodeMsg(500200, "HttpClient调用远程实时数据接口异常！");

    public static CodeMsg PGGWMO_REALTIMEINTERFACE_ERROR = new CodeMsg(500200, "远程调用实时数据接口异常！");

    // getRecursiveRealTimeData
    public static CodeMsg TIMINGTASK_GETREALTIMEDATA_ERROR = new CodeMsg(500200, "定时任务获取实时数据异常");
    
    // 管网仿真模拟

    private CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }

}
