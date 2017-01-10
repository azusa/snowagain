--// create dept table
-- Migration SQL that makes the change goes here.

CREATE TABLE dept
(
  deptno numeric(2,0) NOT NULL,
  dname character varying(14),
  loc character varying(13),
  versionno numeric(8,0),
  active numeric(1,0),
  CONSTRAINT dept_pkey PRIMARY KEY (deptno)
);


--//@UNDO
-- SQL to undo the change goes here.

DROP TABLE dept;