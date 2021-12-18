package com.ohtae.crypto.api;


import java.util.Map;

import com.ohtae.crypto.data.MemberInfoVO;
import com.ohtae.crypto.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberInfoAPIController {
    @Autowired
    MemberService service;

    @GetMapping("/admin/member/select")
    public MemberInfoVO selectMemberInfo(@RequestParam Integer seq){
        return service.selectMemberInfo(seq);
    }

    @PostMapping("/admin/member/insert")
    public Map<String, Object> insertMemberInfo(@RequestBody MemberInfoVO data){
        return service.insertMemberInfo(data);
    }
    
    @PatchMapping("/admin/member/update")
    public Map<String, Object> updateMemberInfo(@RequestBody MemberInfoVO data){
        return service.updateMemberInfo(data);
    }
    @PatchMapping("/admin/member/update/status")
    public void updateMemberStatus(@RequestParam Integer seq, @RequestParam Integer status){
        service.updateMemberStatus(seq, status);
    }
    
    @DeleteMapping("/admin/member/delete")
    public void deleteMemberInfo(@RequestParam Integer seq){
        service.deleteMemberInfo(seq);
    }
}
