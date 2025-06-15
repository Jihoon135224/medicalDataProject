package com.attendance.entity;

import java.util.ArrayList;
import java.util.List;

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
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dno; // 학과 번호
	
	@Column(nullable = false)
	private String departName; // 학과 이름
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sno")
	private List<Student> students = new ArrayList<>(); // 학과 학생 리스트
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pno")
	private List<Professor> professors =  new ArrayList<>(); // 학과 교수 리스트
}
