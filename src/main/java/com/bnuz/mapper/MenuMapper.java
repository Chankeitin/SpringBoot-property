package com.bnuz.mapper;

import com.bnuz.dto.MenuDto;
import com.bnuz.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Chanchitin
 * @since 2021-06-01
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     *查询全部菜单
     */
    public List<MenuDto> queryMenuList();
}
