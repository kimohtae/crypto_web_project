package com.ohtae.crypto.service;

import java.util.List;

import com.ohtae.crypto.data.CommunityTableVO;
import com.ohtae.crypto.data.NewsTableVO;
import com.ohtae.crypto.data.StatisticsTableVO;
import com.ohtae.crypto.data.TableVO;
import com.ohtae.crypto.mapper.CategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired CategoryMapper cgMapper;

    public List<NewsTableVO> selectNewsCategoryList(Integer offset){
        if(offset==null)offset=0;
        return cgMapper.selectNewsCategoryList(offset);
    }
    public List<CommunityTableVO> selectCommunityCategoryList(Integer offset){
        if(offset==null)offset=0;
        return cgMapper.selectCommunityCategoryList(offset);
    }
    public List<StatisticsTableVO> selectStatisticsCategoryList(Integer offset){
        if(offset==null)offset=0;
        return cgMapper.selectStatisticsCategoryList(offset);
    }

public NewsTableVO selectNewsCategoryInfoBySeq(Integer seq){
    return cgMapper.selectNewsCategoryInfoBySeq(seq);
}
public CommunityTableVO selectCommunityCategoryInfoBySeq(Integer seq){
    return cgMapper.selectCommunityCategoryInfoBySeq(seq);
}
public StatisticsTableVO selectStatisticsCategoryInfoBySeq(Integer seq){
    return cgMapper.selectStatisticsCategoryInfoBySeq(seq);
}

    public Integer selectNewsCategoryCnt(){
        Integer cnt = cgMapper.selectNewsCategoryCnt();
        Integer page = cnt/20 + (cnt%20>0 ? 1:0);
        return page;
    }
    public Integer selectCommunityCategoryCnt(){
        Integer cnt = cgMapper.selectCommunityCategoryCnt();
        Integer page = cnt/20 + (cnt%20>0 ? 1:0);
        return page;
    }
    public Integer selectStatisticsCategoryCnt(){
        Integer cnt = cgMapper.selectStatisticsCategoryCnt();
        Integer page = cnt/20 + (cnt%20>0 ? 1:0);
        return page;
    }

    public List<TableVO> selectTableList(){
        return cgMapper.selectTableList();
    }

    public void insertNewsCategoryInfo(NewsTableVO data){
        cgMapper.insertNewsCategoryInfo(data);
    }
    public void insertCommunityCategoryInfo(CommunityTableVO data){
        cgMapper.insertCommunityCategoryInfo(data);
    }
    public void insertStatisticsCategoryInfo(StatisticsTableVO data){
        cgMapper.insertStatisticsCategoryInfo(data);
    }

    public void deleteNewsCategoryInfo(Integer seq){
        cgMapper.deleteNewsCategoryInfo(seq);
    }
    public void deleteCommunityCategoryInfo(Integer seq){
        cgMapper.deleteCommunityCategoryInfo(seq);
    }
    public void deleteStatisticsCategoryInfo(Integer seq){
        cgMapper.deleteStatisticsCategoryInfo(seq);
    }

    public void updateNewsCategoryInfo(NewsTableVO data){
        cgMapper.updateNewsCategoryInfo(data);
    }
    public void updateCommunityCategoryInfo(CommunityTableVO data){
        cgMapper.updateCommunityCategoryInfo(data);
    }
    public void updateStatisticsCategoryInfo(StatisticsTableVO data){
        cgMapper.updateStatisticsCategoryInfo(data);
    }

}
