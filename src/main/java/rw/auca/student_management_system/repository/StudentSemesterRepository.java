package rw.auca.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.auca.student_management_system.model.StudentSemester;

import java.util.List;
import java.util.Optional;

public interface StudentSemesterRepository extends JpaRepository<StudentSemester, Long> {

    // Get all semester records of a student
    List<StudentSemester> findByStudentId(Long studentId);

    // Check if student is already registered in a specific semester
    boolean existsByStudentIdAndSemesterId(Long studentId, Long semesterId);

    // Get total registered credits in a semester
    @Query("SELECT SUM(c.credits) FROM StudentSemester ss JOIN ss.courses c WHERE ss.id = :studentSemesterId")
    Integer getTotalCreditsByStudentSemesterId(Long studentSemesterId);

    // Get course codes for a student in a given semester
    @Query("SELECT c.code FROM StudentSemester ss JOIN ss.courses c WHERE ss.student.id = :studentId AND ss.semester.id = :semesterId")
    List<String> getCourseCodesForStudentInSemester(Long studentId, Long semesterId);

    // Fetch specific student semester by student and semester
    Optional<StudentSemester> findByStudentIdAndSemesterId(Long studentId, Long semesterId);
}
