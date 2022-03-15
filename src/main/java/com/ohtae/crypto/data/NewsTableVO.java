package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class NewsTableVO {
    private Integer nti_seq;
    private Integer nti_order;
    private String nti_name;
    private Date nti_reg_dt;
    private Date nti_mod_dt;
}
