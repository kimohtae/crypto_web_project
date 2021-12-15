package com.ohtae.crypto.mapper;

import java.util.List;

import com.ohtae.crypto.data.MemberInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberInfoMapper {
    public List<MemberInfoVO> selectMemberList(Integer offset);
    public Integer selectMemberCounts();

    public void insertMemberInfo(MemberInfoVO data);

    public void deleteMemberInfo(Integer seq);

}
