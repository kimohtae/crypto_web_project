package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class ContactInfoVO {
    private Integer ci_seq;
    private Integer ci_mi_seq;
    private Integer ci_status;
    private String ci_title;
    private String ci_contents;
    private Date ci_reg_dt;
    private Date ci_mod_dt;

    private String mi_id;
}
