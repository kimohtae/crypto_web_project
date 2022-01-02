package com.ohtae.crypto.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohtae.crypto.data.PostHistoryVO;
import com.ohtae.crypto.data.PostInfoVO;
import com.ohtae.crypto.data.PostReplyInfoVO;
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
    public List<PostReplyInfoVO> selectPostReplyInfo(Integer seq){
        List<PostReplyInfoVO> data = Pmapper.selectPostReplyInfo(seq);
        for(int i=0; i<data.size(); i++){
            SimpleDateFormat dateFormatted = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            DecimalFormat likeFormatted = new DecimalFormat("###,###");
            
            String D = dateFormatted.format(data.get(i).getPri_reg_dt());
            String L = likeFormatted.format(data.get(i).getPri_like());

            data.get(i).setPri_format_dt(D);
            data.get(i).setPri_format_like(L);

            PostReplyInfoVO form = data.get(i);
            data.set(i, form);
        }
        return data;
    }

    public void updatePostToPrivateStatus(Integer seq){
        PostHistoryVO his = new PostHistoryVO();
        his.setPih_pi_seq(seq);
        his.setPih_type("Update");
        his.setPih_content("Private");
        Pmapper.insertPostHis(his);
        
        Pmapper.updatePostToPrivateStatus(seq);
    }
    public void updatePostToPublicStatus(Integer seq){
        PostHistoryVO his = new PostHistoryVO();
        his.setPih_pi_seq(seq);
        his.setPih_type("Update");
        his.setPih_content("Public");
        Pmapper.insertPostHis(his);
        
        Pmapper.updatePostToPublicStatus(seq);
    }


    public Map<String, Object> deletePostInfo(Integer seq){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Pmapper.deletePostInfo(seq);
        map.put("status", true);
        map.put("message", "삭제가 완료 되었습니다.");

        PostHistoryVO his = new PostHistoryVO();
        his.setPih_pi_seq(seq);
        his.setPih_type("Delete");
        Pmapper.insertPostHis(his);

        return map;
    }
    public Map<String, Object> deletePostReplyInfo(Integer seq){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Pmapper.deletePostReplyInfo(seq);
        map.put("status", true);
        map.put("message", "삭제가 완료 되었습니다.");
        return map;
    }

    
}
