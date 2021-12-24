package com.ohtae.crypto.controller;

import com.ohtae.crypto.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    MemberService service;


    @GetMapping("/admin/member")
    public String getMemberInfoPage(
        Model model ,
        @RequestParam @Nullable Integer offset,
        @RequestParam @Nullable String newOrder,
        @RequestParam @Nullable String order,
        @RequestParam @Nullable String adesc
        ){
        model.addAttribute("data", service.selectMemberList(offset,newOrder,order,adesc));

        return "/admin_page/member_info";
    }
}
