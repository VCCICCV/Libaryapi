package com.example.libary.common;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.libary.entity.Admin;
import com.example.libary.exception.ServiceException;
import com.example.libary.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/25 19:55
 */
// 组件
@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    private static final String ERROR_CODE_401 = "401";
    @Autowired
    private IAdminService adminService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        // 如果请求头中没有token，尝试从请求参数中获取
        if (StrUtil.isBlank(token)) {
            token = request.getParameter("token");
        }
        // 执行认证
        if (StrUtil.isBlank(token)) {
            throw new ServiceException(ERROR_CODE_401, "无token，请重新登录");
        }
        // 获取 token 中的adminId
        String adminId;
        Admin admin;
        try {
            // 从token中解析出adminId
            adminId = JWT.decode(token).getAudience().get(0);
            // 根据token中的userid查询数据库
            admin = adminService.getById(Integer.parseInt(adminId));
        } catch (Exception e) {
            String errMsg = "token验证失败，请重新登录";
            log.error(errMsg + ", token=" + token, e);
            throw new ServiceException(ERROR_CODE_401, errMsg);
        }
        if (admin == null) {
            throw new ServiceException(ERROR_CODE_401, "用户不存在，请重新登录");
        }
        try {
            // 使用管理员的密码创建一个JWT验证器
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(admin.getPassword())).build();
            // 使用验证器验证token
            jwtVerifier.verify(token); // 验证token
        } catch (JWTVerificationException e) {
            throw new ServiceException(ERROR_CODE_401, "token验证失败，请重新登录");
        }
        return true;
    }
}
