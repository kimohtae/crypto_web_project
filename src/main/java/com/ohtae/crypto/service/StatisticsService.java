package com.ohtae.crypto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohtae.crypto.data.StatisticsInfoVO;
import com.ohtae.crypto.data.StatisticsTableVO;
import com.ohtae.crypto.mapper.StatisticsInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {
    @Autowired StatisticsInfoMapper stMapper;

    public Map<String, Object> selectStatisticsList(String type, String keyword, Integer offset){
        Map<String, Object> resultMap = new LinkedHashMap<>();
        if(type == null)type = "all";
        if(offset == null)offset = 0;
        if(keyword == null){
            keyword = "%%";
        }else{
            keyword = "%"+keyword+"%";
        }
        Integer cnt = stMapper.selectStatisticsCnt(type, keyword);
        Integer page = cnt/20 + (cnt%20>0 ? 1:0);
        resultMap.put("page", page);
        resultMap.put("data", stMapper.selectStatisticsList(type, keyword, offset));
        
        return resultMap;
    }
    public StatisticsInfoVO selectStatisticsInfoBySeq(Integer seq){
        return stMapper.selectStatisticsInfoBySeq(seq);
    }
    public List<StatisticsTableVO> selectStatisticsTableList(){
        return stMapper.selectStatisticsTableList();
    }

    public String insertStatisticsInfo(StatisticsInfoVO data){
        stMapper.insertStatisticsInfo(data);
        return "정보가 추가되었습니다.";
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
