package com.fh.common;

/**
 * @author winter
 * @create 2020-09-27 10:50
 */
public class ServerResponse {
    private Integer code;
    private Object data;
    private String message;

    public static ServerResponse success(Object data){
        return new ServerResponse(ServerEnum.SUCCESS.getCode(),data, ServerEnum.SUCCESS.getMessage());
    }
    public static ServerResponse success(){
        return new ServerResponse(ServerEnum.SUCCESS.getCode(),null, ServerEnum.SUCCESS.getMessage());
    }
    public static ServerResponse error(String message){
        return new ServerResponse(ServerEnum.ERROR.getCode(),null, message);
    }
    public static ServerResponse error(){
        return new ServerResponse(ServerEnum.ERROR.getCode(),null, ServerEnum.ERROR.getMessage());
    }
    public static ServerResponse error_login(){
        return new ServerResponse(ServerEnum.ERROE_LOGIN.getCode(),null, ServerEnum.ERROE_LOGIN.getMessage());
    }


    @Override
    public String toString() {
        return "ServerResponse{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public ServerResponse(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
