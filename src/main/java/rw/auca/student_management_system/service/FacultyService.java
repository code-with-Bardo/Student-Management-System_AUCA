package rw.auca.student_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.student_management_system.model.Faculty;
import rw.auca.student_management_system.repository.FacultyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    // Save new faculty
    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    // Get all faculties
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAllByOrderByNameAsc();
    }

    // Get faculty by ID
    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.findById(id);
    }

    // Get faculty by name
    public Faculty getFacultyByName(String name) {
        return facultyRepository.findByNameIgnoreCase(name);
    }

    // Delete faculty
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    // Count departments in a faculty
    public long countDepartments(Long facultyId) {
        return facultyRepository.countDepartmentsByFacultyId(facultyId);
    }

    // Get list of faculty names
    public List<String> getAllFacultyNames() {
        return facultyRepository.findAllFacultyNames();
    }
}
