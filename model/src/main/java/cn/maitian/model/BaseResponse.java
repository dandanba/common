package cn.maitian.model;


/**
 * Created by geng on 2016/7/21.
 */
public class BaseResponse {
    public String message;
    public int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
