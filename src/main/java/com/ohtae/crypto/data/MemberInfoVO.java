package com.ohtae.crypto.data;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberInfoVO {
    private Integer mi_seq;
    private String mi_id;
    private String mi_pwd;
    private String mi_email;
    private String mi_phone;
    private String mi_name;
    private String mi_image;
    private String mi_birth;
    private Date mi_reg_dt;
    private Integer mi_status;
    
}
