package com.ohtae.crypto.api;
import com.ohtae.crypto.data.NewsPageInfoVO;
import com.ohtae.crypto.mapper.NewsPageInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsPageAPIController {
    @Autowired NewsPageInfoMapper MPService;

    @PostMapping("/admin/news/insert")
    public void insertNewsInfo(@RequestBody NewsPageInfoVO data){
        MPService.insertNewsInfo(data);
    }
    @DeleteMapping("/admin/news/delete")
    public void deleteNewsInfo(@RequestParam Integer seq){
        MPService.deleteNewsInfo(seq);
    }    
}
