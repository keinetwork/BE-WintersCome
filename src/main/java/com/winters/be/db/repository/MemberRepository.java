package com.winters.be.db.repository;

import com.winters.be.db.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>, MemberRepositoryQuery {
    Optional<MemberEntity> findByEmail(String email);
}
