package com.gzxant.config.cache;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * ehcache配置
 *
 * @author chen
 */
@Configuration
@EnableCaching
public class CacheConfig {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    @Bean(name = "ehCacheManager")
    public EhCacheManager ehCacheManager() {
        logger.info("--------------ehCacheManager init---------------");
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:cache/ehcache-shiro.xml");
        logger.info("--------------ehCacheManager init---------------" + cacheManager);
        return cacheManager;
    }

    @Bean(name = "redisCacheManager")
    @Primary
    public RedisCacheManager redisCacheManager() {
        logger.info("--------------redis cache init---------------");
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        logger.info("--------------redis cache ---------------" + redisCacheManager);
        return redisCacheManager;
    }


    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.database}")
    private int database;

    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPassword(password);
        redisManager.setPort(port);
        redisManager.setDatabase(database);
        return redisManager;
    }

}
