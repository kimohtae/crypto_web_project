package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class TableVO {
    private Integer ti_seq;
    private String ti_table;
    private Date ti_reg_dt;
    private Date ti_mod_dt;
}
