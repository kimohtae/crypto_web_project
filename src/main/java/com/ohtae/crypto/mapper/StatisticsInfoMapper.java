package com.ohtae.crypto.mapper;

import java.util.List;

import com.ohtae.crypto.data.StatisticsInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticsInfoMapper {
    List<StatisticsInfoVO> selectStatisticsList();

    void deleteStatisticsInfo(Integer seq);
    
    void updateStatisticsStatus(StatisticsInfoVO data);
}
