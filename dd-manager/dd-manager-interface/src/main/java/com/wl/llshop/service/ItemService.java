package com.wl.llshop.service;

import com.wl.llshop.common.dto.Order;
import com.wl.llshop.common.dto.Page;
import com.wl.llshop.common.dto.Result;
import com.wl.llshop.pojo.po.TbItem;
import com.wl.llshop.pojo.vo.TbItemCustum;
import com.wl.llshop.pojo.vo.TbItemQuery;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 11:38
 * Version:V1.0
 */
public interface ItemService {

    TbItem getById(Long itemId);

    List<TbItem> listItems();

    Result<TbItemCustum> listItemByPage(Page page, Order order, TbItemQuery query);

    int updateItemsByIds(List<Long> ids);

    int updateuprows(List<Long> ids);

    int updatedownrows(List<Long> ids);
}
