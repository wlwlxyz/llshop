package com.wl.llshop.web;

import com.wl.llshop.common.dto.MessageResult;
import com.wl.llshop.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Administrator
 * Date: 2017/11/22
 * Time: 17:53
 * Version:V1.0
 */
@Controller
public class SearchItemAction {

    @Autowired
    private SearchItemService searchItemService;

    @ResponseBody
    @RequestMapping("item/search/import")
    public MessageResult searchItem(){
        boolean b = searchItemService.importAllItems();
        MessageResult mr=new MessageResult();
        if (b){
            mr.setSuccess(true);
            mr.setMessage("索引导入成功~");
        }else{
            mr.setSuccess(false);
            mr.setMessage("索引导入失败~");
        }


        return mr;
    }
}
