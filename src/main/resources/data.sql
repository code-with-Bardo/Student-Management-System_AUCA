-- Programs
INSERT INTO program (id, name)
VALUES (1, 'Undergraduate'),
       (2, 'Masters');

-- Faculties
INSERT INTO faculty (id, name)
VALUES (1, 'Information Technology');

-- Departments
INSERT INTO department (id, name, faculty_id)
VALUES (1, 'Software Engineering', 1),
       (2, 'Networking and Communication Systems', 1),
       (3, 'Information and Management Systems', 1);

-- Lecturers
INSERT INTO lecturer (id, name, email)
VALUES (1, 'Dr. John Doe', 'john.doe@auca.ac.rw'),
       (2, 'Dr. Jane Smith', 'jane.smith@auca.ac.rw');

-- Courses
INSERT INTO course (id, code, name, credits, department_id, lecturer_id)
VALUES (1, 'SENG-324', 'Software Engineering', 3, 1, 1),
       (2, 'INST-134', 'Java Programming', 4, 1, 1),
       (3, 'CONET-125', 'Computer Networks', 4, 2, 2);

-- Semesters
INSERT INTO semester (id, semester_no, program_id)
VALUES (1, 1, 1),
       (2, 2, 1);

-- Students
INSERT INTO student (id, reg_id, name, email, phone, address, gender, dob, national_id)
VALUES (1, '23205', 'BARNARDO Ntaganira Herve', 'hervebardo@gmail.com', '+250783500656',
        'Kigali, Nyarugenge, Nyakabanda', 'Male', '2001-06-15', '1199880055370120');

-- StudentSemester
INSERT INTO student_semester (id, student_id, semester_id)
VALUES (1, 1, 1);

-- Join Table: Courses in that semester for student
INSERT INTO student_semester_courses (student_semester_id, course_id)
VALUES (1, 1),
       (1, 2),
       (1, 3);