package com.winters.be.db.mybatis.dao;

import com.winters.be.db.mybatis.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface MemberDAO {
    List<MemberVO> getMemberList();


    @Select("SELECT * FROM member")
    List<MemberVO> findAll();
    @Select("SELECT userid as userId FROM member WHERE userid = #{userid} and password =#{password}")
    MemberVO findByUserIdAndPassword(@Param("userid") String userid, @Param("password") String password);

//    @Insert("INSERT INTO user(name, part) VALUES(#{name}, #{part}")
//    @Options(useGeneratedKeys = true, keyProperty = "userIdx")
//    int save(@Param("user") final User user);
}
