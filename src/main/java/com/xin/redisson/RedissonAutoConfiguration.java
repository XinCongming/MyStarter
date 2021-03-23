package com.xin.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xinBa.
 * User: 辛聪明
 * Date: 2021/3/23
 */
@ConditionalOnClass(Redisson.class)   //条件装配  导入Redisson包依赖才注入bean
@EnableConfigurationProperties(RedissonProperties.class)   //模块驱动注入到IOC
@Configuration
public class RedissonAutoConfiguration {

    @Bean
    public RedissonClient getClient(RedissonProperties redissonProperties){  //必须提前注入IOC中
        Config config = new Config();
        String prefix = "redis://";
        if(redissonProperties.isSsl()) prefix = "rediss://";   //ssl加密
        SingleServerConfig singleServerConfig = config.useSingleServer()
                .setAddress(prefix + redissonProperties.getHost() + ":" + redissonProperties.getPort())
                .setTimeout(redissonProperties.getTimeout())
                .setPassword(redissonProperties.getPassword());
        return Redisson.create(config);
    }

}
