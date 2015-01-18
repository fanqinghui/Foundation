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
public abstract class BaseRedisCache<T> implements BaseCache{
    protected Class obj;

    Jedis jedis= RedisBaseUtils.getJedisInstanse();

    public Class getObj() {
        return obj;
    }
    abstract  public  void setObj(Class obj);

    @Override
    public String getPrefixKey() {
        if(obj!=null){
            return getObj().getSimpleName();
        }
        return "";
    }

    /**
     * 往redis里set值
     */
    public String setString(String key,String value){
       return jedis.set(key,value);
    }

    public String setExString(String key,String value,int seconds){
        return jedis.setex(key, seconds, value);
    }
    public String set(String key,T t){
        String value=JsonMapper.nonDefaultMapper().toJson(t).toString();
        return setString(key,value);
    }
    public String set(String key,T t,int secondes){
        String value=JsonMapper.nonDefaultMapper().toJson(t).toString();
        return setExString(this.getPrefixKey() + key, value ,secondes);
    }
    /**
     * get相关
     */

}
