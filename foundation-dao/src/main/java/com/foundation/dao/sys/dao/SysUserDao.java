package com.foundation.dao.sys.dao;

import com.foundation.dao.sys.entry.SysUser;
import org.springframework.stereotype.Repository;

/**
 * <p>Created by: qingHui
 * <p>Date: 15-1-8 下午4:26
 * <p>Version: 1.0
 */
@Repository
public class SysUserDao {

    public SysUser getUserById(Long id){
        SysUser user=new SysUser();
        user.setUserName("fqh");
        user.setTelphone("1921222");
        user.setId(id);
        return user;
    }
}
