package com.haoting.jbricks.sys.application.impl;

import com.haoting.jbricks.sys.application.UserService;
import com.haoting.jbricks.sys.application.assembler.UserAssembler;
import com.haoting.jbricks.sys.application.dto.UserDTO;
import com.haoting.jbricks.sys.domain.model.User;
import com.haoting.jbricks.sys.infrastructure.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haoting.wang
 * @Date 2018/7/19
 */

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserAssembler userAssembler;


    @Override
    public UserDTO findUserById(String userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {

        User user = userAssembler.fromDTO(userDTO);

        int count = userRepository.addUser(user);

        return null;
    }
}
