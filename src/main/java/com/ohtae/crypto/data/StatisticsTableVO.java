package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;
@Data
public class StatisticsTableVO {
    private Integer sti_seq;
    private Integer sti_order;
    private String sti_name;
    private Date sti_reg_dt;
    private Date sti_mod_dt;
}
