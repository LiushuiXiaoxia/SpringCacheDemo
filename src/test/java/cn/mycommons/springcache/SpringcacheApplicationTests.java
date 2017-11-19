package cn.mycommons.springcache;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcacheApplicationTests {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(redisTemplate);

        redisTemplate.opsForValue().set("hello", "world");
        String value = redisTemplate.opsForValue().get("hello");
        log.info("value = " + value);

        redisTemplate.delete("hello");

        value = redisTemplate.opsForValue().get("hello");
        log.info("value = " + value);
    }
}