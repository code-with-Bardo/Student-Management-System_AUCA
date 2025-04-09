package rw.auca.student_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.student_management_system.model.Semester;
import rw.auca.student_management_system.repository.SemesterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {

    @Autowired
    private SemesterRepository semesterRepository;

    // Save or update semester
    public Semester saveSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

    // Get all semesters
    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    // Get semester by ID
    public Optional<Semester> getSemesterById(Long id) {
        return semesterRepository.findById(id);
    }

    // Get all semesters for a specific program
    public List<Semester> getSemestersByProgramId(Long programId) {
        return semesterRepository.findByProgramId(programId);
    }

    // Check if a semester number exists for a program
    public boolean semesterExists(Long programId, int semesterNo) {
        return semesterRepository.existsByProgramIdAndSemesterNo(programId, semesterNo);
    }

    // Get all semester numbers for a program
    public List<Integer> getSemesterNumbersByProgram(Long programId) {
        return semesterRepository.findSemesterNumbersByProgramId(programId);
    }

    // Delete a semester
    public void deleteSemester(Long id) {
        semesterRepository.deleteById(id);
    }
}
