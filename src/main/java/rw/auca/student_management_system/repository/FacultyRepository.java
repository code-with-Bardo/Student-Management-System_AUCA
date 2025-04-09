package rw.auca.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.auca.student_management_system.model.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    // Find by name (case-insensitive)
    Faculty findByNameIgnoreCase(String name);

    // List all faculties sorted alphabetically
    List<Faculty> findAllByOrderByNameAsc();

    // Count departments in a faculty
    @Query("SELECT COUNT(d) FROM Department d WHERE d.faculty.id = :facultyId")
    long countDepartmentsByFacultyId(Long facultyId);

    // List faculty names only
    @Query("SELECT f.name FROM Faculty f")
    List<String> findAllFacultyNames();
}
