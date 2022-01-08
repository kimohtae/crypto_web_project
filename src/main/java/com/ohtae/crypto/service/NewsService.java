package com.ohtae.crypto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohtae.crypto.data.NewsPageInfoVO;
import com.ohtae.crypto.mapper.NewsPageInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired NewsPageInfoMapper Nmapper;

    public Map<String, Object> selectNewsList(Integer offset, String order,String keyword){
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        if(offset==null)offset=0;
        if(order==null || order.equals(" "))order="npi_seq";
        if(keyword==null || keyword.equals(" "))keyword="%%";

        List<NewsPageInfoVO> list = Nmapper.selectNewsList(offset, order, keyword);
        Integer cnt = Nmapper.selectNewsCounts();
        Integer page = cnt/30+(cnt%30==0?0:1);
        map.put("offset", offset);
        map.put("list", list);
        map.put("cnt", cnt);
        map.put("page", page);

        return map;
    }
    

    public void insertNewsInfo(NewsPageInfoVO data){
        Nmapper.insertNewsInfo(data);
    }

    public void deleteNewsInfo(Integer seq){
        Nmapper.deleteNewsInfo(seq);
    }
}
