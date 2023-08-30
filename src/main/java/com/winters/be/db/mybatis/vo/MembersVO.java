package com.winters.be.db.mybatis.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembersVO {
    private String mb_id;
    private String mb_name;
    private String mb_pwd;
    private String mb_birthdate;
    private String join_date;
    private String admin_yn;
    private String mb_sex;
    private String mb_email;
    private String mb_nick;
    private String mb_yy;
    private String mb_mm;
    private String mb_dd;
}
