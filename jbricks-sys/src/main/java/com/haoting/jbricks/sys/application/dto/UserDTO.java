package com.haoting.jbricks.sys.application.dto;

/**
 * @author haoting.wang
 * @Date 2018/7/22
 */
public class UserDTO {

    private String name;

    private String idCardNo;

    private String mobile;

    private Short age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }
}
