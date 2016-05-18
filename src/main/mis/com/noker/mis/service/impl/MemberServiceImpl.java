package com.noker.mis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noker.mis.dao.MemberMapper;
import com.noker.mis.model.Member;
import com.noker.mis.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public Member selectPrimaryKey(String phone) {
		// TODO Auto-generated method stub
		return memberMapper.selectByPrimaryKey(phone);
	}

}
