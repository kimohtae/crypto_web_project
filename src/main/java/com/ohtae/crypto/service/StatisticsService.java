package com.ohtae.crypto.service;

import java.util.List;

import com.ohtae.crypto.data.StatisticsInfoVO;
import com.ohtae.crypto.mapper.StatisticsInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {
    @Autowired StatisticsInfoMapper stMapper;

    public List<StatisticsInfoVO> selectStatisticsList(){
        return stMapper.selectStatisticsList();
    }

    public String deleteStatisticsInfo(Integer seq){
        stMapper.deleteStatisticsInfo(seq);
        return "삭제되었습니다.";
    }
    
    public String updateStatisticsStatus(Integer seq){
        StatisticsInfoVO stData = new StatisticsInfoVO();
        stData.setSi_seq(seq);
        stMapper.updateStatisticsStatus(stData);
        return "상태가 변경되었습니다.";
    }
}
