package com.attendance.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sno; // 학생 번호

	@Column(nullable = false)
	private String stuName; // 학생 이름

	@Column(nullable = false)
	private Long stuGrade; // 학생 학년

	private boolean isLeave; // 휴학 상태 표현 True > 휴학, False > 재학

	@ManyToAny(fetch = FetchType.LAZY)
	private Department department; // 학과 이름

	@OneToMany
	private List<StuLecBumper> stuLecBumpers = new ArrayList<>();

	// private String qrPath; // 학생 Qr_Path
}
