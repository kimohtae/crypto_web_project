package com.ohtae.crypto.mapper;

import java.util.List;

import com.ohtae.crypto.data.StatisticsInfoVO;
import com.ohtae.crypto.data.StatisticsTableVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticsInfoMapper {
    List<StatisticsInfoVO> selectStatisticsList(String type, String keyword, Integer offset);
    Integer selectStatisticsCnt(String type, String keyword);
    StatisticsInfoVO selectStatisticsInfoBySeq(Integer seq);
    List<StatisticsTableVO> selectStatisticsTableList();

    void insertStatisticsInfo(StatisticsInfoVO data);

    void deleteStatisticsInfo(Integer seq);
    
    void updateStatisticsStatus(StatisticsInfoVO data);
}
