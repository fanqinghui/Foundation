package com.foundation.cache.sys;

import com.alibaba.fastjson.JSON;
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
public class SysUserCache  {

    Logger logger= LoggerFactory.getLogger(SysUserCache.class);

    @Autowired
    SysUserDao sysUserDao;

    public SysUser getUserById(Long id)throws Exception{
        SysUser user=null;
        Jedis jedis= RedisBaseUtils.getJedisInstanse();
        if(jedis.exists(""+id)){
            System.out.println(jedis.get(id+""));
            user= JSON.parseObject(jedis.get(id+""),SysUser.class);
        }else{
             user=sysUserDao.queryById(id);
            if(user!=null) {
              //  String result = jedis.set("" + id, JSON.toJSONString(user));
                String result=jedis.setex("" + id, 20, JsonMapper.nonDefaultMapper().toJson(user).toString());
                logger.info("redis set result: "+result);
            }

        }
        return user;
    }
}
