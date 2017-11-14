package com.wl.llshop.web;

import com.wl.llshop.common.dto.Page;
import com.wl.llshop.common.dto.Result;
import com.wl.llshop.pojo.vo.TbItemParamCustom;
import com.wl.llshop.service.ItemParamsServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Administrator
 * Date: 2017/11/13
 * Time: 20:50
 * Version:V1.0
 */
@Controller
public class itemParamsItem {
    @Autowired
    private ItemParamsServic itemParamsService;

    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> ListItemParamsByPage(Page page){
        Result<TbItemParamCustom> result= itemParamsService.ListItemParamsByPage(page);
        result.getRows().get(0).getCreated();
        return result;
    }
}
