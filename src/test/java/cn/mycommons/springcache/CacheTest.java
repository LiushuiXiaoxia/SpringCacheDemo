package cn.mycommons.springcache;

import cn.mycommons.springcache.model.User;
import cn.mycommons.springcache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(userService);

        User user = new User();
        user.setId(100);
        user.setName("admin");
        user.setEmail("admin@123.com");

        userService.addUser(user);

        log.info("user1 = " + userService.findById(100));
        sleep(1);
        log.info("user2 = " + userService.findById(100));
        sleep(5);
        log.info("user3 = " + userService.findById(100));

        userService.addUser(user);
        log.info("user4 = " + userService.findById(100));
        userService.delete(100);
        log.info("user5 = " + userService.findById(100));
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}