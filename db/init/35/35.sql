ALTER table user ADD COLUMN state int(11);
INSERT INTO role (name) values('regular');
INSERT INTO role (name) values('premium');
ALTER table user MODIFY email varchar(100) NOT NULL;
 