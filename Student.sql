USE Master;
GO
IF DB_ID('Student') IS NOT NULL
	DROP DATABASE Student
GO
CREATE DATABASE Student
GO
USE Student
CREATE TABLE Student
(
 Name nvarchar(50) PRIMARY KEY NOT NULL,
 Rollno numeric NOT NULL,
 Class nvarchar(15) NULL
)
GO

INSERT INTO Student VALUES ('NGUYEN ANH THAI', 1, 'K43A');

SELECT * FROM Student;
