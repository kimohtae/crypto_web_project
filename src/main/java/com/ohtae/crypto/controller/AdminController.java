package com.ohtae.crypto.controller;

import com.ohtae.crypto.service.MemberService;
import com.ohtae.crypto.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired MemberService Mservice;
    @Autowired PostService PService;

    @GetMapping("/admin/member")
    public String getMemberInfoPage(
        Model model ,
        @RequestParam @Nullable Integer offset,
        @RequestParam @Nullable String newOrder,
        @RequestParam @Nullable String order,
        @RequestParam @Nullable String adesc
        ){
        model.addAttribute("data", Mservice.selectMemberList(offset,newOrder,order,adesc));

        return "/admin_page/member_info";
    }

    @GetMapping("/admin/post")
    public String getPostInfoPage(
        Model model,
        @RequestParam @Nullable Integer offset,
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable String type,
        @RequestParam @Nullable String order,
        @RequestParam @Nullable String dir
        ){
        model.addAttribute("data", PService.selectPostList(offset, keyword, type, order, dir));
        
        return "/admin_page/post_info";
    }
}
