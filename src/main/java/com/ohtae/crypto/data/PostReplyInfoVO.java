package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class PostReplyInfoVO {
    private Integer pri_seq;
    private Integer pri_pi_seq;
    private String pri_contents;
    private Integer pri_like;
    private Date pri_reg_dt;
    private Integer pri_mi_seq;

    private String pri_format_dt;
    private String pri_format_like;
    private String mi_id;
}
