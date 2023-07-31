package com.winters.be.db.repository;

import com.winters.be.db.entity.AccessCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessCountRepository extends JpaRepository<AccessCountEntity, Long> {
	Optional<AccessCountEntity> findByIpAddr(String ipAddr);
}
