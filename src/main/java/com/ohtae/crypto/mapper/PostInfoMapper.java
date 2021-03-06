package com.ohtae.crypto.mapper;

import java.util.List;

import com.ohtae.crypto.data.PostHistoryVO;
import com.ohtae.crypto.data.PostInfoVO;
import com.ohtae.crypto.data.PostReplyInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostInfoMapper {
    public List<PostInfoVO> selectPostList(Integer offset, String keyword, String type, String order, String dir);
    public Integer selectPostCounts(String keyword, String type);
    public PostInfoVO selectPostInfo(Integer seq);
    public List<PostReplyInfoVO> selectPostReplyInfo(Integer seq);
    
    public void insertPostHis(PostHistoryVO data);

    public void updatePostToPublicStatus(Integer seq);
    public void updatePostToPrivateStatus(Integer seq);

    public void deletePostInfo(Integer seq);
    public void deletePostReplyInfo(Integer seq);

}
