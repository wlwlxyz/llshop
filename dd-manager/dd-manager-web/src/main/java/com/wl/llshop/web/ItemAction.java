package com.wl.llshop.web;

import com.wl.llshop.common.dto.Page;
import com.wl.llshop.common.dto.result;
import com.wl.llshop.pojo.po.TbItem;
import com.wl.llshop.pojo.vo.TbItemCustum;
import com.wl.llshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public  result<TbItemCustum> listItemByPage(Page page){
        result<TbItemCustum> list = itemService.listItemByPage(page);
        int size = list.getRows().size();
        for (int i=0;i<size;i++){
            if(list.getRows().get(i).getStatus()==1){
                list.getRows().get(i).setStuting("正常");
            }
            if(list.getRows().get(i).getStatus()==2){
                list.getRows().get(i).setStuting("下架");
            }
            if(list.getRows().get(i).getStatus()==3){
                list.getRows().get(i).setStuting("删除");
            }
        }
        System.out.println(list);
        return list;
    }
   /* public List<TbItem> listItems(){
        List<TbItem> tbItems = itemService.listItems();
        return tbItems;
    }*/

}
