package com.noker.mis.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mysql.jdbc.Util;
import com.noker.mis.util.Utils;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);

			// 没有声明需要权限,或者声明不验证权限
			if (authPassport == null || authPassport.validate() == false)
				return true;
			else {
				// 在这里实现自己的权限验证逻辑
				boolean isPermit = false;//注意这个地方应该设置为false，在进入user的管理界面时，应该提交用户的userId，这样就便于检验用户是否有登录
				HttpSession session = request.getSession();
				String userId = (String) session.getAttribute("userId");
				if (!StringUtils.isBlank(userId)) {
					String url = request.getRequestURI();
					if (Utils.isPermitUrl(url, "user"))
						isPermit = true;
				}
				if (isPermit) // 如果验证成功返回true
					return true;
				else// 如果验证失败
				{
					// 返回到登录界面
					String path = request.getContextPath();
					response.sendRedirect(path + "/login.do");
					return false;
				}
			}
		} else
			return true;
	}
}