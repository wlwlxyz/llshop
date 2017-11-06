package com.wl.llshop.service.impl;

import com.wl.llshop.dao.TbItemMapper;
import com.wl.llshop.pojo.po.TbItem;
import com.wl.llshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 11:55
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemdao;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = itemdao.selectByPrimaryKey(itemId);
        return tbItem;
    }
}
