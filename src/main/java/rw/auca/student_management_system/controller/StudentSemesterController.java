package rw.auca.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.student_management_system.model.StudentSemester;
import rw.auca.student_management_system.service.StudentSemesterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student-semesters")
@CrossOrigin(origins = "*")
public class StudentSemesterController {

    @Autowired
    private StudentSemesterService studentSemesterService;

    @PostMapping
    public ResponseEntity<StudentSemester> registerSemester(@RequestBody StudentSemester studentSemester) {
        return ResponseEntity.ok(studentSemesterService.saveStudentSemester(studentSemester));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentSemester>> getStudentSemesters(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentSemesterService.getSemestersByStudentId(studentId));
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> checkRegistrationExists(
            @RequestParam Long studentId,
            @RequestParam Long semesterId
    ) {
        boolean exists = studentSemesterService.exists(studentId, semesterId);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/{id}/credits")
    public ResponseEntity<Integer> getTotalCredits(@PathVariable Long id) {
        return ResponseEntity.ok(studentSemesterService.getTotalCredits(id));
    }

    @GetMapping("/courses")
    public ResponseEntity<List<String>> getRegisteredCourseCodes(
            @RequestParam Long studentId,
            @RequestParam Long semesterId
    ) {
        return ResponseEntity.ok(studentSemesterService.getRegisteredCourseCodes(studentId, semesterId));
    }

    @GetMapping("/record")
    public ResponseEntity<StudentSemester> getStudentSemesterRecord(
            @RequestParam Long studentId,
            @RequestParam Long semesterId
    ) {
        Optional<StudentSemester> ss = studentSemesterService.getByStudentAndSemester(studentId, semesterId);
        return ss.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentSemester(@PathVariable Long id) {
        studentSemesterService.deleteStudentSemester(id);
        return ResponseEntity.noContent().build();
    }
}
