package com.ohtae.crypto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohtae.crypto.data.TableInfoVO;
import com.ohtae.crypto.mapper.TableInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {
    @Autowired TableInfoMapper Tmapper;

    public Map<String, Object> selectTableList(String keyword){
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        if(keyword == null || keyword.equals("")){
            keyword = "%%";
        }else{
            keyword = "%"+ keyword +"%";
        }

        map.put("list", Tmapper.selectTableList(keyword));
        return map;
    }

    public TableInfoVO selectTableInfo(Integer seq){
        return Tmapper.selectTableInfo(seq);
    }

    public Map<String, Object> insertTableCat(String cat, String type){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if

        
        MemberHistoryVO H = new MemberHistoryVO();
        H.setMh_mi_seq(Mmapper.selectRecentSeq());
        H.setMh_type("New");
        String contents = data.getMi_id() +"|"+ data.getMi_email() +"|"+ data.getMi_phone() +"|"+ data.getMi_name() +"|"+ data.getMi_birth();
        H.setMh_content(contents);
        Mmapper.insertMemberHis(H);
        
        
        map.put("status", true);
        map.put("message", "추가 되었습니다.");
        return map; 
    }

    public Map<String, Object> updateMemberInfo(MemberInfoVO data){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(data.getMi_id().equals("")){
            map.put("status", false);
            map.put("message", "아이디를 입력해 주세요");
            return map;
        }
        if(data.getMi_name().equals("")){
            map.put("status", false);
            map.put("message", "이름을 입력해 주세요");
            return map;
        }
        if(data.getMi_phone().equals("")){
            map.put("status", false);
            map.put("message", "전화번호를 입력해 주세요");
            return map;
        }
        if(data.getMi_birth().equals("")){
            map.put("status", false);
            map.put("message", "생년월일을 입력해 주세요");
            return map;
        }
        if(data.getMi_email().equals("")){
        map.put("status", false);
        map.put("message", "이메일을 입력해 주세요");
        return map;
        }
        if(data.getMi_image().equals("")){
            map.put("status", false);
            map.put("message", "이미지를 넣어 주세요");
            return map;
        }
        try{
            Mmapper.updateMemberInfo(data);
        }catch(Exception e){
            map.put("status", false);
            map.put("message", "잘못된 입력입니다.");
            return map;
        }
        
        MemberHistoryVO H = new MemberHistoryVO();
        H.setMh_mi_seq(data.getMi_seq());
        H.setMh_type("Update");
        String contents = data.getMi_id() +"|"+ data.getMi_email() +"|"+ data.getMi_phone() +"|"+ data.getMi_name() +"|"+ data.getMi_birth() +"|"+ data.getMi_image();
        H.setMh_content(contents);
        Mmapper.insertMemberHis(H);


        map.put("status", true);
        map.put("message", "변경 되었습니다.");
        return map;
    }
    public void updateMemberStatus(Integer seq,Integer status){
        MemberHistoryVO H = new MemberHistoryVO();
        H.setMh_mi_seq(seq);
        H.setMh_type("Update");
        String contents = ""+status+"";
        H.setMh_content(contents);
        Mmapper.insertMemberHis(H);
        Mmapper.updateMemberStatus(seq,status);
    }




    public void deleteMemberInfo(Integer seq){
        MemberHistoryVO H = new MemberHistoryVO();
        H.setMh_mi_seq(seq);
        H.setMh_type("Delete");
        Mmapper.insertMemberHis(H);
        Mmapper.deleteMemberInfo(seq);
    }
}
