package com.noker.mis.service;

import java.util.List;

import com.noker.mis.model.Product;

public interface ProductService {

	List<Product> selectspyl(Product productInfo);

	List<Product> selectmrhl(Product productInfo);

	List<Product> selectlyfs(Product productInfo);

	List<Product> selectjtqj(Product productInfo);

	List<Product> selectsxsg(Product productInfo);

	List<Product> selectmyyp(Product productInfo);

	List<Product> selectmyypAll(Product productInfo);

	List<Product> selectsxsgAll(Product productInfo);

	List<Product> selectjtqjAll(Product productInfo);

	List<Product> selectlyfsAll(Product productInfo);

	List<Product> selectmrhlAll(Product productInfo);

	List<Product> selectspylAll(Product productInfo);

	Product selectByPrimaryKey(Integer id);

	List<Product> descript(String[] picture);

	List<Product> searchTitleByKey(String key);

	List<Product> selectAllProduct(Product productInfo);

}
