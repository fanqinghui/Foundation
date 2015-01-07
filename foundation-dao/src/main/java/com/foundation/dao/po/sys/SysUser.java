package com.foundation.dao.po.sys;

import com.foundation.dao.po.BasePo;

/**
 * Created by joey on 15-1-7.
 */
public class SysUser extends BasePo {

    private String userName;
    private String email;
    private String telphone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelphone() {

        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
