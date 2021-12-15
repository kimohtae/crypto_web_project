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

    public Map<String, Object> selectMemberList(Integer offset){
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        if(offset==null)offset=0;
        List<MemberInfoVO> list = Mmapper.selectMemberList(offset);
        Integer cnt = Mmapper.selectMemberCounts();
        Integer page = cnt/20+(cnt%20==0?0:1);

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
        if(data.getMi_address().equals("")){
            map.put("status", false);
            map.put("message", "주소를 입력해 주세요");
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
