package com.ohtae.crypto.mapper;

import java.util.List;

import com.ohtae.crypto.data.NewsTableVO;
import com.ohtae.crypto.data.CommunityTableVO;
import com.ohtae.crypto.data.StatisticsTableVO;
import com.ohtae.crypto.data.TableVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    List<NewsTableVO> selectNewsCategoryList(Integer offset);
    List<CommunityTableVO> selectCommunityCategoryList(Integer offset);
    List<StatisticsTableVO> selectStatisticsCategoryList(Integer offset);

    NewsTableVO selectNewsCategoryInfoBySeq(Integer seq);
    CommunityTableVO selectCommunityCategoryInfoBySeq(Integer seq);
    StatisticsTableVO selectStatisticsCategoryInfoBySeq(Integer seq);

    Integer selectNewsCategoryCnt();
    Integer selectCommunityCategoryCnt();
    Integer selectStatisticsCategoryCnt();
    
    List<TableVO> selectTableList();

    void insertNewsCategoryInfo(NewsTableVO data);
    void insertCommunityCategoryInfo(CommunityTableVO data);
    void insertStatisticsCategoryInfo(StatisticsTableVO data);

    void deleteNewsCategoryInfo(Integer seq);
    void deleteCommunityCategoryInfo(Integer seq);
    void deleteStatisticsCategoryInfo(Integer seq);

    void updateNewsCategoryInfo(NewsTableVO data);
    void updateCommunityCategoryInfo(CommunityTableVO data);
    void updateStatisticsCategoryInfo(StatisticsTableVO data);
}
