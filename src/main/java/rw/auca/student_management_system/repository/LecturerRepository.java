package rw.auca.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.auca.student_management_system.model.Lecturer;

import java.util.List;
import java.util.Optional;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

    // Find lecturer by email
    Optional<Lecturer> findByEmailIgnoreCase(String email);

    // Search lecturer by name
    List<Lecturer> findByNameContainingIgnoreCase(String keyword);

    // Count how many courses a lecturer teaches
    @Query("SELECT COUNT(c) FROM Course c WHERE c.lecturer.id = :lecturerId")
    long countCoursesByLecturerId(Long lecturerId);

    // List all lecturer names
    @Query("SELECT l.name FROM Lecturer l")
    List<String> findAllLecturerNames();
}
