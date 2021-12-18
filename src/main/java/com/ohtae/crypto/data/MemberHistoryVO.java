package com.ohtae.crypto.data;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberHistoryVO {
    private Integer mh_seq;
    private String mh_content;
    private String mh_type;
    private Date mh_reg_dt;
    private Integer mh_mi_seq;
}
