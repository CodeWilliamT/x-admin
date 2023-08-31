package com.williamt.sys.controller;


import com.williamt.common.vo.Result;
import com.williamt.sys.entity.User;
import com.williamt.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author williamt
 * @since 2023-08-16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/all")
    public Result<List<User>> getAllUser(){
        List<User> list = userService.list();
        return Result.success(list,"查询成功");
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User user){
        Map<String,Object> data =userService.login(user);
        if(data!=null){
            return Result.success(data);
        }
        return Result.fail(20002,"用户名或密码错误");
    }
}
