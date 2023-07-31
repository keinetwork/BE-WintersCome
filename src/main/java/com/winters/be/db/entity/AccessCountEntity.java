package com.winters.be.db.entity;

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
	
	private String ipAddr;
	private int totalCount;
	private int yearCount;
	private int monthCount;
	private int dayCount;
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	private void setInfo(String ip, int total, int year, int month, int day) {
		this.ipAddr = ip;
		this.totalCount = total;
		this.yearCount = year;
		this.monthCount= month;
		this.dayCount = day;
	}
	
	@Builder
	private AccessCountEntity(Long id, String ip, int total, int year, int month, int day) {
		this.id = id;
		setInfo(ip, total, year, month, day);
	}
	@Builder
	private AccessCountEntity(String ip, int total, int year, int month, int day) {
		setInfo(ip, total, year, month, day);
	}
	
}
