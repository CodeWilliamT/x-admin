package com.williamt.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.williamt.sys.entity.User;
import com.williamt.sys.mapper.UserMapper;
import com.williamt.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Map<String, Object> login(User user){
        // 根据用户名与密码查询
        LambdaQueryWrapper<User> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,user.getUsername());
        wrapper.eq(User::getPassword,user.getPassword());
        User loginUser=this.baseMapper.selectOne(wrapper);
        // 结果不为空，则生成token，并将用户信息存入redis
        if(loginUser!=null){
            //暂时用UUID，最终用jwt
            String key="user:"+ UUID.randomUUID();
            //存入redis
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);
            //返回数据
            Map<String,Object> data =new HashMap<>();
            data.put("token",key);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        // 从redis查询token
        Object obj = redisTemplate.opsForValue().get(token);
        // 反序列化
        User user = JSON.parseObject(JSON.toJSONString(obj),User.class);
        if(user != null){
            Map<String, Object> data =  new HashMap<>();
            data.put("name",user.getUsername());
            data.put("avatar",user.getAvatar());
            List<String> roleList = this.getBaseMapper().getRoleNameByUserId(user.getId());
            data.put("roles", roleList);
            return data;
        }
        return null;
    }
}
