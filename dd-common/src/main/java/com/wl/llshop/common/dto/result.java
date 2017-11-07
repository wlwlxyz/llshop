package com.wl.llshop.common.dto;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/7
 * Time: 16:13
 * Version:V1.0
 */
public class result<T> {
    //总行数
    private  Long total;
    //商品详情
    private List<T> rows;



    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
