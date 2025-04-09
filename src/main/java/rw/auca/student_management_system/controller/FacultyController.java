package rw.auca.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.student_management_system.model.Faculty;
import rw.auca.student_management_system.service.FacultyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculties")
@CrossOrigin(origins = "*")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.saveFaculty(faculty));
    }

    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        Optional<Faculty> faculty = facultyService.getFacultyById(id);
        return faculty.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<Faculty> getFacultyByName(@RequestParam String name) {
        return ResponseEntity.ok(facultyService.getFacultyByName(name));
    }

    @GetMapping("/{id}/departments/count")
    public ResponseEntity<Long> countDepartments(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.countDepartments(id));
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getFacultyNames() {
        return ResponseEntity.ok(facultyService.getAllFacultyNames());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
