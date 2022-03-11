package com.ohtae.crypto.api;

import java.util.List;
import java.util.Map;

import com.ohtae.crypto.data.ContactInfoVO;
import com.ohtae.crypto.data.ContactReplyInfoVO;
import com.ohtae.crypto.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactInfoAPIController {
    @Autowired ContactService cService;

    @GetMapping("/admin/contact/select")
    public ContactInfoVO selectContactInfo(@RequestParam Integer seq){
        return cService.selectContactInfo(seq);
    }
    @GetMapping("/admin/contact/reply/select")
    public List<ContactReplyInfoVO> selectContactReplyInfo(@RequestParam Integer seq){
        return cService.selectContactReplyInfo(seq);
    }
    @PostMapping("/admin/contact/reply/insert")
    public void insertContactReplyInfo(@RequestBody ContactReplyInfoVO data){
        cService.insertContactReplyInfo(data);
    }
    @PatchMapping("/admin/contact/update")
    public void updateContactStatus(
        @RequestParam Integer seq,
        @RequestParam Integer status
        ){
        cService.updateContactStatus(seq,status);
    }
    @DeleteMapping("/admin/contact/delete")
    public Map<String, Object> deleteContactInfo(@RequestParam Integer seq){
        return cService.deleteContactInfo(seq);
    }
    @DeleteMapping("/admin/contact/reply/delete")
    public Map<String, Object> deleteContactReplyInfo(@RequestParam Integer seq){
        return cService.deleteContactReplyInfo(seq);
    }
}
