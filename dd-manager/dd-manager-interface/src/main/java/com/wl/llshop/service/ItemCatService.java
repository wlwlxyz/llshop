package com.wl.llshop.service;

import com.wl.llshop.common.dto.TreeNode;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/10
 * Time: 20:29
 * Version:V1.0
 */
public interface ItemCatService {
    List<TreeNode> listItemCatByPid(Long parentId);
}
