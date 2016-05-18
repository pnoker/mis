package com.noker.mis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noker.mis.bean.ProductCar;
import com.noker.mis.dao.ShoppingMapper;
import com.noker.mis.model.Product;
import com.noker.mis.model.Shopping;
import com.noker.mis.service.ShoppingService;
@Service("shoppingService")
public class ShoppingServiceImpl implements ShoppingService{
	@Autowired
	private ShoppingMapper shoppingMapper;

	@Override
	public Integer count(String phone) {
		// TODO Auto-generated method stub
		return shoppingMapper.count(phone);
	}

	@Override
	public Integer insert(Shopping shoppingInfo) {
		// TODO Auto-generated method stub
		return shoppingMapper.insert(shoppingInfo);
	}

	@Override
	public Shopping selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return shoppingMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductCar> account(String phone) {
		// TODO Auto-generated method stub
		return shoppingMapper.account(phone);
	}

	@Override
	public Integer deleteByPrimaryKey(Integer ids) {
		// TODO Auto-generated method stub
		return shoppingMapper.deleteByPrimaryKey(ids);
	}

}
