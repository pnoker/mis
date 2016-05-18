package com.noker.mis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noker.mis.dao.ProductMapper;
import com.noker.mis.model.Product;
import com.noker.mis.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> selectspyl(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectspyl(productInfo);
	}

	@Override
	public List<Product> selectmrhl(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectmrhl(productInfo);
	}

	@Override
	public List<Product> selectlyfs(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectlyfs(productInfo);
	}

	@Override
	public List<Product> selectjtqj(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectjtqj(productInfo);
	}

	@Override
	public List<Product> selectsxsg(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectsxsg(productInfo);
	}

	@Override
	public List<Product> selectmyyp(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectmyyp(productInfo);
	}

	@Override
	public List<Product> selectmyypAll(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectmyypAll(productInfo);
	}

	@Override
	public List<Product> selectsxsgAll(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectsxsgAll(productInfo);
	}

	@Override
	public List<Product> selectjtqjAll(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectjtqjAll(productInfo);
	}

	@Override
	public List<Product> selectlyfsAll(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectlyfsAll(productInfo);
	}

	@Override
	public List<Product> selectmrhlAll(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectmrhlAll(productInfo);
	}

	@Override
	public List<Product> selectspylAll(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectspylAll(productInfo);
	}

	@Override
	public Product selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Product> descript(String[] picture) {
		
		return null;
	}

	@Override
	public List<Product> searchTitleByKey(String key) {
		// TODO Auto-generated method stub
		return productMapper.searchTitleByKey(key);
	}

	@Override
	public List<Product> selectAllProduct(Product productInfo) {
		// TODO Auto-generated method stub
		return productMapper.selectAllProduct(productInfo);
	}
}
