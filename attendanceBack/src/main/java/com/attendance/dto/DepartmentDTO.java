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
public class DepartmentDTO {

	private Long dno;

	private String departName;

	private List<StudentDTO> students;

	private List<ProfessorDTO> professors;
}
