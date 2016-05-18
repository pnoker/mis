package com.noker.mis.service;

import java.util.List;

import com.noker.mis.bean.ProductCar;
import com.noker.mis.model.Product;
import com.noker.mis.model.Shopping;

public interface ShoppingService {

	Integer count(String phone);

	Integer insert(Shopping shoppingInfo);

	Shopping selectByPrimaryKey(Integer id);

	List<ProductCar> account(String phone);

	Integer deleteByPrimaryKey(Integer ids);

}
