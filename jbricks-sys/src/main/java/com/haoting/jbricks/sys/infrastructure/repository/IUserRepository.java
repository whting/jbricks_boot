package com.haoting.jbricks.sys.infrastructure.repository;

import com.haoting.jbricks.sys.domain.model.User;

/**
 * @author haoting.wang
 * @Date 2018/7/20
 */
public interface IUserRepository {

    int addUser(User user);
}
