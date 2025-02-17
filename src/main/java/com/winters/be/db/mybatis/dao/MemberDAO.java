package com.winters.be.db.mybatis.dao;

import com.winters.be.db.mybatis.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberDAO {
    List<MemberVO> getMemberList();


    @Select("SELECT * FROM member")
    List<MemberVO> findAll();
    @Select("SELECT * FROM member WHERE username=#{username} and password=#{password}")
    Optional<MemberVO> getLoginMember(@Param("username") String username, @Param("password") String password);

//    @Insert("INSERT INTO user(name, part) VALUES(#{name}, #{part}")
//    @Options(useGeneratedKeys = true, keyProperty = "userIdx")
//    int save(@Param("user") final User user);
}
