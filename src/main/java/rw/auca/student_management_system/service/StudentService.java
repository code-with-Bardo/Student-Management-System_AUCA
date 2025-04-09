package rw.auca.student_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.student_management_system.model.Student;
import rw.auca.student_management_system.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Register or update a student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Find by student ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Find by registration ID
    public Optional<Student> getStudentByRegId(String regId) {
        return studentRepository.findByRegId(regId);
    }

    // Search by name or email
    public List<Student> searchStudents(String nameOrEmail) {
        return studentRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(nameOrEmail, nameOrEmail);
    }

    // Check if national ID already exists
    public boolean existsByNationalId(String nationalId) {
        return studentRepository.existsByNationalId(nationalId);
    }

    // Count total students
    public long countStudents() {
        return studentRepository.count();
    }

    // Get students by program
    public List<Student> getStudentsByProgramId(Long programId) {
        return studentRepository.findStudentsByProgramId(programId);
    }

    // Get students by semester
    public List<Student> getStudentsBySemesterId(Long semesterId) {
        return studentRepository.findStudentsBySemesterId(semesterId);
    }

    // Delete student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
