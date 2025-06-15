package com.attendance.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "lecture")
public class Lecture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lno; // 강의번호

	private String lName; // 강의명

	private LocalTime startTime;

	private LocalTime endTime;

	@ManyToOne(fetch = FetchType.LAZY)
	private Professor professor;

	@OneToMany(fetch = FetchType.LAZY)
	private List<StuLecBumper> stuLecBumpers = new ArrayList<>();
}
