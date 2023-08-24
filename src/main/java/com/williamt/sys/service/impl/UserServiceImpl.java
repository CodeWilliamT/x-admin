package com.williamt.sys.service.impl;

import com.williamt.sys.entity.User;
import com.williamt.sys.mapper.UserMapper;
import com.williamt.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author williamt
 * @since 2023-08-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public Map<String, Object> login(User user){
        // 根据用户名与密码查询
        // 结果不为空，则生成token，并将用户信息存入redis
        return null;
    }
}
