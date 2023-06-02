package com.example.libary.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.libary.controller.dto.LoginDTO;
import com.example.libary.controller.request.BaseRequest;
import com.example.libary.controller.request.LoginRequest;
import com.example.libary.controller.request.PasswordRequest;
import com.example.libary.entity.Admin;
import com.example.libary.exception.ServiceException;
import com.example.libary.mapper.AdminMapper;
import com.example.libary.service.IAdminService;
import com.example.libary.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 22:42
 */
@Slf4j
@Service
public class AdminService implements IAdminService {
    @Autowired
    AdminMapper adminMapper;
    private static final String DEFAULT_PASS = "1234";
    private static final String PASS_SALT = "cc";

    @Override
    public List<Admin> list() {
        return adminMapper.list();
    }

    @Override
    public PageInfo<Admin> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Admin> users = adminMapper.listByCondition(baseRequest);
        return new PageInfo<>(users);
    }

    @Override
    public void save(Admin obj) {
        // 默认密码 1234
        if (StrUtil.isBlank(obj.getPassword())) {
            obj.setPassword(DEFAULT_PASS);
        }
        obj.setPassword(securePass(obj.getPassword()));  // 设置md5加密
        try {
            // 设置创建时间
            obj.setCreatetime(new Date());
            adminMapper.save(obj);
        } catch (DuplicateKeyException e) {
            log.error("数据插入失败， username:{}", obj.getUsername(), e);
            throw new ServiceException("用户名重复");
        }

    }
    @Override
    public Admin getById(Integer id) {
        return adminMapper.getById(id);
    }

    @Override
    public void update(Admin admin) {
        admin.setUpdatetime(new Date());
        adminMapper.updateById(admin);
    }

    @Override
    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

    @Override
    public LoginDTO login(LoginRequest request) {
        Admin admin = null;
        try {
            admin = adminMapper.getByUsername(request.getUsername());
            System.out.println("admin的值为"+admin);
        } catch (Exception e) {
            log.error("根据用户名{} 查询出错", request.getUsername());
            log.error(String.valueOf(e));
            throw new ServiceException("用户名错误");
        }
        if (admin == null) {
            throw new ServiceException("用户不存在");
        }
        // 判断密码是否合法
        String securePass = securePass(request.getPassword());
        if (!securePass.equals(admin.getPassword())) {
            throw new ServiceException("用户名或密码错误");
        }
        if (!admin.isStatus()) {
            throw new ServiceException("当前用户处于禁用状态，请联系管理员");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(admin, loginDTO);

        // 生成token
        String token = TokenUtils.genToken(String.valueOf(admin.getId()), admin.getPassword());
        loginDTO.setToken(token);
        return loginDTO;
    }
    @Override
    public void changePass(PasswordRequest request) {
        // 注意 你要对新的密码进行加密
        request.setNewPass(securePass(request.getNewPass()));
        int count = adminMapper.updatePassword(request);
        if (count <= 0) {
            throw new ServiceException("修改密码失败");
        }
    }

    @Override
    public void  resetPassById(Integer id) {
        try {
            Admin admin = adminMapper.getById(id);
            if (admin == null) {
                throw new ServiceException("用户不存在");
            }
            admin.setPassword(securePass(DEFAULT_PASS));  // 设置默认密码
            adminMapper.resetPassById(admin);
        } catch (ServiceException e) {
            throw new ServiceException("重置密码失败");
        }
    }
    private String securePass(String password) {
        return SecureUtil.md5(password + PASS_SALT);
    }
}
