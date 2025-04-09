package rw.auca.student_management_system.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int semesterNo;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    // Constructors
    public Semester() {}

    public Semester(int semesterNo, Program program) {
        this.semesterNo = semesterNo;
        this.program = program;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(int semesterNo) {
        this.semesterNo = semesterNo;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}