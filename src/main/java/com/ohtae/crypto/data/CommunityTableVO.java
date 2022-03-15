package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class CommunityTableVO {
    private Integer cti_seq;
    private Integer cti_order;
    private String cti_name;
    private Date cti_reg_dt;
    private Date cti_mod_dt;
}
