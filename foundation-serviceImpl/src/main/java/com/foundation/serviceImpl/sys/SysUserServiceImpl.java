package com.foundation.serviceImpl.sys;

import com.foundation.dao.sys.cache.SysUserCache;
import com.foundation.dao.sys.entry.SysUser;
import com.foundation.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joey on 15-1-7.
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserCache sysUserCache;

    @Override
    public SysUser queryById(Long id) throws Exception {
      return sysUserCache.getUserById(id);
    }
}
