package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class PostInfoVO {
    private Integer pi_seq;
    private Integer pi_mi_seq;
    private String pi_title;
    private String pi_contents;
    private Integer pi_ti_seq;
    private Integer pi_iti_seq;
    private Integer pi_views;
    private Integer pi_like;
    private Integer pi_status;
    private Date pi_reg_dt;
    private Date pi_mod_dt;

    
    
    private String mi_id;
    private String ti_table;
    private String iti_type;
}
