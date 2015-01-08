package com.foundation.service;

import com.foundation.dao.sys.entry.SysUser;

/**
 * Created by joey on 15-1-7.
 */
public interface SysUserService {

    public SysUser queryById(Long id) throws Exception;
}
