package com.wl.llshop.dao;

import com.wl.llshop.common.dto.Page;
import com.wl.llshop.pojo.vo.TbItemCustum;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/7
 * Time: 16:30
 * Version:V1.0
 */
public interface TbItemCustomMapper {
    //查询总个数
    int countItems();
    //分页查询商品
    List<TbItemCustum> listItemByPage(Page page);
}
