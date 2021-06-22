package com.bnuz.service.impl;

import com.bnuz.dto.MenuDto;
import com.bnuz.pojo.Menu;
import com.bnuz.mapper.MenuMapper;
import com.bnuz.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chanchitin
 * @since 2021-06-01
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     *主菜单并整理其子菜单
     */
    @Cacheable(cacheNames = "menus")
    public List<MenuDto> queryMenuList() {
        //查询所有菜单
        List<MenuDto> list = menuMapper.queryMenuList();
        //一级菜单数组
        List<MenuDto> rootlist=new ArrayList<>();
        for (MenuDto menuDto : list) {
            if(menuDto.getParentId().equals(0)){
                //找到根节点菜单的时候，寻找这个根节点菜单下的子节点菜单。
                findChilds(menuDto,list);
                //添加到根节点的列表中
                rootlist.add(menuDto);
            }
        }
        return rootlist;
    }

    private void findChilds(MenuDto menuDto, List<MenuDto> list) {
        List<MenuDto> childMenus=new ArrayList<>();
        //遍历所有数据，找到是入参父节点的子节点的数据，然后加到childMenus集合中。
        for (MenuDto menu : list) {
            if (menuDto.getId().equals(menu.getParentId()))
                childMenus.add(menu);
        }
        //若子节点不存在，那么就不必再遍历子节点中的子节点了 直接返回。
        if(childMenus.size()==0)
            return;
        //设置父节点的子节点列表
        menuDto.setChildMenus(childMenus);
        //若子节点存在，接着递归调用该方法，寻找子节点的子节点。
        for (MenuDto childs : childMenus) {
            findChilds(childs, list);
        }

    }
}
