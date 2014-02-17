DROP DATABASE IF EXISTS PATIENTDB;

CREATE DATABASE PATIENTDB;

USE PATIENTDB;

GRANT ALL PRIVILEGES ON PATIENTDB TO TheUser@"%" IDENTIFIED BY "concordia";
GRANT ALL  PRIVILEGES ON PATIENTDB TO TheUser@"localhost" IDENTIFIED BY "concordia";

DROP TABLE IF EXISTS PATIENT;

CREATE TABLE PATIENT (
  PATIENTID int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  LASTNAME varchar(30) NOT NULL DEFAULT '',
  FIRSTNAME varchar(30) NOT NULL DEFAULT '',
  DIAGNOSIS varchar(60) NOT NULL DEFAULT '',
  ADMISSIONDATE timestamp,
  RELEASERATE timestamp
) ENGINE=InnoDB;

DROP TABLE IF EXISTS INPATIENT;

CREATE TABLE INPATIENT (
  ID int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  PATIENTID int(11),
  DATEOFSTAY timestamp,
  ROOMNUMBER varchar(5) NOT NULL DEFAULT '',
  DAILYRATE decimal(10,2),
  SUPPLIES decimal(10,2),
  SERVICES decimal(10,2),
  KEY PATIENTID (PATIENTID),
  CONSTRAINT patient_1 FOREIGN KEY (PATIENTID) REFERENCES PATIENT (PATIENTID)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS SURGICAL;

CREATE TABLE SURGICAL (
  ID int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  PATIENTID int(11),
  DATEOFSURGERY timestamp,
  SURGERY varchar(25) NOT NULL DEFAULT '',
  ROOMFEE decimal(10,2),
  SURGEONFEE decimal(10,2),
  SUPPLIES decimal(10,2),
  KEY PATIENTID (PATIENTID),
  CONSTRAINT patient_2 FOREIGN KEY (PATIENTID) REFERENCES PATIENT (PATIENTID)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS MEDICATION;

CREATE TABLE MEDICATION (
  ID int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  PATIENTID int(11),
  DATEOFMED timestamp,
  MED varchar(45) NOT NULL DEFAULT '',
  UNITCOST decimal(10,2),
  UNITS decimal(10,2) ,
  KEY PATIENTID (PATIENTID),
  CONSTRAINT patient_3 FOREIGN KEY (PATIENTID) REFERENCES PATIENT (PATIENTID)
) ENGINE=InnoDB;

INSERT INTO PATIENT (LASTNAME, FIRSTNAME, DIAGNOSIS, ADMISSIONDATE, RELEASERATE) values 
("Wayne","Bruce","Asthma","2014-01-23 9:00:00","2014-01-25 13:00:00"),
("Allen","Barry","Kidney Stones","2014-02-18 9:00:00","2014-02-21 13:00:00"),
("Kent","Clark","Tonsilitis","2014-05-02 9:00:00","2014-05-07 13:00:00"),
("Stark","Tony","Appendicitis","2014-07-14 9:00:00","2014-07-15 13:00:00"),
("Banner","Bruce","Gall Bladder Disease","2014-11-09 9:00:00","2014-11-12 13:00:00");

INSERT INTO INPATIENT(PATIENTID,DATEOFSTAY,ROOMNUMBER,DAILYRATE,SUPPLIES,SERVICES) values
(1, "2014-01-23 9:00:00","A1","250.00","75.24","12.95"),
(1, "2014-01-24 9:00:00","A1","250.00","90.15","58.12"),
(1, "2014-01-25 9:00:00","A1","250.00","120.23","87.05"),
(2, "2014-02-18 9:00:00","B2","150.00","120.23","87.05"),
(2, "2014-02-19 9:00:00","B2","150.00","120.23","87.05"),
(2, "2014-02-20 9:00:00","B2","150.00","120.23","87.05"),
(2, "2014-02-21 9:00:00","B2","150.00","120.23","87.05"),
(3, "2014-05-02 9:00:00","C3","150.00","120.23","87.05"),
(3, "2014-05-03 9:00:00","C3","150.00","120.23","87.05"),
(3, "2014-05-04 9:00:00","C3","150.00","120.23","87.05"),
(3, "2014-05-05 9:00:00","C3","150.00","120.23","87.05"),
(3, "2014-05-06 9:00:00","C3","150.00","120.23","87.05"),
(3, "2014-05-07 9:00:00","C3","150.00","120.23","87.05"),
(3, "2014-05-07 9:00:00","C3","150.00","120.23","87.05"),
(4, "2014-07-14 9:00:00","D4","150.00","120.23","87.05"),
(4, "2014-07-15 9:00:00","C4","150.00","120.23","87.05"),
(5, "2014-11-09 9:00:00","E5","150.00","120.23","87.05"),
(5, "2014-11-10 9:00:00","E5","150.00","120.23","87.05"),
(5, "2014-11-11 9:00:00","E5","150.00","120.23","87.05"),
(5, "2014-11-12 9:00:00","E5","150.00","120.23","87.05");

INSERT INTO SURGICAL(PATIENTID,DATEOFSURGERY,SURGERY,ROOMFEE,SURGEONFEE,SUPPLIES) values
(1, "2014-01-24 11:00:00","Lung Transplant", 2500.12, 4200.00, 934.23),
(2, "2014-02-19 07:00:00","Kidney Transplant", 2500.12, 4200.00, 934.23),
(3, "2014-05-03 21:00:00","Tonsil Transplant", 2500.12, 4200.00, 934.23),
(4, "2014-07-14 14:00:00","Appendix Transplant", 2500.12, 4200.00, 934.23),
(5, "2014-11-11 10:00:00","Gall Bladder Transplant", 2500.12, 4200.00, 934.23);

INSERT INTO MEDICATION(PATIENTID,DATEOFMED,MED,UNITCOST,UNITS) values
(1, "2014-01-24 11:00:00", "Snickers", 1.25, 5.0),
(2, "2014-02-19 07:00:00", "M and M", 1.10, 15.0),
(3, "2014-05-03 21:00:00", "O Henry", 2.49, 11.0),
(4, "2014-07-14 14:00:00", "Caramilk", 4.23, 3.0),
(5, "2014-11-11 10:00:00", "Aero Bar", 9.43, 19.0);