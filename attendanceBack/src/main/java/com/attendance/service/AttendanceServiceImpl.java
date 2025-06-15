package com.attendance.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.attendance.entity.Lecture;
import com.attendance.entity.StuLecBumper;
import com.attendance.entity.Student;
import com.attendance.repository.DepartmentRepository;
import com.attendance.repository.LectureRepository;
import com.attendance.repository.ProfessorRepository;
import com.attendance.repository.StuLecBumperRepository;
import com.attendance.repository.StudentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

	private final DepartmentRepository departmentRepository;

	private final LectureRepository lectureRepository;

	private final StudentRepository studentRepository;

	private final ProfessorRepository professorRepository;

	private final StuLecBumperRepository stuLecBumperRepository;

	@Value("${attendanceBack\\QrPath}")
	private String uploadPath;

	@Override
	public List<Student> getStuListByLec(Long lno) {
		return stuLecBumperRepository.getStuListByLno(lno);
	}

	@Override
	@Transactional
	public void checkAttandance(Long sno, long lno) {
		StuLecBumper slb = stuLecBumperRepository.getStuInfoInLec(sno, lno)
				.orElseThrow(() -> new IllegalArgumentException("해당 학생은 이 강의를 수강하지 않습니다."));

		// 이미 출석한 경우 예외
		if (slb.isAttend()) {
			throw new IllegalStateException("이미 출석 처리된 강의입니다.");
		}

		// attended, attendTime이 반영된 새로운 객체 생성
		StuLecBumper updated = StuLecBumper.builder()
				.slbno(slb.getSlbno())
				.student(slb.getStudent())
				.lecture(slb.getLecture())
				.isAttend(true)
				.attendTime(LocalDateTime.now())
				.build();

		// save (JPA가 merge)
		stuLecBumperRepository.save(updated);
	}

}
