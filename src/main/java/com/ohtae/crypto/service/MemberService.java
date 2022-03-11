package com.ohtae.crypto.service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ohtae.crypto.data.MemberHistoryVO;
import com.ohtae.crypto.data.MemberInfoVO;
import com.ohtae.crypto.mapper.MemberInfoMapper;
import com.ohtae.crypto.utils.AESAlgorithm;

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
    public MemberInfoVO selectMemberInfo(Integer seq){
        return Mmapper.selectMemberInfo(seq);
    }
    public Map<String,Object> selectLoginInfo(MemberInfoVO data, HttpSession session)throws Exception{
        Map<String,Object> resultMap = new LinkedHashMap<>();
        if(data.getMi_id().equals("") || data.getMi_id() == null){
            resultMap.put("status", false);
            resultMap.put("message", "아이디를 입력해 주세요.");
            return resultMap;
        }
        if(data.getMi_pwd().equals("") || data.getMi_pwd() == null){
            resultMap.put("status", false);
            resultMap.put("message", "비밀번호를 입력해 주세요.");
            return resultMap;
        }

        MemberInfoVO member_info = Mmapper.selectLoginInfo(data.getMi_id());
        
        String origin_pwd = member_info.getMi_pwd();
        String input_pwd = AESAlgorithm.Encrypt(data.getMi_pwd());

        if(!origin_pwd.equals(input_pwd)){
            resultMap.put("status", false);
            resultMap.put("message", "잘못된 아이디 혹은 비밀번호입니다.");
            return resultMap;
        }
        if(member_info.getMi_status() != 5){
            resultMap.put("status", false);
            resultMap.put("message", "접근 권한이 없는 아이디입니다.");
            return resultMap;
        }

        member_info.setMi_pwd(null);
        session.setAttribute("login_info", member_info);
        resultMap.put("status", true);
        return resultMap;
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
            data.setMi_pwd(AESAlgorithm.Encrypt(data.getMi_pwd()));
            Mmapper.insertMemberInfo(data);
        }catch(Exception e){
            map.put("status", false);
            map.put("message", "잘못된 입력입니다.");
            return map;
        }
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
