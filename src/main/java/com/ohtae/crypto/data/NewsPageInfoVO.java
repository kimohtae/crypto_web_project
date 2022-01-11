package com.ohtae.crypto.data;

import java.util.Date;

import lombok.Data;

@Data
public class NewsPageInfoVO {
    private Integer npi_seq;
    private String npi_author;
    private String npi_company;
    private String npi_title;
    private String npi_content;
    private String npi_link;
    private Integer npi_view;
    private Date npi_reg_dt;

}
