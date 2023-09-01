package com.winters.be.db.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.winters.be.db.jpa.entity.MemberEntity;
import com.winters.be.db.jpa.entity.QMemberEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryQuery {
    private final JPAQueryFactory queryFactory;


    @Override
    public List<MemberEntity> selectAll() {
        return queryFactory.selectFrom(QMemberEntity.memberEntity)
                .fetch();
    }
}
