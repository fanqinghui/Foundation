package com.foundation.cache.sys;

import com.alibaba.fastjson.JSON;
import com.foundation.cache.RedisBaseUtils;
import com.foundation.dao.sys.dao.SysUserDao;
import com.foundation.dao.sys.entry.SysUser;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

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
        SysUser user=null;
        Jedis jedis= RedisBaseUtils.getJedisInstanse();
        if(jedis.exists(""+id)){
            System.out.println(jedis.get(id+""));
            user= JSON.parseObject(jedis.get(id+""),SysUser.class);
          // user= sysUserDao.getUserById(id);
        }else{
             user=sysUserDao.getUserById(id);
            jedis.set(""+id,JSON.toJSONString(user));
        }
        return user;
    }
}
