package com.winters.be.db.jpa.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class AccessCountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20, nullable = false, unique = true)
	private String ipAddr;
	private Integer totalCount;
	private Integer yearCount;
	private Integer monthCount;
	private Integer dayCount;
	@CreatedDate
	@Column(nullable = false, updatable=false)
	private LocalDateTime createdAt;
	@LastModifiedDate()
	@Column(nullable = false)
	private LocalDateTime updatedAt;
	
	private void setInfo(String ip, Integer total, Integer year, Integer month, Integer day) {
		this.ipAddr = ip;
		this.totalCount = total;
		this.yearCount = year;
		this.monthCount= month;
		this.dayCount = day;
	}
	
	@Builder
	private AccessCountEntity(Long id, String ip, Integer total, Integer year, Integer month, Integer day) {
		this.id = id;
		setInfo(ip, total, year, month, day);
	}
	@Builder
	private AccessCountEntity(String ip, Integer total, Integer year, Integer month, Integer day) {
		setInfo(ip, total, year, month, day);
	}
	
}
