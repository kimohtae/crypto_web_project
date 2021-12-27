package com.ohtae.crypto.mapper;

import java.util.List;


import com.ohtae.crypto.data.PostInfoVO;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostInfoMapper {
    public List<PostInfoVO> selectPostList(Integer offset, String keyword, String type);
    public Integer selectPostCounts(String keyword, String type);
    public PostInfoVO selectPostInfo(Integer seq);
    // public Integer selectRecentSeq();
    
    // public void insertPostHis(PostHistoryVO data);
    // public void insertPostReplyHis(PostReplyHistoryVO data);

    // public void updatePostStatus(Integer seq, Integer status);


    // public void deletePostInfo(Integer seq);
    // public void deletePostReplyInfo(Integer seq);

}
