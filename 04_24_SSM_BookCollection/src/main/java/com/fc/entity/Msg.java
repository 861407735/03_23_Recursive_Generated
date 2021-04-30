package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装信息返回给前端
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Msg {
    private Integer code;   //状态码 100成功   200执行失败
    private String message;
    private Map<String,Object> extend=new HashMap<>();

    public static Msg success(){
        Msg result=new Msg();
        result.setCode(100);
        result.setMessage("执行成功");
        return result;
    }
    public static Msg fail(){
        Msg result=new Msg();
        result.setCode(200);
        result.setMessage("处理失败");
        return result;
    }
    public Msg add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

}
