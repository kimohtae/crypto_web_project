package com.ohtae.crypto.api;

import java.util.Map;

import com.ohtae.crypto.data.PostInfoVO;
import com.ohtae.crypto.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostInfoAPIController {
    @Autowired PostService PService;

    @GetMapping("/admin/post/select")
    public PostInfoVO selectPostInfo(@RequestParam Integer seq){
        return PService.selectPostInfo(seq);
    }
    @PatchMapping("/admin/post/update/toPrivate")
    public void updatePostToPrivateStatus(@RequestParam Integer seq){
        PService.updatePostToPrivateStatus(seq);
    }
    @PatchMapping("/admin/post/update/toPublic")
    public void updatePostToPublicStatus(@RequestParam Integer seq){
        PService.updatePostToPublicStatus(seq);
    }

    @DeleteMapping("/admin/post/delete")
    public Map<String, Object> deletePostInfo(@RequestParam Integer seq){
        return PService.deletePostInfo(seq);
    }
}
