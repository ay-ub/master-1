SQLPLUS /NOLOG; 
CONNECT / AS SYSDBA;
-- CREATE USER CMND
CREATE USER tp2 IDENTIFIED BY tp2Password;

-- ADD PRIVILEGES TO USER tp2
GRANT CREATE TABLE TO tp2;
GRANT CREATE VIEW TO tp2;
GRANT CONNECT TO tp2;


-- CONNECT AS USER tp2 
CONNECT tp2/tp2Password;

-- CREATE TABLES Test
CREATE TABLE Test (id NUMBER, name VARCHAR2(50));


-- INSERT DATA INTO TABLE Test
INSERT INTO Test VALUES (1, 'aziz');
INSERT INTO Test VALUES (2, 'ayoub');
INSERT INTO Test VALUES (3, 'mohamed');


-- CREATE VIEW for test table
CREATE VIEW TestView AS SELECT * FROM Test;

-- SELECT DATA FROM VIEW
SELECT * FROM TestView;
