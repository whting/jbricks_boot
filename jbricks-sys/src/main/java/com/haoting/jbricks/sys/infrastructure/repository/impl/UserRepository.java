package com.haoting.jbricks.sys.infrastructure.repository.impl;

import com.haoting.jbricks.sys.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import com.haoting.jbricks.sys.domain.model.User;
import com.haoting.jbricks.sys.infrastructure.repository.IUserRepository;
import com.haoting.jbricks.sys.infrastructure.repository.mysql.UserMysqlRepository;

/**
 * @author haoting.wang
 * @Date 2018/7/23
 */
public class UserRepository implements IUserRepository {

    @Autowired
    private UserMysqlRepository userMysqlRepository;


    @Override
    public int addUser(User user) {

        return userMysqlRepository.addUser(user);
    }

    @Override
    public UserDTO findUserById(String userId) {

        return userMysqlRepository.findUserById(userId);
    }
}
