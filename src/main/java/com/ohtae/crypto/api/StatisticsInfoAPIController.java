package com.ohtae.crypto.api;


import com.ohtae.crypto.data.StatisticsInfoVO;
import com.ohtae.crypto.service.StatisticsService;

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
@RequestMapping("/admin/statistics")
public class StatisticsInfoAPIController {
    @Autowired StatisticsService stService;

    @GetMapping("/select")
    public StatisticsInfoVO getStatisticsInfoBySeq(@RequestParam Integer seq){
        return stService.selectStatisticsInfoBySeq(seq);
    }  

    @PutMapping("/add")
    public String putAddStatisticsInfo(@RequestBody StatisticsInfoVO data){
        return stService.insertStatisticsInfo(data);
    }  
    @PatchMapping("/modify")
    public String patchStatisticsInfo(@RequestBody StatisticsInfoVO data){
        return stService.updateStatisticsInfo(data);
    }  

    @PatchMapping("/status")
    public String patchStatisticStatus(@RequestParam Integer seq){
        return stService.updateStatisticsStatus(seq);
    }
    @DeleteMapping("/delete")
    public String deleteStatisticInfo(@RequestParam Integer seq){
        return stService.deleteStatisticsInfo(seq);
    }
}
