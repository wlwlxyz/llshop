package com.wl.llshop.search.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Administrator
 * Date: 2017/11/22
 * Time: 21:09
 * Version:V1.0
 */
@Controller
public class searchAction {
    @RequestMapping("/")
    public String portalIndex(Model model){
        return "search";
    }
}
