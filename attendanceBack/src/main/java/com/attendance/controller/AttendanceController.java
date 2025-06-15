package com.attendance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.dto.AttendanceRequestDTO;
import com.attendance.service.AttendanceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/attend")
@RequiredArgsConstructor
@Log4j2
public class AttendanceController {

  private final AttendanceService attendanceService;

  @PostMapping("/check")
  public ResponseEntity<String> checkAttendance(@RequestBody AttendanceRequestDTO requestDTO) {
    try {
      attendanceService.checkAttandance(requestDTO.getSno(), requestDTO.getLno());
      return ResponseEntity.ok("출석 완");
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
