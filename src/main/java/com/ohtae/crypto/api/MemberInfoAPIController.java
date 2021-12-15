package com.ohtae.crypto.api;


import java.util.Map;

import com.ohtae.crypto.data.MemberInfoVO;
import com.ohtae.crypto.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberInfoAPIController {
    @Autowired
    MemberService service;

    @PostMapping("/admin/member/insert")
    public Map<String, Object> insertMemberInfo(@RequestBody MemberInfoVO data){
        return service.insertMemberInfo(data);
    }


    @DeleteMapping("/admin/member/delete")
    public void deleteMemberInfo(@RequestParam Integer seq){
        service.deleteMemberInfo(seq);
    }
}
