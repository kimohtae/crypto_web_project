package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class ContactReplyInfoVO {
    private Integer cri_seq;
    private Integer cri_ci_seq;
    private Integer cri_mi_seq;
    private String cri_contents;
    private Date cri_reg_dt;

    private String cri_format_dt;
    private String mi_id;
}
