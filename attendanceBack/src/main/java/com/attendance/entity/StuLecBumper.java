package com.attendance.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stuLecBumper")
public class StuLecBumper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slbno; // 범퍼테이블 번호

	private boolean isAttend;

	private LocalDateTime attendTime;

	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	private Lecture lecture;

}
