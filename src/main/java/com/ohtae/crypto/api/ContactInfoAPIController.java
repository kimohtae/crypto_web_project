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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactInfoAPIController {
    @Autowired ContactService CService;

    @GetMapping("/admin/contact/select")
    public ContactInfoVO selectContactInfo(@RequestParam Integer seq){
        return CService.selectContactInfo(seq);
    }
    @GetMapping("/admin/contact/reply/select")
    public List<ContactReplyInfoVO> selectContactReplyInfo(@RequestParam Integer seq){
        return CService.selectContactReplyInfo(seq);
    }
    @PatchMapping("/admin/contact/update")
    public void updateContactStatus(
        @RequestParam Integer seq,
        @RequestParam Integer status
        ){
        CService.updateContactStatus(seq,status);
    }
    @DeleteMapping("/admin/contact/delete")
    public Map<String, Object> deleteContactInfo(@RequestParam Integer seq){
        return CService.deleteContactInfo(seq);
    }
    @DeleteMapping("/admin/contact/reply/delete")
    public Map<String, Object> deleteContactReplyInfo(@RequestParam Integer seq){
        return CService.deleteContactReplyInfo(seq);
    }
}
