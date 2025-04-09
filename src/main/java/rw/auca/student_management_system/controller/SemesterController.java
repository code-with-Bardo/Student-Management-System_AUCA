package rw.auca.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.student_management_system.model.Semester;
import rw.auca.student_management_system.service.SemesterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/semesters")
@CrossOrigin(origins = "*")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @PostMapping
    public ResponseEntity<Semester> createSemester(@RequestBody Semester semester) {
        return ResponseEntity.ok(semesterService.saveSemester(semester));
    }

    @GetMapping
    public ResponseEntity<List<Semester>> getAllSemesters() {
        return ResponseEntity.ok(semesterService.getAllSemesters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semester> getSemesterById(@PathVariable Long id) {
        Optional<Semester> semester = semesterService.getSemesterById(id);
        return semester.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/program/{programId}")
    public ResponseEntity<List<Semester>> getSemestersByProgramId(@PathVariable Long programId) {
        return ResponseEntity.ok(semesterService.getSemestersByProgramId(programId));
    }

    @GetMapping("/program/{programId}/numbers")
    public ResponseEntity<List<Integer>> getSemesterNumbers(@PathVariable Long programId) {
        return ResponseEntity.ok(semesterService.getSemesterNumbersByProgram(programId));
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> checkIfSemesterExists(
            @RequestParam Long programId,
            @RequestParam int semesterNo
    ) {
        boolean exists = semesterService.semesterExists(programId, semesterNo);
        return ResponseEntity.ok(exists);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemester(@PathVariable Long id) {
        semesterService.deleteSemester(id);
        return ResponseEntity.noContent().build();
    }
}
