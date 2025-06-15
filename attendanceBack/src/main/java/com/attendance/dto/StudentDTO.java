package com.attendance.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

	private Long sno;

	private String stuName;

	private Long stuGrade;

	private boolean isLeave;

	private Long dno;

	private List<StuLecBumperDTO> stuLecBumpers;
}
