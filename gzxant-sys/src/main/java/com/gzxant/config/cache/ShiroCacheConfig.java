package com.gzxant.config.cache;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * ehcache配置
 *
 * @author chen
 */
@Configuration
@EnableCaching
public class ShiroCacheConfig {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean(name = "shiroRedisCacheManager")
    @Primary
    public ShiroRedisCacheManager slifeRedisCacheManager() {
        logger.info("--------------redis cache init---------------");
        ShiroRedisCacheManager gzxantRedisCacheManager = new ShiroRedisCacheManager();
        gzxantRedisCacheManager.setRedisTemplate(redisTemplate);
        logger.info("--------------redis cache ---------------" + gzxantRedisCacheManager);
        return gzxantRedisCacheManager;
    }

}
