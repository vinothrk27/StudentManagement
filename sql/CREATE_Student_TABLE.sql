CREATE TABLE Student (
	id INT IDENTITY CONSTRAINT PK_Student PRIMARY KEY CLUSTERED,
	name varchar(10),
	dept varchar(10)
)