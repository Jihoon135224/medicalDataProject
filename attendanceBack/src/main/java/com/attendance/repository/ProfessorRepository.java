package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
