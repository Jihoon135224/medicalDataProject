package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
