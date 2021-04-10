package com.example.apacheshiro.model;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zeroback13
 * @Date 2021/4/5 1:19
 * @Version 1.0
 */
public class Role {
    private Integer rid;
    private String rname;
    private Set<Permission> permissions= new HashSet<>();
    private Set<User>  users = new HashSet<>();

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }


    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
