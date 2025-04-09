package rw.auca.student_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.student_management_system.model.Program;
import rw.auca.student_management_system.repository.ProgramRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    // Save a new program
    public Program saveProgram(Program program) {
        return programRepository.save(program);
    }

    // Get all programs
    public List<Program> getAllPrograms() {
        return programRepository.findAllByOrderByNameAsc();
    }

    // Find program by ID
    public Optional<Program> getProgramById(Long id) {
        return programRepository.findById(id);
    }

    // Find program by name
    public List<Program> getProgramByName(String name) {
        return programRepository.findByNameIgnoreCase(name);
    }

    // Delete program
    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }

    // Count number of semesters in a program
    public long countSemestersInProgram(Long programId) {
        return programRepository.countSemestersByProgramId(programId);
    }
}
