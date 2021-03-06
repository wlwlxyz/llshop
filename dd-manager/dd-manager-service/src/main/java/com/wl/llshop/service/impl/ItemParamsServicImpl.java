package com.wl.llshop.service.impl;

import com.wl.llshop.common.dto.Page;
import com.wl.llshop.common.dto.Result;
import com.wl.llshop.dao.TbItemParamCustomMapper;
import com.wl.llshop.dao.TbItemParamMapper;
import com.wl.llshop.pojo.po.TbItemParam;
import com.wl.llshop.pojo.po.TbItemParamExample;
import com.wl.llshop.pojo.vo.TbItemParamCustom;
import com.wl.llshop.service.ItemParamsServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 2017/11/13
 * Time: 20:58
 * Version:V1.0
 */
@Service
public class ItemParamsServicImpl implements ItemParamsServic {
    @Autowired
    private TbItemParamCustomMapper itemParamCustomDao;
    @Autowired
    private TbItemParamMapper tbItemParamDao;
    @Override
    public Result<TbItemParamCustom> ListItemParamsByPage(Page page) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("page",page);
        int i = itemParamCustomDao.countItemParams();

        List<TbItemParamCustom> list = itemParamCustomDao.listItemParamsByPage(map);
        Result<TbItemParamCustom>  result = new Result<TbItemParamCustom>();
        long count = (long)i;
        result.setTotal(count);
        result.setRows(list);

        return result;
    }

    @Override
    public int saveParamItem(Long cid, String paramDate) {
        TbItemParam tbItemParam=new TbItemParam();
        tbItemParam.setItemCatId(cid);
        tbItemParam.setParamData(paramDate);
        tbItemParam.setCreated(new Date());
        tbItemParam.setUpdated(new Date());
        int i = tbItemParamDao.insertSelective(tbItemParam);
        return i;
    }

    @Override
    public TbItemParam getItemParamByCid(Long cid) {

        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> list = tbItemParamDao.selectByExampleWithBLOBs(example);
        TbItemParam tbItemParam = null;
        if(list != null && list.size() > 0){
            tbItemParam = list.get(0);
        }
        return tbItemParam;
    }
}
