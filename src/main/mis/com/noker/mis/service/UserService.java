package com.noker.mis.service;

import com.noker.mis.model.User;

public interface UserService {

	User selectByPrimaryKey(String phone);

}
