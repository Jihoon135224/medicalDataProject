package com.attendance.dto;


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
public class ProfessorDTO {
	
	private Long pno;
	
	private String proName;
	
	private Long dno;
}
