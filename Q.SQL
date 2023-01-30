USE ACADEMY;
CREATE TABLE STUDENT(
    tud_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    dep_id INT NOT NULL,
    fname CHAR(255) NOT NULL,
    lname BIGINT NOT NULL,
    age INT NOT NULL,
    grade CHAR(255) NOT NULL,
    year INT NOT NULL
);
ALTER TABLE
    STUDENT ADD PRIMARY KEY student_stud_id_primary(stud_id);
CREATE TABLE department(
    dep_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    dep_name CHAR(255) NOT NULL
);
ALTER TABLE
    department ADD PRIMARY KEY department_dep_id_primary(dep_id);
CREATE TABLE teacher(
    teacher_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    dep_id BIGINT NOT NULL,
    fname CHAR(255) NOT NULL,
    lname BIGINT NOT NULL,
    age INT NOT NULL
);
ALTER TABLE
    teacher ADD PRIMARY KEY teacher_teacher_id_primary(teacher_id);
CREATE TABLE course(
    course_name CHAR(255) NOT NULL,
    course_code CHAR(255) NOT NULL,
    credit_hour INT NOT NULL
);
ALTER TABLE
    course ADD PRIMARY KEY course_course_code_primary(course_code);
CREATE TABLE fee(
    fee_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    stud_id INT NOT NULL,
    amount INT NOT NULL
);
ALTER TABLE
    fee ADD PRIMARY KEY fee_fee_id_primary(fee_id);
CREATE TABLE teacher_course(
    course_code INT NOT NULL,
    teacher_id INT NOT NULL
);
ALTER TABLE
    teacher_course ADD PRIMARY KEY teacher_course_course_code_primary(course_code);
ALTER TABLE
    teacher_course ADD PRIMARY KEY teacher_course_teacher_id_primary(teacher_id);
CREATE TABLE course_dep(
    course_code BIGINT NOT NULL,
    dep BIGINT NOT NULL
);
ALTER TABLE
    course_dep ADD PRIMARY KEY course_dep_course_code_primary(course_code);
ALTER TABLE
    course_dep ADD PRIMARY KEY course_dep_dep_primary(dep);
CREATE TABLE stud_course(
    stud BIGINT NOT NULL,
    course BIGINT NOT NULL
);
ALTER TABLE
    stud_course ADD PRIMARY KEY stud_course_stud_primary(stud);
ALTER TABLE
    stud_course ADD PRIMARY KEY stud_course_course_primary(course);
CREATE TABLE stud_teacher(
    stud_id BIGINT NOT NULL,
    teacher_id BIGINT NOT NULL
);
ALTER TABLE
    stud_teacher ADD PRIMARY KEY stud_teacher_stud_id_primary(stud_id);
ALTER TABLE
    stud_teacher ADD PRIMARY KEY stud_teacher_teacher_id_primary(teacher_id);
ALTER TABLE
    STUDENT ADD CONSTRAINT student_dep_id_foreign FOREIGN KEY(dep_id) REFERENCES department(dep_id);
ALTER TABLE
    teacher ADD CONSTRAINT teacher_dep_id_foreign FOREIGN KEY(dep_id) REFERENCES department(dep_id);