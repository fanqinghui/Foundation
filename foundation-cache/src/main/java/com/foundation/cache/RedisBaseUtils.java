package com.foundation.cache;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Properties;

/**
 * <p>Created by: qingHui
 * <p>Date: 15-1-8 下午3:50
 * <p>Version: 1.0
 */
public class RedisBaseUtils {

    static{
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("redis.properties");
            ip=properties.get("redis.ip").toString();
            host=Integer.valueOf(properties.get("redis.host").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String ip="127.0.0.1";
    private static Integer host=6379;
    private static Jedis jedis=null;
    private RedisBaseUtils(){}
    public static Jedis getJedisInstanse(){
        if(null==jedis){
            synchronized (ip){
                if(null==jedis){
                    jedis=new Jedis(ip,host);
                }
            }
        }
        return jedis;
    }
}
