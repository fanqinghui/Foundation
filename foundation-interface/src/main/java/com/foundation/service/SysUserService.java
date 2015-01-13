package com.foundation.service;

import com.foundation.dao.entry.sys.SysUser;

/**
 * Created by joey on 15-1-7.
 */
public interface SysUserService {

    public SysUser queryById(Long id) throws Exception;
}
