package com.haoting.jbricks.sys.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.haoting.jbricks.core.result.Response;
import com.haoting.jbricks.sys.application.UserService;
import com.haoting.jbricks.sys.application.dto.UserDTO;

/**
 * @author haoting.wang
 * @Date 2018/7/19
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("get_user/{userId}")
	public Response<UserDTO> getUser(@PathVariable String userId){

		UserDTO user = userService.getUserById(userId);

		return Response.success(user);
	}

	@PostMapping(value = "add_user")
	public Response<UserDTO> addUser(UserDTO userDTO){

		UserDTO user = userService.addUser(userDTO);

		return Response.success(user);
	}

}
