
Insert into Student (ID, FIRST_NAME, LAST_NAME, EMAIL, AGE, date_created)
VALUES (STUDENT_SEQUENCE.nextval,'Thomas', 'Moore', 'tmoor@gmail.com','51', current_timestamp);
Insert into Student (ID, FIRST_NAME, LAST_NAME, EMAIL, AGE, date_created)
VALUES (STUDENT_SEQUENCE.nextval,'Wild', 'Bill', 'wbill@gmail.com','34', current_timestamp);
Insert into Student (ID, FIRST_NAME, LAST_NAME, EMAIL, AGE, date_created)
VALUES (STUDENT_SEQUENCE.nextval,'Mary', 'Power', 'mpower@gmail.com','18', current_timestamp);


Insert into Course (ID, course_title, department, date_created)
VALUES (COURSE_SEQUENCE.nextval,'Course 1 in department 1', 'Department 1', current_timestamp);
Insert into Course (ID, course_title, department, date_created)
VALUES (COURSE_SEQUENCE.nextval,'Course 2 in department 1', 'Department 1', current_timestamp);
Insert into Course (ID, course_title, department, date_created)
VALUES (COURSE_SEQUENCE.nextval,'Course 1 in departlment 2', 'Department 2', current_timestamp);

Insert into Book (ID, book_title, date_created)
VALUES (BOOK_SEQUENCE.nextval,'Book 1', current_timestamp);
Insert into Book (ID, book_title, date_created)
VALUES (BOOK_SEQUENCE.nextval,'Book 2', current_timestamp);
Insert into Book (ID, book_title, date_created)
VALUES (BOOK_SEQUENCE.nextval,'Book 3', current_timestamp);