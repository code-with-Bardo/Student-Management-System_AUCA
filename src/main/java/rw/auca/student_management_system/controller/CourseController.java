package rw.auca.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.student_management_system.model.Course;
import rw.auca.student_management_system.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.saveCourse(course));
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/code")
    public ResponseEntity<Course> getCourseByCode(@RequestParam String code) {
        return ResponseEntity.ok(courseService.getCourseByCode(code));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Course>> searchCourses(@RequestParam String name) {
        return ResponseEntity.ok(courseService.searchByName(name));
    }

    @GetMapping("/department/{deptId}")
    public ResponseEntity<List<Course>> getCoursesByDepartment(@PathVariable Long deptId) {
        return ResponseEntity.ok(courseService.getCoursesByDepartment(deptId));
    }

    @GetMapping("/lecturer/{lecturerId}")
    public ResponseEntity<List<Course>> getCoursesByLecturer(@PathVariable Long lecturerId) {
        return ResponseEntity.ok(courseService.getCoursesByLecturer(lecturerId));
    }

    @GetMapping("/department/{deptId}/count")
    public ResponseEntity<Long> countCoursesInDepartment(@PathVariable Long deptId) {
        return ResponseEntity.ok(courseService.countCoursesInDepartment(deptId));
    }

    @GetMapping("/display-names")
    public ResponseEntity<List<String>> getAllCourseDisplayNames() {
        return ResponseEntity.ok(courseService.getAllCourseDisplayNames());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
