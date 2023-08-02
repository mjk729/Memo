package com.memo.pk.user.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name="user")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="loginId")
	private String loginId;
	private String password;
	private String name;
	private String email;
	@Column(name="createdAt", updatable=false)
	@UpdateTimestamp
	private ZonedDateTime createdAt;
	@Column(name="updatedAt")
	@UpdateTimestamp
	private ZonedDateTime updatedAt;
	
}
