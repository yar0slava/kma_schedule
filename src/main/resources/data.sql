INSERT INTO role (id, name)
VALUES (1, 'USER'),
       (2, 'ADMIN');

-- CREATE TABLE lecturer
-- (
--     lecturerId INT AUTO_INCREMENT PRIMARY KEY,
--     middlename VARCHAR(250) NOT NULL,
--     name       VARCHAR(250) NOT NULL,
--     surname    VARCHAR(250) NOT NULL
-- );

INSERT INTO lecturer (lecturer_Id, middlename, name, surname)
VALUES (1, 'Андріївна', 'Людмила', 'Коваленко'),
       (2, 'Степанівна', 'Ірина', 'Чуєнко'),
       (3, 'Віталійович', 'Максим', 'Андрощук');
--
-- CREATE TABLE classroom
-- (
--     classroomId INT AUTO_INCREMENT PRIMARY KEY,
--     name        VARCHAR(250) NOT NULL,
--     capacity    INT          NOT NULL
-- );
--
INSERT INTO classroom (classroom_Id, name, capacity)
VALUES (1, '215', 50),
       (2, '225', 30),
       (3, '306', 25),
       (4, '111', 40);
--
-- CREATE TABLE classtime
-- (
--     classTimeId INT AUTO_INCREMENT PRIMARY KEY,
--     CLASS_DAY        VARCHAR(250) NOT NULL,
--     CLASS_TIME TIME NOT NULL,
--     WEEK_NUMBER    INT          NOT NULL
-- );
--
INSERT INTO classtime (class_Time_Id, CLASS_DAY, CLASS_TIME, WEEK_NUMBER)
VALUES (1, 'MONDAY', '13:30:00', 1),
       (2, 'TUESDAY', '8:30:00', 1),
       (3, 'WEDNESDAY', '13:30:00', 3),
       (4, 'FRIDAY', '11:40:00', 3);
--
-- CREATE TABLE disciplines
-- (
--     disciplineId INT AUTO_INCREMENT PRIMARY KEY,
--     name        VARCHAR(250) NOT NULL,
--     lecturerId INT NOT NULL
-- );

INSERT INTO disciplines (discipline_Id, name)
VALUES (1, 'Диференційні рівняння'),
       (2, 'Математична логіка'),
       (3, 'Основи Spring Boot'),
       (4, 'Java EE');

INSERT INTO lecturer_teaches (LECTURER_LECTURER_ID, DISCIPLINE_ID)
VALUES (3, 3),
       (1, 2),
       (2, 1),
       (2, 4);

INSERT INTO stud_group (id, is_Lecture, specialization, degree, course, group_Number, lecturer_id)
VALUES (1, true, 'Комп"ютерні науки', 'бакалавр', 4, 1, 1),
       (2, true, 'ІПЗ', 'бакалавр', 3, 3, 2),
       (3, true, 'ПМ', 'бакалавр', 2, 2, 3);

INSERT INTO record (id, discipline_Id, class_Time_Id, group_Id, classroom_Id, lecturer_id)
VALUES (1, 1, 1, 1, 1, 1),
       (2, 2, 2, 2, 2, 2),
       (3, 3, 3, 3, 3, 3),
       (4, 4, 4, 3, 2, 1);