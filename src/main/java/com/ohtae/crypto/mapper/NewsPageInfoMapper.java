package com.ohtae.crypto.mapper;

import java.util.List;

import com.ohtae.crypto.data.NewsPageInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsPageInfoMapper {
    public List<NewsPageInfoVO> selectNewsList(Integer offset, String order, String keyworkd);
    public Integer selectNewsCounts();

    public void insertNewsInfo(NewsPageInfoVO data);

    public void deleteNewsInfo(Integer seq);
}
