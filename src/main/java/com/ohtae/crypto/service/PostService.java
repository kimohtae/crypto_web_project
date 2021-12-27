package com.ohtae.crypto.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ohtae.crypto.data.PostInfoVO;
import com.ohtae.crypto.mapper.PostInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired PostInfoMapper Pmapper;

    public Map<String,Object> selectPostList(Integer offset, String keyword, String type){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(offset==null) offset=0;
        if(keyword==null){
            keyword = "%%";
        }else{
            keyword = "%" + keyword +"%";
        }
        if(type==null) type="pi_title";

        map.put("list", Pmapper.selectPostList(offset, keyword, type));
        Integer cnt = Pmapper.selectPostCounts(keyword, type);
        Integer page = cnt/20 + (cnt%20>0?1:0);
        map.put("page", page);

        return map;
    }
    public PostInfoVO selectPostInfo(Integer seq){
        return Pmapper.selectPostInfo(seq);
    }
    
}
