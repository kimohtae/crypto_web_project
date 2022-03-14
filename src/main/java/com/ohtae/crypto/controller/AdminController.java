package com.ohtae.crypto.controller;

import java.util.Map;

import com.ohtae.crypto.service.ContactService;
import com.ohtae.crypto.service.MemberService;
import com.ohtae.crypto.service.NewsService;
import com.ohtae.crypto.service.PostService;
import com.ohtae.crypto.service.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired MemberService mService;
    @Autowired PostService pService;
    @Autowired ContactService cService;
    @Autowired NewsService nService;
    @Autowired StatisticsService stService;

    @GetMapping("/admin/member")
    public String getMemberInfoPage(
        Model model ,
        @RequestParam @Nullable Integer offset,
        @RequestParam @Nullable String newOrder,
        @RequestParam @Nullable String order,
        @RequestParam @Nullable String adesc
        ){
        model.addAttribute("data", mService.selectMemberList(offset,newOrder,order,adesc));

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
        model.addAttribute("data", pService.selectPostList(offset, keyword, type, order, dir));
        
        return "/admin_page/post_info";
    }
    
    @GetMapping("/admin/contact")
    public String getContactInfoPage(
        Model model,
        @RequestParam @Nullable Integer offset
        ){
        model.addAttribute("data", cService.selectContactList(offset));
        
        return "/admin_page/contact_info";
    }

    
    @GetMapping("/admin/news")
    public String selectNewsList(
        @RequestParam @Nullable Integer offset,
        @RequestParam @Nullable String order,
        @RequestParam @Nullable String keyword,
        Model model
        ){
        model.addAttribute("data", nService.selectNewsList(offset, order, keyword));
        return "/admin_page/news_page_info";
    }

    @GetMapping("/admin/statistics")
    public String selectStatisticsList(
        Model model,
        @RequestParam @Nullable Integer offset,
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable String type
        ){
        Map<String,Object> resultMap = stService.selectStatisticsList(type, keyword, offset);
        if(type == null)type = "all";
        if(offset == null)offset = 0;
        model.addAttribute("type",type);
        model.addAttribute("offset",offset);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",resultMap.get("page"));
        model.addAttribute("data",resultMap.get("data"));
        model.addAttribute("category",stService.selectStatisticsTableList());
        return "/admin_page/statistics";
    }

    @GetMapping("/")
    public String getMainPage(){
        return "/index";
    }

    @GetMapping("/admin/summary")
    public String getSummaryPage(){
        return "/admin_page/summary";
    }
}
