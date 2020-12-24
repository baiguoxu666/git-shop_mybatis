package com.bgx;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class JsonView {
    private Integer errcode=0; //0为成功

    private String message;

    private Object data;

    public static String render(Object data){
        JsonView tmp = new JsonView(0, "success",data);
        return JSONObject.toJSONString(tmp);
    }

    public static String render(Integer errcode){
        JsonView tmp = new JsonView(errcode, "");
        return JSONObject.toJSONString(tmp);
    }

    public static String render(Integer errcode, String message){
        JsonView tmp = new JsonView(errcode, message);
        return JSONObject.toJSONString(tmp);
    }

    public static String render(Integer errcode, String message, Object data){
        JsonView tmp = new JsonView(errcode, message, data);
        return JSONObject.toJSONString(tmp);
    }

    public JsonView(Integer errcode, String message, Object data) {
        this.errcode = errcode;
        this.message = message;
        this.data = data;
    }

    public JsonView(Integer errcode, String message) {
        this.errcode = errcode;
        this.message = message;
    }

    public JsonView(Integer errcode) {
        this.errcode = errcode;
    }

    public JsonView() {
    }
}
