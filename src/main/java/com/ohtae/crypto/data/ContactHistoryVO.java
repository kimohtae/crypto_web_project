package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class ContactHistoryVO {
    private Integer cih_seq;
    private Integer cih_ci_seq;
    private String cih_type;
    private String cih_content;
    private Date cih_reg_dt;
}
