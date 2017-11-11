package com.wl.llshop.service.impl;

import com.wl.llshop.common.dto.TreeNode;
import com.wl.llshop.dao.TbItemCatMapper;
import com.wl.llshop.pojo.po.TbItemCat;
import com.wl.llshop.pojo.po.TbItemCatExample;
import com.wl.llshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/10
 * Time: 20:33
 * Version:V1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatDao;
    @Override
    public List<TreeNode> listItemCatByPid(Long parentId) {
        //创建模板
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = tbItemCatDao.selectByExample(example);
        ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for(int i=0;i<list.size();i++){
            TreeNode treeNode=new TreeNode();
            treeNode.setId(list.get(i).getId());
            treeNode.setText(list.get(i).getName());
            treeNode.setState(list.get(i).getIsParent()?"closed":"open");
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }
}
