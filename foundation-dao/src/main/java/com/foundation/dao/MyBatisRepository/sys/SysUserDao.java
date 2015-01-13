package com.foundation.dao.MyBatisRepository.sys;

import com.foundation.dao.entry.sys.SysUser;
import com.fundation.util.annocation.MyBatisRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Created by: qingHui
 * <p>Date: 15-1-8 下午4:26
 * <p>Version: 1.0
 */
@MyBatisRepository
@Repository
public interface SysUserDao{
  public SysUser queryById(Long id);
}

