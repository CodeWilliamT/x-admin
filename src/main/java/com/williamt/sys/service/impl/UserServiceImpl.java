package com.williamt.sys.service.impl;

import com.williamt.sys.entity.User;
import com.williamt.sys.mapper.UserMapper;
import com.williamt.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
