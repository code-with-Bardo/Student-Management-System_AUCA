package rw.auca.student_management_system.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Undergraduate or Masters

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<Semester> semesters;

    // Constructors
    public Program() {}

    public Program(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }
}
