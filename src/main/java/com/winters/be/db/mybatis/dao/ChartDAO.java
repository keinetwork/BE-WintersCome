package com.winters.be.db.mybatis.dao;

import com.winters.be.db.mybatis.vo.GraphVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChartDAO {
    @Select(value = "SELECT * FROM POSTURE " +
            "WHERE mb_id= #{vo.mb_id} and pos_type= #{vo.pos_type} " +
            "and pos_time between DATE_SUB(NOW(), INTERVAL 1000 DAY) and NOW() " +
            "order by pos_time")
    List<GraphVO> countTurtle(@Param("vo") GraphVO vo);
}
