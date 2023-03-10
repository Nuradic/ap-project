use ACADEMY;
CREATE TABLE DEPARTMENT(dep_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,dep_name VARCHAR(255) NOT NULL );

CREATE TABLE STUDENT(stud_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,password VARCHAR(64),email VARCHAR(64) NOT NULL UNIQUE,fname VARCHAR(255) NOT NULL,lname VARCHAR(255),dep_id INT UNSIGNED,FOREIGN KEY(dep_id) REFERENCES DEPARTMENT);

CREATE TABLE COURSE(course_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,course_name VARCHAR(255) NOT NULL,course_desc TEXT,dep_id INT NOT NULL ,FOREIGN KEY(dep_id)REFERENCES DEPARTMENT);

CREATE TABLE COURSE_MATERIAL(courm_id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,url VARCHAR(255) NOT NULL,course_id INT NOT NULL,FOREIGN KEY (course_id) REFERENCES COURSE);

-- SELECT* FROM STUDENT WHERE stud_id=stud_id INNER JOIN;

-- SELECT TABLE.COLUMN, TABLE2.COLOUMN FROM TABLE INNER JOIN TABLE2 ON TABLE.ID=TABLE2.ID;

