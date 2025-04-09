package rw.auca.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.student_management_system.model.Lecturer;
import rw.auca.student_management_system.service.LecturerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lecturers")
@CrossOrigin(origins = "*")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @PostMapping
    public ResponseEntity<Lecturer> createLecturer(@RequestBody Lecturer lecturer) {
        return ResponseEntity.ok(lecturerService.saveLecturer(lecturer));
    }

    @GetMapping
    public ResponseEntity<List<Lecturer>> getAllLecturers() {
        return ResponseEntity.ok(lecturerService.getAllLecturers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecturer> getLecturerById(@PathVariable Long id) {
        Optional<Lecturer> lecturer = lecturerService.getLecturerById(id);
        return lecturer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email")
    public ResponseEntity<Lecturer> getLecturerByEmail(@RequestParam String email) {
        Optional<Lecturer> lecturer = lecturerService.getLecturerByEmail(email);
        return lecturer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Lecturer>> searchLecturers(@RequestParam String keyword) {
        return ResponseEntity.ok(lecturerService.searchLecturers(keyword));
    }

    @GetMapping("/{id}/courses/count")
    public ResponseEntity<Long> countLecturerCourses(@PathVariable Long id) {
        return ResponseEntity.ok(lecturerService.countCoursesTaughtByLecturer(id));
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getLecturerNames() {
        return ResponseEntity.ok(lecturerService.getAllLecturerNames());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecturer(@PathVariable Long id) {
        lecturerService.deleteLecturer(id);
        return ResponseEntity.noContent().build();
    }
}
