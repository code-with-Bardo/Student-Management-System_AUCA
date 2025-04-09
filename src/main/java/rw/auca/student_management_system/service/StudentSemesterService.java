package rw.auca.student_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.student_management_system.model.Course;
import rw.auca.student_management_system.model.StudentSemester;
import rw.auca.student_management_system.repository.StudentSemesterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSemesterService {

    @Autowired
    private StudentSemesterRepository studentSemesterRepository;

    // Save or update semester registration
    public StudentSemester saveStudentSemester(StudentSemester studentSemester) {
        return studentSemesterRepository.save(studentSemester);
    }

    // Get all semester registrations for a student
    public List<StudentSemester> getSemestersByStudentId(Long studentId) {
        return studentSemesterRepository.findByStudentId(studentId);
    }

    // Check if student already registered in the semester
    public boolean exists(Long studentId, Long semesterId) {
        return studentSemesterRepository.existsByStudentIdAndSemesterId(studentId, semesterId);
    }

    // Get total credits for a specific student semester
    public int getTotalCredits(Long studentSemesterId) {
        Integer total = studentSemesterRepository.getTotalCreditsByStudentSemesterId(studentSemesterId);
        return total != null ? total : 0;
    }

    // Get course codes a student registered for in a semester
    public List<String> getRegisteredCourseCodes(Long studentId, Long semesterId) {
        return studentSemesterRepository.getCourseCodesForStudentInSemester(studentId, semesterId);
    }

    // Get specific StudentSemester entry
    public Optional<StudentSemester> getByStudentAndSemester(Long studentId, Long semesterId) {
        return studentSemesterRepository.findByStudentIdAndSemesterId(studentId, semesterId);
    }

    // Delete a semester registration
    public void deleteStudentSemester(Long id) {
        studentSemesterRepository.deleteById(id);
    }
}
