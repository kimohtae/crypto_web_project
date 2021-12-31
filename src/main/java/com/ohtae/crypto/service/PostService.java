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

    public Map<String,Object> selectPostList(Integer offset, String keyword, String type, String order, String dir){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(offset==null) offset=0;
        map.put("keyword", keyword);
        if(keyword==null){
            keyword = "%%";
        }else{
            keyword = "%" + keyword +"%";
        }
        if(type==null) type="pi_title";
        if(order==null) order="pi_seq";
        if(dir==null) dir="desc";

        map.put("list", Pmapper.selectPostList(offset, keyword, type, order, dir));
        Integer cnt = Pmapper.selectPostCounts(keyword, type);
        Integer page = cnt/20 + (cnt%20>0?1:0);
        map.put("page", page);
        map.put("cnt", cnt);
        map.put("offset", offset);
        map.put("type", type);
        map.put("order", order);
        map.put("dir", dir);

        return map;
    }
    public PostInfoVO selectPostInfo(Integer seq){
        return Pmapper.selectPostInfo(seq);
    }
    

    public void updatePostToPrivateStatus(Integer seq){
            Pmapper.updatePostToPrivateStatus(seq);
    }
    public void updatePostToPublicStatus(Integer seq){
            Pmapper.updatePostToPublicStatus(seq);
    }


    public Map<String, Object> deletePostInfo(Integer seq){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Pmapper.deletePostInfo(seq);
        map.put("status", true);
        map.put("message", "삭제가 완료 되었습니다.");

        return map;
    }
}
