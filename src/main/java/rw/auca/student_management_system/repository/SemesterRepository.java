package rw.auca.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.auca.student_management_system.model.Semester;

import java.util.List;

public interface SemesterRepository extends JpaRepository<Semester, Long> {

    // Find all semesters for a specific program
    List<Semester> findByProgramId(Long programId);

    // Check if a specific semester number exists for a program
    boolean existsByProgramIdAndSemesterNo(Long programId, int semesterNo);

    // Get all semester numbers of a program (e.g., for a dropdown)
    @Query("SELECT s.semesterNo FROM Semester s WHERE s.program.id = :programId ORDER BY s.semesterNo")
    List<Integer> findSemesterNumbersByProgramId(Long programId);
}
