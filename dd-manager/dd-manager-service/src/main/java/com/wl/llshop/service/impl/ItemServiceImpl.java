package com.wl.llshop.service.impl;

import com.wl.llshop.common.dto.Order;
import com.wl.llshop.common.dto.Page;
import com.wl.llshop.common.dto.Result;
import com.wl.llshop.common.util.IDUtils;
import com.wl.llshop.dao.TbItemCustomMapper;
import com.wl.llshop.dao.TbItemDescMapper;
import com.wl.llshop.dao.TbItemMapper;
import com.wl.llshop.pojo.po.TbItem;
import com.wl.llshop.pojo.po.TbItemDesc;
import com.wl.llshop.pojo.po.TbItemExample;
import com.wl.llshop.pojo.vo.TbItemCustum;
import com.wl.llshop.pojo.vo.TbItemQuery;
import com.wl.llshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    private TbItemCustomMapper itemCustomDao;

    @Autowired
    private TbItemDescMapper itemDescDao;


    /**
     * 根据主键查询商品
     * @param itemId
     * @return
     */
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
    public Result<TbItemCustum> listItemByPage(Page page,Order order, TbItemQuery query) {
        int i= itemCustomDao.countItems(query);
        Result<TbItemCustum> result = new Result<>();
        long total = (long)i;
        result.setTotal(total);
            List<TbItemCustum> tbItems = itemCustomDao.listItemByPage(page,order,query);
            result.setRows(tbItems);
        return result;
    }
    @Override
    public int updateItemsByIds(List<Long> ids) {
        TbItem tbItem = new TbItem();
        tbItem.setStatus((byte)3);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return itemdao.updateByExampleSelective(tbItem,example);
    }

    @Override
    public int updateuprows(List<Long> ids) {
        TbItem tbItem = new TbItem();
        tbItem.setStatus((byte)1);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return itemdao.updateByExampleSelective(tbItem,example);
    }

    @Override
    public int updatedownrows(List<Long> ids) {
        TbItem tbItem = new TbItem();
        tbItem.setStatus((byte)2);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return itemdao.updateByExampleSelective(tbItem,example);
    }

    //加上  @Transactional这个方法就变成了事务方法
    @Transactional
    @Override
    public int saveItem(TbItem tbItem, String content) {
        int i=0;
        int j=0;
        Long itemId = IDUtils.getItemId();
        tbItem.setId(itemId);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        tbItem.setStatus((byte)1);
        i=itemdao.insert(tbItem);
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(content);
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        j= itemDescDao.insert(tbItemDesc);
        int k=i+j;
        return k;
    }
}
