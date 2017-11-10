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
    private String updatedtime;
    private String priceView;
    private String statusName;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getPriceView() {
        return priceView;
    }

    public void setPriceView(String priceView) {
        this.priceView = priceView;
    }

    public String getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(String updatedtime) {
        this.updatedtime = updatedtime;
    }

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
