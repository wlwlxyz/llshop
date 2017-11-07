package com.wl.llshop.pojo.vo;

import com.wl.llshop.pojo.po.TbItem;

/**
 * User: Administrator
 * Date: 2017/11/7
 * Time: 18:00
 * Version:V1.0
 */
public class TbItemCustum extends TbItem{
    private String catName;
    private String stuting;

    public String getStuting() {
        return stuting;
    }

    public void setStuting(String stuting) {
        this.stuting = stuting;
    }



    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

}
