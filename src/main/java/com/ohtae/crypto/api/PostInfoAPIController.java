package com.ohtae.crypto.api;

import java.util.List;
import java.util.Map;

import com.ohtae.crypto.data.PostInfoVO;
import com.ohtae.crypto.data.PostReplyInfoVO;
import com.ohtae.crypto.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostInfoAPIController {
    @Autowired PostService pService;

    @GetMapping("/admin/post/select")
    public PostInfoVO selectPostInfo(@RequestParam Integer seq){
        return pService.selectPostInfo(seq);
    }
    @GetMapping("/admin/post/reply/select")
    public List<PostReplyInfoVO> selectPostReplyInfo(@RequestParam Integer seq){
        return pService.selectPostReplyInfo(seq);
    }
    @PatchMapping("/admin/post/update/toPrivate")
    public void updatePostToPrivateStatus(@RequestParam Integer seq){
        pService.updatePostToPrivateStatus(seq);
    }
    @PatchMapping("/admin/post/update/toPublic")
    public void updatePostToPublicStatus(@RequestParam Integer seq){
        pService.updatePostToPublicStatus(seq);
    }
    @DeleteMapping("/admin/post/delete")
    public Map<String, Object> deletePostInfo(@RequestParam Integer seq){
        return pService.deletePostInfo(seq);
    }
    @DeleteMapping("/admin/post/reply/delete")
    public Map<String, Object> deletePostReplyInfo(@RequestParam Integer seq){
        return pService.deletePostReplyInfo(seq);
    }
}
