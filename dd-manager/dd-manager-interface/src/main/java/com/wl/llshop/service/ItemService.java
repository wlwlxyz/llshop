package com.wl.llshop.service;

import com.wl.llshop.common.dto.Page;
import com.wl.llshop.pojo.po.TbItem;
import com.wl.llshop.common.dto.result;
import com.wl.llshop.pojo.vo.TbItemCustum;


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

    result<TbItemCustum> listItemByPage(Page page);
}
