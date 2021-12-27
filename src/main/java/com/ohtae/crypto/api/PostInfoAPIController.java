package com.ohtae.crypto.api;

import com.ohtae.crypto.data.PostInfoVO;
import com.ohtae.crypto.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostInfoAPIController {
    @Autowired PostService PService;

    @GetMapping("/admin/post/select")
    public PostInfoVO selectPostInfo(@RequestParam Integer seq){
        return PService.selectPostInfo(seq);
    }
}
