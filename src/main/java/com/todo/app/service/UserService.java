package com.todo.app.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todo.app.entity.User;
import com.todo.app.entity.UserForm;
import com.todo.app.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
	public List<User> findAll(){
		return userMapper.findAll();
	}
	
	public User addUser(UserForm userForm) {
		User user = new User();
//		BeanUtils.copyProperties(userForm, user);
		user.setEmail(userForm.getEmail());
		user.setPassword(passwordEncoder.encode(userForm.getPassword()));
		userMapper.insert(user);
		return user;
	}
	
}