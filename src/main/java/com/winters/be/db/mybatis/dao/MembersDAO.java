package com.winters.be.db.mybatis.dao;

import com.winters.be.db.mybatis.vo.MemberVO;
import com.winters.be.db.mybatis.vo.MembersVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MembersDAO {
    List<MemberVO> getMemberList();


    @Select(value = "SELECT * FROM member")
    List<MemberVO> findAll();
    @Select(value = "SELECT * FROM member WHERE username=#{username} and password=#{password}")
    Optional<MemberVO> getLoginMember(@Param("username") String username, @Param("password") String password);

//    @Insert("INSERT INTO user(name, part) VALUES(#{name}, #{part}")
//    @Options(useGeneratedKeys = true, keyProperty = "userIdx")
//    int save(@Param("user") final User user);
    @Insert(value = "INSERT INTO Members(mb_id, mb_nick, mb_pwd, mb_name, mb_birthdate, mb_sex, mb_email, admin_yn)"+
            "VALUES(#{vo.mb_id}, #{vo.mb_nick}, #{vo.mb_pwd}, #{vo.mb_name}, #{vo.mb_birthdate}," +
            " #{vo.mb_sex}, #{vo.mb_email}, #{vo.admin_yn})")
    int insertMembers(@Param("vo") MembersVO vo);

    @Select(value = "SELECT * FROM Members WHERE mb_id = #{mb_id}")
    MembersVO signIn(String mb_id);



    //    @Insert("INSERT INTO user (user_username, user_name) values(#{user.username}, #{user.name})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    int insert(@Param("user") User user);

//    @Select("SELECT * FROM user")
//    @Results(id = "userMap", value = {
//            @Result(property = "id", column = "user_id"),
//            @Result(property = "username", column = "user_username"),
//            @Result(property = "name", column = "user_name")
//    })
//    List<User> findAll();
//
//    @Select("SELECT * FROM user WHERE user_id = #{id}")
//    @Results({
//            @Result(property = "id", column = "user_id"),
//            @Result(property = "username", column = "user_username"),
//            @Result(property = "name", column = "user_name"),
//            @Result(property = "posts", column = "user_id", many = @Many(select = "com.example.mybatisPractice.mapper.PostMapper.findByUserId"))
//    })
//    ResponseUserInfo findAllJoinPost(@Param("id") Long id);
//@Select("SELECT * FROM post WHERE user_id = #{id}")
//@ResultMap("postMap")
//Post findByUserId(@Param("id") Long id);
}



