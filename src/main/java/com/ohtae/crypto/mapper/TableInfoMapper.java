package com.ohtae.crypto.mapper;

import java.util.List;

import com.ohtae.crypto.data.TableHistoryVO;
import com.ohtae.crypto.data.TableInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TableInfoMapper {
    public List<TableInfoVO> selectTableList(String keyword);
    public TableInfoVO selectTableInfo(Integer seq);
    public Integer selectRecentSeq();
    

    public void insertTableInfo(String cat, String type);
    public void insertTableHis(TableHistoryVO data);


    public void updateTableCat(String cat, String type);
    public void updateTableType(String cat, String type);


    public void deleteTableInfo(Integer seq);
}
