package com.foundation.serviceImpl.sys;

import com.foundation.dao.po.sys.SysUser;
import com.foundation.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * Created by joey on 15-1-7.
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Override
    public SysUser queryById(Long id) throws Exception {
       SysUser user=new SysUser();
        user.setUserName("fqh");
        user.setTelphone("1921222");
        user.setId(id);
        return user;
    }
}
