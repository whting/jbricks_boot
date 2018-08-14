package com.haoting.jbricks.sys.application;

import com.haoting.jbricks.sys.application.dto.UserDTO;

/**
 * @author haoting.wang
 * @Date 2018/7/19
 */
public interface UserService {

    /**
     * 根据用户id获取用户
     * 
     * @param userId
     * @return
     */
    UserDTO findUserById(String userId);

    /**
     * 新增用户
     * 
     * @param userDTO
     * @return
     */
    UserDTO addUser(UserDTO userDTO);
}
