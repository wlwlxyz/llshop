package com.wl.llshop.service;

import com.wl.llshop.common.dto.Page;
import com.wl.llshop.common.dto.Result;
import com.wl.llshop.pojo.po.TbItemParam;
import com.wl.llshop.pojo.vo.TbItemParamCustom;

/**
 * User: Administrator
 * Date: 2017/11/13
 * Time: 20:56
 * Version:V1.0
 */
public interface ItemParamsServic {

    Result<TbItemParamCustom> ListItemParamsByPage(Page page);

    int saveParamItem(Long cid, String paramDate);

    TbItemParam getItemParamByCid(Long cid);
}
