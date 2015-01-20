package com.foundation.cache.sys;

import com.alibaba.fastjson.JSON;
import com.foundation.cache.BaseRedisCache;
import com.foundation.cache.RedisBaseUtils;
import com.foundation.dao.MyBatisRepository.sys.SysUserDao;
import com.foundation.dao.entry.sys.SysUser;
import common.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * <p>Created by: qingHui
 * <p>Date: 15-1-8 下午3:21
 * <p>Version: 1.0
*/
@Component
public class SysUserCache extends BaseRedisCache<SysUser> {

    Logger logger= LoggerFactory.getLogger(SysUserCache.class);

    @Autowired
    SysUserDao sysUserDao;

    public SysUser getUserById(Long id)throws Exception{
        SysUser user=null;
        if(exists(getPrefixKey(SysUser.class) + id)){
            user= (SysUser) getObject(getPrefixKey(SysUser.class)+id,SysUser.class);
        }else{
             user=sysUserDao.queryById(id);
            if(user!=null) {
                logger.info(SysUser.class.getSimpleName()+id+"redis set result: "+setObject(getPrefixKey(SysUser.class) + id, user));
            }
        }
        return user;
    }


}
