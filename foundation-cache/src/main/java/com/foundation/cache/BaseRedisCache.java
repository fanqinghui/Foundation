package com.foundation.cache;

import com.alibaba.fastjson.JSON;
import com.foundation.dao.entry.sys.SysUser;
import common.json.JsonMapper;
import redis.clients.jedis.Jedis;

/**
 * <p>Created by: qingHui
 * <p>Date: 15-1-14 上午11:14
 * <p>Version: 1.0
 */
public class BaseRedisCache<T> implements BaseCache{

    Jedis jedis=RedisBaseUtils.getJedisPoolInstanse().getResource();//jedisPool连接池方式
    // RedisBaseUtils.getJedisInstanse();//jedis单实例方式

    /**
     * 往redis里set值
     */
    public  String setString(String key,String value){
       return jedis.set(key,value);
    }

    public String setExString(String key,String value,int seconds){
        return jedis.setex(key, seconds, value);
    }
    public String setObject(String key,T t){
        String value=JsonMapper.nonDefaultMapper().toJson(t).toString();
        return setString(key,value);
    }
    public String setExObject(String key,T t,int secondes){
        String value=JsonMapper.nonDefaultMapper().toJson(t).toString();
        return setExString(this.getPrefixKey(t.getClass()) + key, value ,secondes);
    }

    public boolean exists(String key){
        return  jedis.exists(key);
    }
    /**
     * get相关
     */
    public String getString(String key){
        return jedis.get(key);
    }

    public Object getObject(String key,Class obj){
        if(exists(key)) {
            return  JSON.parseObject(getString(key),obj);
        }
        return null;
    }

    @Override
    public String getPrefixKey(Class obj) {
        return obj.getSimpleName();
    }
}
