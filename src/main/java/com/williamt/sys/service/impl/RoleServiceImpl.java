package com.williamt.sys.service.impl;

import com.williamt.sys.entity.Role;
import com.williamt.sys.mapper.RoleMapper;
import com.williamt.sys.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
