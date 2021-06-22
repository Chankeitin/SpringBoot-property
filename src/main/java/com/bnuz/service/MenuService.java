package com.bnuz.service;

import com.bnuz.dto.MenuDto;
import com.bnuz.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Chanchitin
 * @since 2021-06-01
 */
public interface MenuService extends IService<Menu> {
    /**
     *查询全部菜单
     */
    public List<MenuDto> queryMenuList();
}
