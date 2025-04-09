package rw.auca.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.auca.student_management_system.model.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Find by course code
    Course findByCodeIgnoreCase(String code);

    // Search by course name (contains)
    List<Course> findByNameContainingIgnoreCase(String name);

    // Find all courses assigned to a department
    List<Course> findByDepartmentId(Long departmentId);

    // Find all courses taught by a specific lecturer
    List<Course> findByLecturerId(Long lecturerId);

    // Count courses in a department
    @Query("SELECT COUNT(c) FROM Course c WHERE c.department.id = :deptId")
    long countByDepartmentId(Long deptId);

    // Get course codes and names (e.g., for dropdowns)
    @Query("SELECT CONCAT(c.code, ' - ', c.name) FROM Course c")
    List<String> getAllCourseDisplayNames();
}
