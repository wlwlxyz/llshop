package com.wl.llshop.web;

import com.wl.llshop.common.dto.Order;
import com.wl.llshop.common.dto.Page;
import com.wl.llshop.common.dto.Result;
import com.wl.llshop.pojo.po.TbItem;
import com.wl.llshop.pojo.vo.TbItemCustum;
import com.wl.llshop.pojo.vo.TbItemQuery;
import com.wl.llshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/6
 * Time: 11:23
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemAction {
    //日志
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value="/item/{itemId}",method = RequestMethod.GET)
    public TbItem getByid(@PathVariable("itemId") Long itemId){
        System.out.println(itemId);
        TbItem byId = itemService.getById(itemId);
        return byId;
    }

    @ResponseBody
    @RequestMapping(value="/items")
    public Result<TbItemCustum> listItemByPage(Page page, Order order, TbItemQuery query){
        Result<TbItemCustum> list = itemService.listItemByPage(page,order,query);

        return list;
    }
    //修改状态——删除
    @ResponseBody
    @RequestMapping(value = "items/batch",method = RequestMethod.POST)
    public int updatestutas(@RequestParam("ids[]") List<Long> ids){
        return itemService.updateItemsByIds(ids);
    }
    //修改状态——上架
    @ResponseBody
    @RequestMapping(value = "items/uprows",method = RequestMethod.POST)
    public int updateuprows(@RequestParam("ids[]") List<Long> ids){
        return itemService.updateuprows(ids);
    }
    //修改状态——下架
    @ResponseBody
    @RequestMapping(value = "items/downrows",method = RequestMethod.POST)
    public int updatedownrows(@RequestParam("ids[]") List<Long> ids){
        return itemService.updatedownrows(ids);
    }

    //添加商品
    @ResponseBody
    @RequestMapping(value = "item")
    public int saveItem(TbItem tbItem,String content){
        Long price = tbItem.getPrice();
        System.out.println(price+"~~~~~~~~~~");
        int i = itemService.saveItem(tbItem, content);
        return i;
    }

}
