INSERT INTO STUDENTS (ID, AGE, NAME)
VALUES
    (1, 33, 'Pesho'),
    (2, 23, 'Anna');

INSERT INTO COURSES (ID, NAME, ENABLED, PRICE)
VALUES
    (1, 'Spring for dummies', 0, 50),
    (2, 'Spring for pros', 1, 100);

INSERT INTO ORDERS (ID, COURSE_ID, STUDENT_ID)
VALUES
    (1, 1, 1),
    (2, 2, 1),
    (3, 2, 2);
