package com.attendance.service;

import java.util.ArrayList;
import java.util.List;

import com.attendance.dto.DepartmentDTO;
import com.attendance.dto.LectureDTO;
import com.attendance.dto.ProfessorDTO;
import com.attendance.dto.StuLecBumperDTO;
import com.attendance.dto.StudentDTO;
import com.attendance.entity.Department;
import com.attendance.entity.Lecture;
import com.attendance.entity.Professor;
import com.attendance.entity.StuLecBumper;
import com.attendance.entity.Student;

public interface AttendanceService {

  List<Student> getStuListByLec(Long lno); // 강의를 수강하는 학생의 리스트

  void checkAttandance(Long sno, long lno); // 학생의 강의 출석 체크

  default DepartmentDTO departEntityToDTO(Department department) {

    List<Student> stuList = department.getStudents();

    List<Professor> proList = department.getProfessors();

    List<StudentDTO> stuDTOList = new ArrayList<>();

    List<ProfessorDTO> proDTOList = new ArrayList<>();

    for (Student stu : stuList) {
      StudentDTO stuDTO = stuEntityToDTO(stu);
      stuDTOList.add(stuDTO);
    }

    for (Professor pro : proList) {
      ProfessorDTO professorDTO = proEntityToDTO(pro);
      proDTOList.add(professorDTO);
    }

    DepartmentDTO departmentDTO = DepartmentDTO.builder()
        .dno(department.getDno())
        .departName(department.getDepartName())
        .students(stuDTOList)
        .professors(proDTOList)
        .build();

    return departmentDTO;
  }

  default Department departDTOToEntity(DepartmentDTO departmentDTO) {

    List<Student> stuList = new ArrayList<>();

    List<Professor> proList = new ArrayList<>();

    List<StudentDTO> stuDTOList = departmentDTO.getStudents();

    List<ProfessorDTO> proDTOList = departmentDTO.getProfessors();

    for (StudentDTO stuDTO : stuDTOList) {
      Student stu = stuDTOToEntity(stuDTO);
      stuList.add(stu);
    }

    for (ProfessorDTO proDTO : proDTOList) {
      Professor pro = proDTOToEntity(proDTO);
      proList.add(pro);
    }

    Department department = Department.builder()
        .dno(departmentDTO.getDno())
        .departName(departmentDTO.getDepartName())
        .students(stuList)
        .professors(proList)
        .build();

    return department;
  }

  default StudentDTO stuEntityToDTO(Student student) {

    List<StuLecBumper> bumperList = student.getStuLecBumpers();

    List<StuLecBumperDTO> bumperDTOList = new ArrayList<>();

    for (StuLecBumper bumper : bumperList) {
      StuLecBumperDTO bumperDTO = stBumperEntitiyToDTO(bumper);
      bumperDTOList.add(bumperDTO);
    }

    StudentDTO studentDTO = StudentDTO.builder()
        .sno(student.getSno())
        .dno(student.getDepartment().getDno())
        .stuName(student.getStuName())
        .stuGrade(student.getStuGrade())
        .isLeave(student.isLeave())
        .stuLecBumpers(bumperDTOList)
        .build();

    return studentDTO;
  }

  default Student stuDTOToEntity(StudentDTO stuDTO) {

    List<StuLecBumperDTO> bumperDTOList = stuDTO.getStuLecBumpers();

    List<StuLecBumper> bumperList = new ArrayList<>();

    Department department = Department.builder().dno(stuDTO.getDno()).build();

    for (StuLecBumperDTO bumperDTO : bumperDTOList) {
      StuLecBumper stuLecBumper = stBumperDTOToEntity(bumperDTO);
      bumperList.add(stuLecBumper);
    }

    Student st = Student.builder()
        .sno(stuDTO.getSno())
        .stuName(stuDTO.getStuName())
        .stuGrade(stuDTO.getStuGrade())
        .isLeave(stuDTO.isLeave())
        .department(department)
        .stuLecBumpers(bumperList)
        .build();

    return st;
  }

  default ProfessorDTO proEntityToDTO(Professor professor) {

    ProfessorDTO proDTO = ProfessorDTO.builder()
        .pno(professor.getPno())
        .proName(professor.getProName())
        .dno(professor.getDepartment().getDno())
        .build();

    return proDTO;
  }

  default Professor proDTOToEntity(ProfessorDTO professorDTO) {

    Department department = Department.builder().dno(professorDTO.getPno()).build();

    Professor professor = Professor.builder()
        .pno(professorDTO.getPno())
        .proName(professorDTO.getProName())
        .department(department)
        .build();
    return professor;
  }

  default LectureDTO lecEntityToDTO(Lecture lec) {

    List<StuLecBumper> bumperList = lec.getStuLecBumpers();

    List<StuLecBumperDTO> bumperDTOList = new ArrayList<>();

    for (StuLecBumper bumper : bumperList) {
      StuLecBumperDTO bumperDTO = stBumperEntitiyToDTO(bumper);
      bumperDTOList.add(bumperDTO);
    }

    LectureDTO lectureDTO = LectureDTO.builder()
        .lno(lec.getLno())
        .lName(lec.getLName())
        .startTime(lec.getStartTime())
        .endTime(lec.getEndTime())
        .pno(lec.getProfessor().getPno())
        .stuLecBumpers(bumperDTOList)
        .build();

    return lectureDTO;
  }

  default Lecture lecDTOToEntity(LectureDTO lecDTO) {

    List<StuLecBumperDTO> bumperDTOList = lecDTO.getStuLecBumpers();

    List<StuLecBumper> bumperList = new ArrayList<>();

    Professor professor = Professor.builder().pno(lecDTO.getPno()).build();

    for (StuLecBumperDTO bumperDTO : bumperDTOList) {
      StuLecBumper stuLecBumper = stBumperDTOToEntity(bumperDTO);
      bumperList.add(stuLecBumper);
    }

    Lecture lec = Lecture.builder()
        .lno(lecDTO.getLno())
        .lName(lecDTO.getLName())
        .startTime(lecDTO.getStartTime())
        .endTime(lecDTO.getEndTime())
        .professor(professor)
        .stuLecBumpers(bumperList)
        .build();

    return lec;
  }

  default StuLecBumperDTO stBumperEntitiyToDTO(StuLecBumper slb) {

    StuLecBumperDTO slbDTO = StuLecBumperDTO.builder()
        .slbno(slb.getSlbno())
        .sno(slb.getStudent().getSno())
        .lno(slb.getLecture().getLno())
        .build();

    return slbDTO;
  }

  default StuLecBumper stBumperDTOToEntity(StuLecBumperDTO slbDTO) {

    Student stu = Student.builder().sno(slbDTO.getSno()).build();

    Lecture lec = Lecture.builder().lno(slbDTO.getLno()).build();

    StuLecBumper slb = StuLecBumper.builder()
        .slbno(slbDTO.getSlbno())
        .student(stu)
        .lecture(lec)
        .build();
    return slb;
  }
}
