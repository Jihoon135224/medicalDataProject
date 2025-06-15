package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long>{

}
