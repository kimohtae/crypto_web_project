package com.ohtae.crypto.api;

import com.ohtae.crypto.data.CommunityTableVO;
import com.ohtae.crypto.data.NewsTableVO;
import com.ohtae.crypto.data.StatisticsTableVO;
import com.ohtae.crypto.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/category")
public class CategoryAPIContorller {
    @Autowired CategoryService cgService;

    @PutMapping("/news")
    public String putNewsCategory(@RequestBody NewsTableVO data){
        cgService.insertNewsCategoryInfo(data);
        return "카테고리가 추가되었습니다.";
    }
    @PutMapping("/commumity")
    public String putCommunityCategory(@RequestBody CommunityTableVO data){
        cgService.insertCommunityCategoryInfo(data);
        return "카테고리가 추가되었습니다.";
    }
    @PutMapping("/statistics")
    public String putStatisticsCategory(@RequestBody StatisticsTableVO data){
        cgService.insertStatisticsCategoryInfo(data);
        return "카테고리가 추가되었습니다.";
    }

    @GetMapping("/news")
    public NewsTableVO getNewsCategoryInfo(@RequestParam Integer seq){
        return cgService.selectNewsCategoryInfoBySeq(seq);
    }
    @GetMapping("/commumity")
    public CommunityTableVO getCommunityCategoryInfo(@RequestParam Integer seq){
        return cgService.selectCommunityCategoryInfoBySeq(seq);
    }
    @GetMapping("/statistics")
    public StatisticsTableVO getStatisticsCategoryInfo(@RequestParam Integer seq){
        return cgService.selectStatisticsCategoryInfoBySeq(seq);
    }

    @DeleteMapping("/news")
    public String deleteNewsCategory(@RequestParam Integer seq){
        cgService.deleteNewsCategoryInfo(seq);
        return "카테고리가 삭제되었습니다.";
    }
    @DeleteMapping("/commumity")
    public String deleteCommunityCategory(@RequestParam Integer seq){
        cgService.deleteCommunityCategoryInfo(seq);
        return "카테고리가 삭제되었습니다.";
    }
    @DeleteMapping("/statistics")
    public String deleteStatisticsCategory(@RequestParam Integer seq){
        cgService.deleteStatisticsCategoryInfo(seq);
        return "카테고리가 삭제되었습니다.";
    }

    @PatchMapping("/news")
    public String updateNewsCategory(@RequestBody NewsTableVO data){
        cgService.updateNewsCategoryInfo(data);
        return "카테고리가 수정되었습니다.";
    }
    @PatchMapping("/commumity")
    public String updateCommunityCategory(@RequestBody CommunityTableVO data){
        cgService.updateCommunityCategoryInfo(data);
        return "카테고리가 수정되었습니다.";
    }
    @PatchMapping("/statistics")
    public String updateStatisticsCategory(@RequestBody StatisticsTableVO data){
        cgService.updateStatisticsCategoryInfo(data);
        return "카테고리가 수정되었습니다.";
    }


}
