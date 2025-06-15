package com.attendance.dto;

import java.time.LocalTime;
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
public class LectureDTO {

	private Long lno;

	private String lName;

	private LocalTime startTime;

	private LocalTime endTime;

	private Long pno;

	private List<StuLecBumperDTO> stuLecBumpers;
}
