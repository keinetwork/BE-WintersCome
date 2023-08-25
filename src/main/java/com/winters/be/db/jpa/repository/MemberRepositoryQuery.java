package com.winters.be.db.jpa.repository;

import com.winters.be.db.jpa.entity.MemberEntity;

import java.util.List;

public interface MemberRepositoryQuery {
    List<MemberEntity> selectAll();
}
