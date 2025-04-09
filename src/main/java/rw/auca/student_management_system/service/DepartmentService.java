package rw.auca.student_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.student_management_system.model.Department;
import rw.auca.student_management_system.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Save a new department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get department by ID
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    // Get department by name
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByNameIgnoreCase(name);
    }

    // Get departments by faculty ID
    public List<Department> getDepartmentsByFacultyId(Long facultyId) {
        return departmentRepository.findDepartmentsByFacultyId(facultyId);
    }

    // Get department names for a faculty
    public List<String> getDepartmentNamesByFacultyId(Long facultyId) {
        return departmentRepository.findDepartmentNamesByFacultyId(facultyId);
    }

    // Delete a department
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
