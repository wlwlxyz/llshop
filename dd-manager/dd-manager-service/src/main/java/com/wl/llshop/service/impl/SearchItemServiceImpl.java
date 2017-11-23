package com.wl.llshop.service.impl;

import com.wl.llshop.dao.TbItemCustomMapper;
import com.wl.llshop.pojo.vo.TbSearchItemCustom;
import com.wl.llshop.service.SearchItemService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/22
 * Time: 18:51
 * Version:V1.0
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {
    @Autowired
    private TbItemCustomMapper tbItemCustomDao;
    @Autowired
    private SolrServer solrserver;

    @Override
    public boolean importAllItems() {
        //采集数据到list
        List<TbSearchItemCustom> list = tbItemCustomDao.searchItem();
        //遍历
        for(TbSearchItemCustom tbSearchItemCustom:list){
            //拿到solr的文档域
            SolrInputDocument document = new SolrInputDocument();
            //向文档对象中添加域：对应schema.xml配置文件中的域名
           document.addField("id",tbSearchItemCustom.getId());
            document.addField("item_title", tbSearchItemCustom.getTitle());
            document.addField("item_sell_point", tbSearchItemCustom.getSellPoint());
            document.addField("item_price", tbSearchItemCustom.getPrice());
            document.addField("item_image", tbSearchItemCustom.getImage());
            document.addField("item_category_name", tbSearchItemCustom.getCatName());
            try {
                solrserver.add(document);
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            solrserver.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
