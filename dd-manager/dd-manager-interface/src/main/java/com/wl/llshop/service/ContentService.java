package com.wl.llshop.service;

import com.wl.llshop.pojo.po.TbContent;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/20
 * Time: 22:15
 * Version:V1.0
 */
public interface ContentService {
    /**
     * 根据内容编号查询出图pian
     * @param id
     * @return
     */
    List<TbContent> listContentsByCid(Long id);
}
