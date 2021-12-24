package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class InvestmentTypeHistory {
    private Integer iti_seq;
    private String iti_type;
    private String iti_content;
    private Integer iti_reg_dt;
    private Date iti_tl_seq;
}
