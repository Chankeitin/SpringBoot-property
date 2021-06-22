package com.bnuz.service.impl;

import com.bnuz.pojo.Tag;
import com.bnuz.mapper.TagMapper;
import com.bnuz.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
