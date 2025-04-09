package rw.auca.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.auca.student_management_system.model.Program;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program, Long> {
    // Find by name (Undergraduate or Masters)
    List<Program> findByNameIgnoreCase(String name);

    // Count number of semesters for a program
    @Query("SELECT COUNT(s) FROM Semester s WHERE s.program.id = :programId")
    long countSemestersByProgramId(Long programId);

    // List all programs sorted alphabetically
    List<Program> findAllByOrderByNameAsc();
}
