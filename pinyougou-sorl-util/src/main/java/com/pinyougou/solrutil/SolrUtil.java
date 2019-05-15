package com.pinyougou.solrutil;

import com.alibaba.fastjson.JSON;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component("solrUtil")
public class SolrUtil {

    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private SolrTemplate solrTemplate;

    public static void main(String[] args) {
        // 加载spring文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");
        SolrUtil bean = (SolrUtil) applicationContext.getBean("solrUtil");
//        bean.importSolr();

        Map<String, String> map = new ConcurrentHashMap<>();

        map.put("keyworkds", "阿尔卡特");

        bean.searchQuery(map);
    }

    public void importSolr() {

        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo("1");

        List<TbItem> items = itemMapper.selectByExample(example);
        for (TbItem item : items) {
            // 获取到{"机身内存":"16G","网络":"联通3G"} 使用fastJson转换
            String spec = item.getSpec();
            Map map = JSON.parseObject(spec, Map.class);
            item.setSpecMap(map);
        }

        solrTemplate.saveBeans(items);
        solrTemplate.commit();
        System.out.println("添加成功");

    }

    public void searchQuery(Map map) {

        Query query = new SimpleQuery("*:*");
        Criteria criteria = new Criteria("item_keywords").is(map.get("keyworkds"));
        query.addCriteria(criteria);

        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
        List<TbItem> content = page.getContent();

        for (TbItem item : content) {
            System.out.println(item.getTitle());
        }
    }


}
