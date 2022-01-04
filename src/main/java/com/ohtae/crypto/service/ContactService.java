package com.ohtae.crypto.service;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohtae.crypto.data.ContactHistoryVO;
import com.ohtae.crypto.data.ContactInfoVO;
import com.ohtae.crypto.data.PostReplyInfoVO;
import com.ohtae.crypto.mapper.ContactInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired ContactInfoMapper Cmapper;

    public Map<String,Object> selectContactList(Integer offset){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(offset==null) offset=0;
        
        map.put("list", Cmapper.selectContactList(offset));
        Integer cnt = Cmapper.selectContactCounts();
        Integer page = cnt/20 + (cnt%20>0?1:0);
        map.put("page", page);
        map.put("cnt", cnt);
        return map;
    }
    public ContactInfoVO selectContactInfo(Integer seq){
        return Cmapper.selectContactInfo(seq);
    }
    public List<PostReplyInfoVO> selectContactReplyInfo(Integer seq){
        List<PostReplyInfoVO> data = Cmapper.selectContactReplyInfo(seq);
        for(int i=0; i<data.size(); i++){
            SimpleDateFormat dateFormatted = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");            
            String D = dateFormatted.format(data.get(i).getPri_reg_dt());

            data.get(i).setPri_format_dt(D);

            PostReplyInfoVO form = data.get(i);
            data.set(i, form);
        }
        return data;
    }

    public void updateContactStatus(Integer seq, Integer status){
        ContactHistoryVO his = new ContactHistoryVO();
        String S = "";
        his.setCih_ci_seq(seq);
        his.setCih_type("Update");
        
        if(status==1){
            S = "Complete Reply";
        }else{
            S = "Not Yet Reply";
        }
        his.setCih_content(S);
        Cmapper.insertContactHis(his);
    
        Cmapper.updateContactStatus(seq,status);
    }



    public Map<String, Object> deleteContactInfo(Integer seq){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Cmapper.deleteContactInfo(seq);
        map.put("status", true);
        map.put("message", "삭제가 완료 되었습니다.");

        ContactHistoryVO his = new ContactHistoryVO();
        his.setCih_ci_seq(seq);
        his.setCih_type("Delete");
        Cmapper.insertContactHis(his);

        return map;
    }
    public Map<String, Object> deleteContactReplyInfo(Integer seq){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Cmapper.deleteContactReplyInfo(seq);
        map.put("status", true);
        map.put("message", "삭제가 완료 되었습니다.");
        return map;
    }

    
}
