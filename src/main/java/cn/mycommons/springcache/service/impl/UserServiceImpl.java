package cn.mycommons.springcache.service.impl;

import cn.mycommons.springcache.model.User;
import cn.mycommons.springcache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * UserServiceImpl <br/>
 * Created by Leon on 2017-11-19.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final Map<Integer, User> db = new HashMap<>();

    @Override
    public void addUser(User user) {
        log.info("addUser.user = " + user);
        db.put(user.getId(), user);
    }

    @Cacheable(cacheNames = "user_cache", key = "#id")
    @Override
    public User findById(int id) {
        log.info("findById.id = " + id);

        return db.get(id);
    }

    @CacheEvict(cacheNames = "user_cache", key = "#id")
    @Override
    public void delete(int id) {
        log.info("delete.id = " + id);

        db.remove(id);
    }
}
