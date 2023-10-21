package com.williamt.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.williamt.sys.entity.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author williamt
 * @since 2023-08-16
 */
public interface UserMapper extends BaseMapper<User> {
    public List<String> getRoleNamesByUserId(Integer userId);
}
