package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class StatisticsInfoVO {
    private Integer si_seq;
    private Integer si_mi_seq;
    private Integer si_sti_seq;
    private String si_title;
    private String si_contents;
    private Integer si_view;
    private Integer si_like;
    private Integer si_status;
    private Date si_reg_dt;
    private Date si_mod_dt;
    private String si_img_url;

    private String sti_name;
    private String mi_name;
}
