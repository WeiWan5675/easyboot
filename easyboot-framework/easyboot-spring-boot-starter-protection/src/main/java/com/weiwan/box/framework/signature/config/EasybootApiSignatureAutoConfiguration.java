package com.weiwan.box.framework.signature.config;

import com.weiwan.box.framework.redis.config.EasybootRedisAutoConfiguration;
import com.weiwan.box.framework.signature.core.aop.ApiSignatureAspect;
import com.weiwan.box.framework.signature.core.redis.ApiSignatureRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * HTTP API 签名的自动配置类
 *
 * @author Zhougang
 */
@AutoConfiguration(after = EasybootRedisAutoConfiguration.class)
public class EasybootApiSignatureAutoConfiguration {

    @Bean
    public ApiSignatureAspect signatureAspect(ApiSignatureRedisDAO signatureRedisDAO) {
        return new ApiSignatureAspect(signatureRedisDAO);
    }

    @Bean
    public ApiSignatureRedisDAO signatureRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new ApiSignatureRedisDAO(stringRedisTemplate);
    }

}
