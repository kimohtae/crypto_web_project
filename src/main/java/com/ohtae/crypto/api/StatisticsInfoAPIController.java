package com.ohtae.crypto.api;

import com.ohtae.crypto.service.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/statistics")
public class StatisticsInfoAPIController {
    @Autowired StatisticsService stService;

    @PatchMapping("/status")
    public String patchStatisticStatus(@RequestParam Integer seq){
        return stService.updateStatisticsStatus(seq);
    }
    @DeleteMapping("/delete")
    public String deleteStatisticInfo(@RequestParam Integer seq){
        return stService.deleteStatisticsInfo(seq);
    }
}