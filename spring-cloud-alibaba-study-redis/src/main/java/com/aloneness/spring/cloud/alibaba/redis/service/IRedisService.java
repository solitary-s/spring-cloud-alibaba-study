package com.aloneness.spring.cloud.alibaba.redis.service;

/**
 * Redis Service
 *
 * @author aloneness
 * @date 2020/7/1
 */
public interface IRedisService {

    /**
     * 设置
     *
     * @param key
     * @param object
     * @param seconds
     */
    public void set(String key, Object object, long seconds);

    /**
     * 获取
     *
     * @param key
     * @return
     */
    public Object get(String key);

    /**
     * 获取
     *
     * @return
     */
    public Object getAll();
}
