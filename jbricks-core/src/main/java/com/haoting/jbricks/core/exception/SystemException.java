package com.haoting.jbricks.core.exception;


import com.haoting.jbricks.core.result.EnumStatus;
import com.haoting.jbricks.core.result.StatusCode;

/**
 * @Description: 系统异常类
 * @author caimiao
 */
public class SystemException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private EnumStatus status;
    private String msg;

    public SystemException() {
        this(StatusCode.UNKNOW_ERROR);
    }


    public SystemException(EnumStatus status,String msg) {
        super(msg);
        this.status = status;
    }

    public SystemException(EnumStatus status) {
        this(status,status.getMsg());
    }

    public SystemException(EnumStatus status,String msg,Throwable cause) {
        super(msg, cause);
        this.status = status;
    }
    public SystemException(EnumStatus status, Throwable cause) {
        this(status,status.getMsg(),cause);
    }



    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
