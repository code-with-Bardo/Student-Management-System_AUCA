package rw.auca.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.student_management_system.model.Student;
import rw.auca.student_management_system.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/reg-id")
    public ResponseEntity<Student> getStudentByRegId(@RequestParam String regId) {
        Optional<Student> student = studentService.getStudentByRegId(regId);
        return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam String query) {
        return ResponseEntity.ok(studentService.searchStudents(query));
    }

    @GetMapping("/national-id/exists")
    public ResponseEntity<Boolean> checkNationalId(@RequestParam String nationalId) {
        return ResponseEntity.ok(studentService.existsByNationalId(nationalId));
    }

    @GetMapping("/program/{programId}")
    public ResponseEntity<List<Student>> getStudentsByProgram(@PathVariable Long programId) {
        return ResponseEntity.ok(studentService.getStudentsByProgramId(programId));
    }

    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<List<Student>> getStudentsBySemester(@PathVariable Long semesterId) {
        return ResponseEntity.ok(studentService.getStudentsBySemesterId(semesterId));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countStudents() {
        return ResponseEntity.ok(studentService.countStudents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
