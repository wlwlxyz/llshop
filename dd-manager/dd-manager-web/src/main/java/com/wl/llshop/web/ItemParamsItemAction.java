package com.wl.llshop.web;

import com.wl.llshop.common.dto.Page;
import com.wl.llshop.common.dto.Result;
import com.wl.llshop.pojo.po.TbItemParam;
import com.wl.llshop.pojo.vo.TbItemParamCustom;
import com.wl.llshop.service.ItemParamsServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Administrator
 * Date: 2017/11/13
 * Time: 20:50
 * Version:V1.0
 */
@Controller
public class ItemParamsItemAction {
    @Autowired
    private ItemParamsServic itemParamsService;

    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> ListItemParamsByPage(Page page){
        Result<TbItemParamCustom> result= itemParamsService.ListItemParamsByPage(page);
        result.getRows().get(0).getCreated();
        return result;
    }
        //新增类目
    @ResponseBody
    @RequestMapping(value = "item/param/save/{cid}")
    public int saveParamItem(@PathVariable("cid") Long cid,String paramDate){
        int i = itemParamsService.saveParamItem(cid, paramDate);
        return i;
    }
    //查询出单个类目
    @ResponseBody
    @RequestMapping(value = "item/query/{cid}")
    public TbItemParam getItemParamByCid(@PathVariable("cid") Long cid){
        TbItemParam itemParamByCid = itemParamsService.getItemParamByCid(cid);
        return  itemParamByCid;
    }
}
