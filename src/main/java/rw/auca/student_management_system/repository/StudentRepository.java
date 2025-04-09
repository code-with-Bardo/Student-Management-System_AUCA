package rw.auca.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.auca.student_management_system.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Search by registration ID
    Optional<Student> findByRegId(String regId);

    // Search by name or email (partial match)
    List<Student> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);

    // Check if student exists by national ID
    boolean existsByNationalId(String nationalId);

    // Count number of students in the system
    long count();

    // Find students registered in a specific program
    @Query("""
            SELECT DISTINCT s
            FROM Student s
            JOIN s.semesters ss
            WHERE ss.semester.program.id = :programId
            """)
            List<Student> findStudentsByProgramId(Long programId);

    // Find students in a specific semester
    @Query("""
            SELECT DISTINCT s
            FROM Student s
            JOIN s.semesters ss
            WHERE ss.semester.id = :semesterId
            """)
            List<Student> findStudentsBySemesterId(Long semesterId);
}
