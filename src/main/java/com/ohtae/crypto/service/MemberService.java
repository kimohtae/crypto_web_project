package com.ohtae.crypto.service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohtae.crypto.data.MemberInfoVO;
import com.ohtae.crypto.mapper.MemberInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberInfoMapper Mmapper;

    public Map<String, Object> selectMemberList(Integer offset,String newOrder, String order,String adesc){
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        if(newOrder == null|| newOrder.equals("")){
            newOrder="mi_seq desc";    
            if(offset == null) offset=0;
        }else{
            if(offset == null){
                offset=0;
                if(newOrder.equals(order) && adesc.equals("asc")){
                    adesc="desc";
                }else{
                    adesc="asc";
                }
            }
            map.put("order", newOrder);
            map.put("adesc", adesc);    
            newOrder = newOrder+ " " +adesc;
        }
            

        List<MemberInfoVO> list = Mmapper.selectMemberList(offset, newOrder);
        Integer cnt = Mmapper.selectMemberCounts();
        Integer page = cnt/30+(cnt%30==0?0:1);
        map.put("offset", offset);
        map.put("list", list);
        map.put("cnt", cnt);
        map.put("page", page);

        return map;
    }

    public Map<String, Object> insertMemberInfo(MemberInfoVO data){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(data.getMi_id().equals("")){
            map.put("status", false);
            map.put("message", "아이디를 입력해 주세요");
            return map;
        }
        if(data.getMi_email().equals("")){
            map.put("status", false);
            map.put("message", "이메일을 입력해 주세요");
            return map;
        }
        if(data.getMi_phone().equals("")){
            map.put("status", false);
            map.put("message", "전화번호를 입력해 주세요");
            return map;
        }
        if(data.getMi_name().equals("")){
            map.put("status", false);
            map.put("message", "이름을 입력해 주세요");
            return map;
        }
        if(data.getMi_birth().equals("")){
            map.put("status", false);
            map.put("message", "생년월일을 입력해 주세요");
            return map;
        }
        try{
            Mmapper.insertMemberInfo(data);
        }catch(Exception e){
            map.put("status", false);
            map.put("message", "잘못된 입력입니다.");
            return map;
        }
        
        map.put("status", true);
        map.put("message", "추가 되었습니다.");
        return map;
    }

    public void deleteMemberInfo(Integer seq){
        Mmapper.deleteMemberInfo(seq);
    }
}
