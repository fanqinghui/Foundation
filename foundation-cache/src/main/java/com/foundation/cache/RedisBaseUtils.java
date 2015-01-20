package com.foundation.cache;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import redis.clients.jedis.*;
import redis.clients.util.ShardInfo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * <p>Created by: qingHui
 * <p>Date: 15-1-8 下午3:50
 * <p>Version: 1.0
 */
public class RedisBaseUtils {
    static Logger logger = LoggerFactory.getLogger(RedisBaseUtils.class);

    private static String ip = "127.0.0.1";
    private static Integer host = 6379;
    private static int maxActive = 5;
    //private static int minIdle=5;
    private static int maxIdle = 50;
    private static int maxWait = 1000;
    private static boolean testOnBorrow = true;
    private static Jedis jedis = null;
    private static JedisPoolConfig poolConfig = new JedisPoolConfig();
    private static JedisPool jedisPool;
    //private static Pipeline pile=null;
    private static ShardedJedisPool shardedJedisPool = null;


    static {
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("redis.properties");
            ip = properties.get("redis.ip").toString();
            host = Integer.valueOf(properties.get("redis.port").toString());
            maxActive = Integer.valueOf(properties.get("redis.pool.maxActive").toString());
            maxIdle = Integer.valueOf(properties.get("redis.pool.maxWait").toString());
            //minIdle=Integer.valueOf(properties.get("redis.pool.maxIdle").toString());
            maxWait = Integer.valueOf(properties.get("redis.pool.maxWait").toString());
            testOnBorrow = Boolean.valueOf(properties.get("redis.pool.testOnBorrow").toString());

            poolConfig.setMaxActive(maxActive);
            poolConfig.setMaxIdle(maxIdle);
            // poolConfig.setMinIdle(minIdle);
            poolConfig.setMaxWait(maxWait);
            poolConfig.setTestOnBorrow(testOnBorrow);
        } catch (IOException e) {
            logger.error("读取配置文件出错" + e.getLocalizedMessage());
            // e.printStackTrace();
        }
    }

    private RedisBaseUtils() {
    }

    /**
     * 直接返回jedis方式.
     *
     * @return
     */
    public static Jedis getJedisInstanse() {
        if (null == jedis) {
            synchronized (ip) {
                if (null == jedis) {
                    jedis = new Jedis(ip, host);
                }
            }
        }
        return jedis;
    }

    /**
     * 返回jedisPool连接池方式
     *
     * @return
     */
    public static JedisPool getJedisPoolInstanse() {
        if (jedisPool == null) {
            synchronized (poolConfig) {
                if (jedisPool == null) {
                    jedisPool = new JedisPool(poolConfig, ip, host);
                }
            }
        }
        return jedisPool;
    }

    /**
     * 获取PileLine管道
     *
     * @return
     */
    public static Pipeline getJedisPipeLine() {
        return getJedisPoolInstanse().getResource().pipelined();
    }

    /**
     * 获取shardedJedis
     *
     */
    public static ShardedJedis getSharedJedis() {
        if (shardedJedisPool == null) {
            synchronized (poolConfig) {
                if (shardedJedisPool == null) {
                    List<JedisShardInfo> shardInfoList = Lists.newArrayList();
                    shardInfoList.add(new JedisShardInfo(ip, host, "master"));
                    shardedJedisPool = new ShardedJedisPool(poolConfig, shardInfoList);
                }
            }
        }
        return shardedJedisPool.getResource();
    }
}
