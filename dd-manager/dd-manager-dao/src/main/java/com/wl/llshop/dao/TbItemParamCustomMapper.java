package com.wl.llshop.dao;

import com.wl.llshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map; /**
 * User: Administrator
 * Date: 2017/11/13
 * Time: 21:05
 * Version:V1.0
 */
public interface TbItemParamCustomMapper {

    int countItemParams();

    List<TbItemParamCustom> listItemParamsByPage(Map<String, Object> map);
}
