package com.example.libary.controller;
import com.example.libary.common.Result;
import com.example.libary.controller.dto.LoginDTO;
import com.example.libary.controller.request.AdminPageRequest;
import com.example.libary.controller.request.LoginRequest;
import com.example.libary.controller.request.PasswordRequest;
import com.example.libary.entity.Admin;
import com.example.libary.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * @PROJECT_NAME Libaryapi
 * @AUTHOR VCCICCV
 * @DATE 2023/4/8 22:50
 */
@CrossOrigin// 解决跨域
@RestController
@RequestMapping ("/admin")
public class AdminController {
    @Autowired
    IAdminService adminService;
    @PostMapping ("/login")
    public Result login(@RequestBody LoginRequest request) {
        LoginDTO login = adminService.login(request);
        return Result.success(login);
    }
    @PutMapping ("/resetPass/{id}")
    public Result resetPassById(@PathVariable Integer id) {
        adminService.resetPassById(id);
        return Result.success();
    }
    @PutMapping("/password")
    public Result password(@RequestBody PasswordRequest request) {
        adminService.changePass(request);
        return Result.success();
    }
    @DeleteMapping ("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        adminService.deleteById(id);
        return Result.success();
    }
    @PutMapping ("/update")
    public Result update(@RequestBody Admin obj) {
        adminService.update(obj);
        return Result.success();
    }
    @GetMapping ("/{id}")
    public Result getById(@PathVariable Integer id) {
        Admin obj = adminService.getById(id);
        return Result.success(obj);
    }
    @PostMapping ("/save")
    public Result save(@RequestBody Admin obj) {
        adminService.save(obj);
        return Result.success();
    }
    @GetMapping ("/list")
    public Result list() {
        List<Admin> list = adminService.list();
        return Result.success(list);
    }
    @GetMapping ("/page")
    public Result page(AdminPageRequest pageRequest) {
        return Result.success(adminService.page(pageRequest));
    }
}