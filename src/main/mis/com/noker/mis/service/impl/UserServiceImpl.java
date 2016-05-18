package com.noker.mis.service.impl;

import com.noker.mis.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noker.mis.dao.UserMapper;
import com.noker.mis.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectByPrimaryKey(String phone) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(phone);
	}
}