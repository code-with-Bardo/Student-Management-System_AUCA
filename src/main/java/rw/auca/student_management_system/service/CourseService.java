package rw.auca.student_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.student_management_system.model.Course;
import rw.auca.student_management_system.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Save or update a course
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get course by ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Get course by code
    public Course getCourseByCode(String code) {
        return courseRepository.findByCodeIgnoreCase(code);
    }

    // Search by course name
    public List<Course> searchByName(String name) {
        return courseRepository.findByNameContainingIgnoreCase(name);
    }

    // Find courses by department
    public List<Course> getCoursesByDepartment(Long departmentId) {
        return courseRepository.findByDepartmentId(departmentId);
    }

    // Find courses by lecturer
    public List<Course> getCoursesByLecturer(Long lecturerId) {
        return courseRepository.findByLecturerId(lecturerId);
    }

    // Count total courses in a department
    public long countCoursesInDepartment(Long departmentId) {
        return courseRepository.countByDepartmentId(departmentId);
    }

    // Get all course display names (code - name)
    public List<String> getAllCourseDisplayNames() {
        return courseRepository.getAllCourseDisplayNames();
    }

    // Delete course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
