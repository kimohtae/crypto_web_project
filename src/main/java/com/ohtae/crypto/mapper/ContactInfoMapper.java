package com.ohtae.crypto.mapper;

import java.util.List;

import com.ohtae.crypto.data.ContactHistoryVO;
import com.ohtae.crypto.data.ContactInfoVO;
import com.ohtae.crypto.data.PostReplyInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactInfoMapper {
    public List<ContactInfoVO> selectContactList(Integer offset);
    public Integer selectContactCounts();
    public ContactInfoVO selectContactInfo(Integer seq);
    public List<PostReplyInfoVO> selectContactReplyInfo(Integer seq);
    
    public void insertContactHis(ContactHistoryVO data);

    public void updateContactStatus(Integer seq,Integer status);

    public void deleteContactInfo(Integer seq);
    public void deleteContactReplyInfo(Integer seq);
}
