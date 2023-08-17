package com.williamt.sys.service.impl;

import com.williamt.sys.entity.Menu;
import com.williamt.sys.mapper.MenuMapper;
import com.williamt.sys.service.IMenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
