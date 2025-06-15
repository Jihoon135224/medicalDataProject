package com.attendance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.attendance.entity.Lecture;
import com.attendance.entity.StuLecBumper;
import com.attendance.entity.Student;

public interface StuLecBumperRepository extends JpaRepository<StuLecBumper, Long> {

  @Query("Select st from Student st left join StuLecBumper slb on st.sno = slb.student.sno where clb.lecture.lno = :lno")
  List<Student> getStuListByLno(@Param("lno") Long lno); // 강의 번호 기준으로 학생 리스트

  @Query("Select le from Lecture le left join StuLecBumper slb on st.sno = slb.lecture.lno where clb.student.sno = :sno")
  List<Lecture> getLecListBySno(@Param("sno") Long sno);

  @Query("Select slb from StuLecBumper slb where slb.studnent.sno = :sno and slb.lecture.lno = :lno")
  Optional<StuLecBumper> getStuInfoInLec(@Param("sno") long sno, @Param("lno") long lno);
}
