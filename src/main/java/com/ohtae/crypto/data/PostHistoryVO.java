package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class PostHistoryVO {
    private Integer pih_seq;
    private String pih_content;
    private String pih_type;
    private Date pih_reg_dt;
    private Integer pih_pi_seq;
}
