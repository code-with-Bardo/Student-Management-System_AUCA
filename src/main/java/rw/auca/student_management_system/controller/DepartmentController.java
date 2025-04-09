package rw.auca.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.student_management_system.model.Department;
import rw.auca.student_management_system.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        return department.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<Department> getDepartmentByName(@RequestParam String name) {
        return ResponseEntity.ok(departmentService.getDepartmentByName(name));
    }

    @GetMapping("/faculty/{facultyId}")
    public ResponseEntity<List<Department>> getDepartmentsByFaculty(@PathVariable Long facultyId) {
        return ResponseEntity.ok(departmentService.getDepartmentsByFacultyId(facultyId));
    }

    @GetMapping("/faculty/{facultyId}/names")
    public ResponseEntity<List<String>> getDepartmentNamesByFaculty(@PathVariable Long facultyId) {
        return ResponseEntity.ok(departmentService.getDepartmentNamesByFacultyId(facultyId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
