package com.bogdan.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


public class Dependencies {

  @Bean
  public JedisConnectionFactory jedisConnectionFactory(
      @Value("${spring.redis.host}") String redisHost,
      @Value("${spring.redis.port}") int redisPort
  ) {
    return new JedisConnectionFactory(new RedisStandaloneConfiguration(redisHost, redisPort));
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate(
      JedisConnectionFactory jedisConnectionFactory
  ) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory);
    return template;
  }

}
