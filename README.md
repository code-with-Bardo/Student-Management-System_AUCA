## 📘 **Project Title:**  
**AUCA Student Management System**

---

## 📝 **Project Description:**

The AUCA Student Management System is a comprehensive web-based academic administration platform designed to manage student enrollment, course registration, lecturer assignment, and academic record tracking at the Adventist University of Central Africa (AUCA).

It enables different university roles—such as chancellor, registrar, deans, heads of departments, lecturers, and students—to interact with the system based on their specific privileges.

The platform handles:
- Student CRUD operations with multi-semester and course tracking
- Course creation and lecturer assignments
- Department and faculty-level academic structures
- Semester-based academic progress
- Role-based access for administration, performance analytics, and academic evaluation

---

## 🎯 **Main Features:**

1. **Student Management**
   - Register, view, update, delete students
   - Assign students to semesters and register courses
   - Track total credits per semester

2. **Course Management**
   - Register courses under departments and assign lecturers
   - Manage course credits

3. **Lecturer Management**
   - Register, update, and assign lecturers to courses
   - Track performance by course load

4. **Academic Structure**
   - Program (Undergraduate, Masters)
   - Faculty → Department → Course

5. **Semester Management**
   - Define semesters under specific programs
   - Register students to semesters

6. **StudentSemester Tracker**
   - Register specific courses to students per semester
   - Calculate total credits and generate reports

7. **Authentication and Roles (To be integrated)**
   - Chancellor, Vice Chancellor, Registrar, Dean, Head of Department, Lecturer, Student
   - Each role sees a customized dashboard and features

---

## ⚙️ **Tech Stack:**

| Layer        | Technology                             |
|--------------|-----------------------------------------|
| **Backend**  | Java 17, Spring Boot, Spring Data JPA   |
| **Database** | PostgreSQL                              |
| **Frontend** | React.js + Bootstrap (Single Page App)  |
| **View (admin)** | JSP (optional admin views)             |
| **Documentation** | Swagger / OpenAPI                     |
| **Build Tool** | Maven                                  |
| **IDE**       | IntelliJ IDEA, VS Code                  |

---

## 🗂️ **Modules Covered:**
- Program & Semester Setup
- Faculty & Department Mapping
- Student Academic Lifecycle
- Course Assignments
- Dynamic Reporting (via API or PDF in future)
- Postman API test suite

---
