package com.wl.llshop.service.impl;

import com.wl.llshop.common.dto.Page;
import com.wl.llshop.common.dto.result;
import com.wl.llshop.dao.TbItemCustomMapper;
import com.wl.llshop.dao.TbItemMapper;
import com.wl.llshop.pojo.po.TbItem;
import com.wl.llshop.pojo.vo.TbItemCustum;
import com.wl.llshop.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 11:55
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private  TbItemMapper itemdao;
  /*  private TbItemMapper itemdao;*/
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    /*private TbItemCustomMapper itemCustomDao;*/
    

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = itemdao.selectByPrimaryKey(itemId);
        return tbItem;
    }

    @Override
    public List<TbItem> listItems() {
        List<TbItem> tbItems = itemdao.selectByExample(null);
        return tbItems;
    }

    @Override
    public result<TbItemCustum> listItemByPage(Page page) {
        int i= itemCustomDao.countItems();
        result<TbItemCustum> result = new result<>();
        long total = (long)i;
        result.setTotal(total);
        List<TbItemCustum> tbItems = itemCustomDao.listItemByPage(page);
        result.setRows(tbItems);
        return result;
    }
}
