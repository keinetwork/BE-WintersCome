package com.winters.be.db.mybatis.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphVO {
    private Integer pos_seq;
    private String pos_type;
    private String pos_time;
    private Integer pos_count;
    private String mb_id;
}
