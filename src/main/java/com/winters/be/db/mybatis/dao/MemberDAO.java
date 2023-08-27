package com.winters.be.db.mybatis.dao;

import com.winters.be.db.mybatis.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MemberDAO {
    public List<MemberVO> getMemberList();
}
