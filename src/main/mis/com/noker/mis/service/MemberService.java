package com.noker.mis.service;

import com.noker.mis.model.Member;

public interface MemberService {

	Member selectPrimaryKey(String phone);

}
