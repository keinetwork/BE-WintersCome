package com.winters.be.db.repository;

import com.winters.be.db.entity.MemberEntity;

import java.util.List;

public interface MemberRepositoryQuery {
    List<MemberEntity> selectAll();
}
