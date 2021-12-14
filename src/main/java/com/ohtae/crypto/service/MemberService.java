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
}
