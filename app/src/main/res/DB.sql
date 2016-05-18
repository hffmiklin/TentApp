CREATE TABLE student(
  pnr INT PRIMARY KEY NOT NULL, 
  gul_id TEXT NOT NULL,
  first_name TEXT NOT NULL,
  last_name TEXT NOT NULL
);

CREATE TABLE course(
  id INT PRIMARY KEY NOT NULL,
  nr CHAR(6) NOT NULL,
  name TEXT NOT NULL,
  term CHAR(2) NOT NULL,
  year INT NOT NULL
);

CREATE TABLE student_course(
  pnr INT NOT NULL,
  id INT NOT NULL
);

CREATE TABLE exam(
  id INT PRIMARY KEY NOT NULL,
  date TEXT,
  time_start TEXT,
  time_end TEXT,
  aid TEXT,
  building TEXT,
  room TEXT,
  reg_open TEXT,
  reg_close TEXT
);

CREATE TABLE student_exam(
  pnr INT NOT NULL,
  exam_id INT NOT NULL,
  registered TEXT
);

CREATE TABLE building(
  name TEXT NOT NULL,
  address TEXT NOT NULL
);

CREATE VIEW student_course_list AS 
SELECT course.nr, course.name
FROM (student INNER JOIN student_course ON student.pnr=student_course.pnr) INNER JOIN course ON student_course.id=course.id
WHERE gul_id='guspetanh';

INSERT INTO student VALUES (7503228222, 'guspetanh', 'Petter', 'Andersson');
INSERT INTO student VALUES (9409153523, 'gusgrasmt', 'Smilla', 'Grandin');

INSERT INTO course VALUES (1, 'TIG163', 'Beslutsstödssystem', 'VT', 2016);
INSERT INTO course VALUES (2, 'TIG015', 'Informationsteknologi och informationssystem', 'HT', 2015);
INSERT INTO course VALUES (3, 'TIG058', 'Databaser och programmeringsteknik', 'VT', 2016);

INSERT INTO student_course VALUES(7503228222, 1);
INSERT INTO student_course VALUES(7503228222, 2);
INSERT INTO student_course VALUES(9409153523, 2);
INSERT INTO student_course VALUES(9409153523, 3);

INSERT INTO exam VALUES(1, '2016-02-16', '08:30', '12:30', 'Inget', 'Saga', 'sal 103', '2015-12-26', '2016-01-16');
INSERT INTO exam VALUES(2, '2016-05-22', '08:30', '12:30', 'Inget', 'Patricia', 'sal 107', '2016-03-22', '2016-04-22');
INSERT INTO exam VALUES(3, '2016-04-22', '08:30', '12:30', 'Kurslitteratur', 'Saga', 'sal 109', '2016-02-22', '2016-03-22');

INSERT INTO student_exam VALUES(7503228222, 1, 'Ja');
INSERT INTO student_exam VALUES(7503228222, 2, 'Nej');
INSERT INTO student_exam VALUES(9409153523, 2, 'Ja');
INSERT INTO student_exam VALUES(9409153523, 3, 'Ja');

INSERT INTO building VALUES('Saga', 'Hörselgången 4, Gothenburg');
INSERT INTO building VALUES('Patricia', 'Forskningsgången 6, Gothenburg');
INSERT INTO building VALUES('Jupiter', 'Hörselgången 5, Gothenburg');
