package cn.mycommons.springcache.model;

import lombok.Data;

import java.io.Serializable;

/**
 * User <br/>
 * Created by Leon on 2017-11-19.
 */
@Data
public class User implements Serializable {

    private int id;

    private String name;

    private String email;
}
