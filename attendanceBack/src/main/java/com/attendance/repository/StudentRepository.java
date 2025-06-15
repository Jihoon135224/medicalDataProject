package com.attendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.attendance.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query("select st from Student where st.department.dno = :dno")
  List<Student> getStuListByDno(@Param("dno") Long dno); // 학과에 따른 학생 리스트

  @Query("select st from Student where st.stuName = :stuName")
  Student findStudentByName(@Param("stuName") String StuName); // 학생 이름으로 학생 찾기

}
