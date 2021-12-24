package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class TableHistoryVO {
    private Integer tih_seq;
    private String tih_type;
    private String tih_content;
    private Integer tih_reg_dt;
    private Date tih_tl_seq;
}
