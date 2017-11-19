package cn.mycommons.springcache.service;

import cn.mycommons.springcache.model.User;

/**
 * UserService <br/>
 * Created by Leon on 2017-11-19.
 */
public interface UserService {

    void addUser(User user);

    User findById(int id);

    void delete(int id);
}
