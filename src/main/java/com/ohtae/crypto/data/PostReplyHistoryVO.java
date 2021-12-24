package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class PostReplyHistoryVO {
    private Integer prih_seq;
    private String prih_content;
    private String prih_type;
    private Date prih_reg_dt;
    private Integer prih_pi_seq;
}
