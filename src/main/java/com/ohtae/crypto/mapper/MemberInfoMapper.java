package com.ohtae.crypto.mapper;

import java.util.List;

import com.ohtae.crypto.data.MemberHistoryVO;
import com.ohtae.crypto.data.MemberInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberInfoMapper {
    public List<MemberInfoVO> selectMemberList(Integer offset, String order);
    public MemberInfoVO selectMemberInfo(Integer seq);
    public Integer selectMemberCounts();
    public Integer selectRecentSeq();
    public MemberInfoVO selectLoginInfo(String id);
    

    public void insertMemberInfo(MemberInfoVO data);
    public void insertMemberHis(MemberHistoryVO data);


    public void updateMemberInfo(MemberInfoVO data);
    public void updateMemberStatus(Integer seq, Integer status);


    public void deleteMemberInfo(Integer seq);

}
