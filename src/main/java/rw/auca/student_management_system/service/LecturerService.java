package rw.auca.student_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.student_management_system.model.Lecturer;
import rw.auca.student_management_system.repository.LecturerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    // Save a new lecturer
    public Lecturer saveLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    // Get all lecturers
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    // Get lecturer by ID
    public Optional<Lecturer> getLecturerById(Long id) {
        return lecturerRepository.findById(id);
    }

    // Get lecturer by email
    public Optional<Lecturer> getLecturerByEmail(String email) {
        return lecturerRepository.findByEmailIgnoreCase(email);
    }

    // Search lecturers by name
    public List<Lecturer> searchLecturers(String keyword) {
        return lecturerRepository.findByNameContainingIgnoreCase(keyword);
    }

    // Count number of courses taught by a lecturer
    public long countCoursesTaughtByLecturer(Long lecturerId) {
        return lecturerRepository.countCoursesByLecturerId(lecturerId);
    }

    // List lecturer names (e.g., for dropdown)
    public List<String> getAllLecturerNames() {
        return lecturerRepository.findAllLecturerNames();
    }

    // Delete a lecturer
    public void deleteLecturer(Long id) {
        lecturerRepository.deleteById(id);
    }
}
