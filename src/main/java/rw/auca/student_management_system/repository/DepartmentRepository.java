package rw.auca.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.auca.student_management_system.model.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Find department by name
    Department findByNameIgnoreCase(String name);

    // List all departments in a faculty
    @Query("SELECT d FROM Department d WHERE d.faculty.id = :facultyId")
    List<Department> findDepartmentsByFacultyId(Long facultyId);

    // List all department names under a specific faculty
    @Query("SELECT d.name FROM Department d WHERE d.faculty.id = :facultyId")
    List<String> findDepartmentNamesByFacultyId(Long facultyId);
}
