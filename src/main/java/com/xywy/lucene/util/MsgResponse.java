package com.xywy.lucene.util;

import java.util.HashMap;
import java.util.Map;

public class MsgResponse
{

    //状态码，成功200，失败400
    private int code;

    //错误和成功信息
    private String msg;

    //包含的数据
    private Map<String, Object> extend = new HashMap<>();

    //成功信息
    public static MsgResponse success()
    {
        MsgResponse msg = new MsgResponse();
        msg.setCode(200);
        msg.setMsg("处理成功!");
        return msg;
    }

    //成功信息
    public static MsgResponse fail()
    {
        MsgResponse msg = new MsgResponse();
        msg.setCode(400);
        msg.setMsg("处理失败!");
        return msg;
    }

    //添加包含的数据
    public MsgResponse add(String key, Object value)
    {
        this.getExtend().put(key, value);
        return this;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Map<String, Object> getExtend()
    {
        return extend;
    }

    public void setExtend(Map<String, Object> extend)
    {
        this.extend = extend;
    }

}