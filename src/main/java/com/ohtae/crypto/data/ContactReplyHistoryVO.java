package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class ContactReplyHistoryVO {
    private Integer crih_seq;
    private Integer crih_cri_seq;
    private String crih_type;
    private String crih_content;
    private Date crih_reg_dt;

    
}
