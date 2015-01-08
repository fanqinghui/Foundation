package com.foundation.dao.sys.cache;

import com.foundation.dao.sys.dao.SysUserDao;
import com.foundation.dao.sys.entry.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>Created by: qingHui
 * <p>Date: 15-1-8 下午3:21
 * <p>Version: 1.0
*/
@Component
public class SysUserCache {

    @Autowired
    SysUserDao sysUserDao;

    public SysUser getUserById(Long id)throws Exception{
        return sysUserDao.getUserById(id);
    }
}
