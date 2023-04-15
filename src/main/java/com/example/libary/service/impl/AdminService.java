package com.example.libary.service.impl;

import cn.hutool.core.util.StrUtil;
import com.example.libary.controller.request.BaseRequest;
import com.example.libary.entity.Admin;
import com.example.libary.mapper.AdminMapper;
import com.example.libary.service.IAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 22:42
 */
@Service
public class AdminService implements IAdminService {
    @Autowired
    AdminMapper adminMapper;
    private static final String DEFAULT_PASS = "123";
    private static final String PASS_SALT = "123";
    @Override
    public List<Admin> list() {
        return adminMapper.list();
    }
    @Override
    public PageInfo<Admin> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Admin> users = adminMapper.listByCondition(baseRequest);
        return new PageInfo<>(users);
    }

    @Override
    public void save(Admin obj) {
        // // 默认密码 123
        // if (StrUtil.isBlank(obj.getPassword())) {
        //     obj.setPassword(DEFAULT_PASS);
        // }
        // obj.setPassword(securePass(obj.getPassword()));  // 设置md5加密，加盐
        // try {
        //     adminMapper.save(obj);
        // } catch (DuplicateKeyException e) {
        //     log.error("数据插入失败， username:{}", obj.getUsername(), e);
        //     throw new ServiceException("用户名重复");
        // }
        adminMapper.save(obj);

    }
    @Override
    public Admin getById(Integer id) {
        return adminMapper.getById(id);
    }

    @Override
    public void update(Admin user) {
        user.setUpdatetime(new Date());
        adminMapper.updateById(user);
    }

    @Override
    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }
}
