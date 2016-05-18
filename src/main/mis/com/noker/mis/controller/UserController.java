package com.noker.mis.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.noker.mis.bean.BizQuery;
import com.noker.mis.bean.ProductCar;
import com.noker.mis.model.Member;
import com.noker.mis.model.Product;
import com.noker.mis.model.Shopping;
import com.noker.mis.model.User;
import com.noker.mis.service.MemberService;
import com.noker.mis.service.ProductService;
import com.noker.mis.service.ShoppingService;
import com.noker.mis.service.UserService;
import com.noker.mis.util.MD5;

@Controller // 定义容器，MVC 中的 Ｃ
@RequestMapping("/user") // 请求映射
public class UserController extends BaseController {
	static final Logger logger = LogManager.getLogger(UserController.class);// 日志
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ShoppingService shoppingService;
	@Autowired
	private MemberService memberService;

	@RequestMapping("/index")
	public String index(ModelMap modelMap) {
		return "/user/index";
	}

	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request, String phone, String password) {
		User user = userService.selectByPrimaryKey(phone);
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isBlank(phone)) {/* 验证手机号码为空 */
			map.put("mes", "1000");
			return JSON.toJSONString(map);
		} else if (user == null) {/* 没有此用户 */
			map.put("mes", "1001");
			return JSON.toJSONString(map);
		} else if (StringUtils.isBlank(password)) {/* 密码为空 */
			map.put("mes", "1002");
			return JSON.toJSONString(map);
		} else if (!MD5.GetMD5Code(password).equals(user.getPassword())) {/* 密码匹配 */
			map.put("mes", "1003");
			return JSON.toJSONString(map);
		} else {
			map.put("mes", "1004");
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userPhone", user.getPhone());
			return JSON.toJSONString(map);
		}
	}

	@RequestMapping("/regist")
	public String regist(ModelMap modelMap) {
		return "/user/regist_success";
	}

	@RequestMapping("/shopping") /* 在线购物 */
	public String shopping(HttpServletRequest request, ModelMap modelMap) {
		String phone = (String) request.getSession().getAttribute("userPhone");
		Product productInfo = new Product();
		Shopping shoppingInfo = new Shopping();
		List<Product> productspyl = productService.selectspyl(productInfo);
		List<Product> productmrhl = productService.selectmrhl(productInfo);
		List<Product> productlyfs = productService.selectlyfs(productInfo);
		List<Product> productjtqj = productService.selectjtqj(productInfo);
		List<Product> productsxsg = productService.selectsxsg(productInfo);
		List<Product> productmyyp = productService.selectmyyp(productInfo);
		Integer count = shoppingService.count(phone);/* 购物车数量 */
		modelMap.addAttribute("count", count);
		modelMap.addAttribute("productspyl", productspyl);/* 食品饮料 */
		modelMap.addAttribute("productmrhl", productmrhl);/* 美容护理 */
		modelMap.addAttribute("productlyfs", productlyfs);/* 粮油副食 */
		modelMap.addAttribute("productjtqj", productjtqj);/* 家庭清洁 */
		modelMap.addAttribute("productsxsg", productsxsg);/* 生鲜水果 */
		modelMap.addAttribute("productmyyp", productmyyp);/* 母婴用品 */
		return "/user/shopping";
	}

	@ResponseBody
	@RequestMapping("/checkout") /* 添加购物车 */
	public String checkout(HttpServletRequest request, ModelMap modelMap, Integer id, Integer number) {
		String phone = (String) request.getSession().getAttribute("userPhone");
		Shopping shoppingInfo = new Shopping();
		Product product = productService.selectByPrimaryKey(id);
		Date time = new java.sql.Date(new java.util.Date().getTime());
		shoppingInfo.setProductId(product.getId());
		shoppingInfo.setTime(time);
		shoppingInfo.setPhone(phone);/* 设置手机号码，标识用户 */
		shoppingInfo.setNumber(number);/* 设置商品数量 */
		shoppingInfo.setTotal1(number * product.getPrice());/* 设置商品价格 */
		shoppingInfo.setIsPay(0);
		Integer insert = shoppingService.insert(shoppingInfo);
		String seccess = "";
		return seccess;
	}

	@RequestMapping("/guide") /* 商品导购 */
	public String guide(ModelMap modelMap) {
		Product productInfo = new Product();
		List<Product> product = productService.selectAllProduct(productInfo);
		modelMap.addAttribute("product", product);
		return "/user/guide";
	}

	@RequestMapping("/search") /* 商品搜索 */
	public String search(HttpServletRequest request, ModelMap modelMap, String key) {
		List<Product> product = productService.searchTitleByKey("%" + key + "%");
		modelMap.addAttribute("product", product);
		return "/user/result";
	}

	@RequestMapping("/member") /* 会员积分 */
	public String member(HttpServletRequest request, ModelMap modelMap) {
		String phone = (String) request.getSession().getAttribute("userPhone");
		Member member = memberService.selectPrimaryKey(phone);
		User user = userService.selectByPrimaryKey(phone);
		modelMap.addAttribute("member", member);
		modelMap.addAttribute("user", user);
		return "/user/member";
	}

	@RequestMapping("/active") /* 商品活动 */
	public String active(ModelMap modelMap) {
		return "/user/active";
	}

	@RequestMapping("/spyl") /* 食品饮料 */
	public String spyl(ModelMap modelMap) {
		Map<String, String> type = new HashMap<String, String>();
		type.put("id", "spyl");
		type.put("name", "食品饮料");
		Product productInfo = new Product();
		List<Product> product = productService.selectspylAll(productInfo);
		modelMap.addAttribute("type", type);
		modelMap.addAttribute("product", product);
		return "/user/more";
	}

	@RequestMapping("/mrhl") /* 美容护理 */
	public String mrhl(ModelMap modelMap) {
		Map<String, String> type = new HashMap<String, String>();
		type.put("id", "mrhl");
		type.put("name", "美容护理");
		Product productInfo = new Product();
		List<Product> product = productService.selectmrhlAll(productInfo);
		modelMap.addAttribute("type", type);
		modelMap.addAttribute("product", product);
		return "/user/more";
	}

	@RequestMapping("/lyfs") /* 粮油副食 */
	public String lyfs(ModelMap modelMap) {
		Map<String, String> type = new HashMap<String, String>();
		type.put("id", "lyfs");
		type.put("name", "粮油副食");
		Product productInfo = new Product();
		List<Product> product = productService.selectlyfsAll(productInfo);
		modelMap.addAttribute("type", type);
		modelMap.addAttribute("product", product);
		return "/user/more";
	}

	@RequestMapping("/jtqj") /* 家庭清洁 */
	public String jtqj(ModelMap modelMap) {
		Map<String, String> type = new HashMap<String, String>();
		type.put("id", "jtqj");
		type.put("name", "家庭清洁");
		Product productInfo = new Product();
		List<Product> product = productService.selectjtqjAll(productInfo);
		modelMap.addAttribute("type", type);
		modelMap.addAttribute("product", product);
		return "/user/more";
	}

	@RequestMapping("/sxsg") /* 生鲜水果 */
	public String sxsg(ModelMap modelMap) {
		Map<String, String> type = new HashMap<String, String>();
		type.put("id", "sxsg");
		type.put("name", "生鲜水果");
		Product productInfo = new Product();
		List<Product> product = productService.selectsxsgAll(productInfo);
		modelMap.addAttribute("type", type);
		modelMap.addAttribute("product", product);
		return "/user/more";
	}

	@RequestMapping("/myyp") /* 母婴用品 */
	public String myyp(ModelMap modelMap) {
		Map<String, String> type = new HashMap<String, String>();
		type.put("id", "myyp");
		type.put("name", "母婴用品");
		Product productInfo = new Product();
		List<Product> product = productService.selectmyypAll(productInfo);
		modelMap.addAttribute("type", type);
		modelMap.addAttribute("product", product);
		return "/user/more";
	}

	@RequestMapping("/detail") /* 商品详情 */
	public String detail(HttpServletRequest request, ModelMap modelMap, Integer id) {
		Product product = productService.selectByPrimaryKey(id);
		String[] picture = product.getDescription().split(",");
		List<String> description = new ArrayList<String>();
		Collections.addAll(description, picture);
		modelMap.addAttribute("product", product);
		modelMap.addAttribute("description", description);
		return "/user/detail";
	}

	@RequestMapping("/car") /* 购物车 */
	public String car(HttpServletRequest request, ModelMap modelMap, Integer ids) {
		if (ids == null) {
		} else {
			Integer delect = shoppingService.deleteByPrimaryKey(ids);
		}
		String phone = (String) request.getSession().getAttribute("userPhone");
		List<ProductCar> product = shoppingService.account(phone);
		Member member = memberService.selectPrimaryKey(phone);
		Float total2 = (float) 0;
		for (int i = 0; i < product.size(); i++) {
			total2 = product.get(i).getTotal1() + total2;
		}
		Float total3 = total2 * (member.getDiscount()) / 10;
		modelMap.addAttribute("total2", total2);
		modelMap.addAttribute("total3", total3);
		modelMap.addAttribute("member", member);
		modelMap.addAttribute("product", product);
		return "/user/car";
	}
	
	@RequestMapping("/pay") /* 在线支付 */
	public String pay(HttpServletRequest request, ModelMap modelMap, String phone) {
		return "/user/car";
	}

}