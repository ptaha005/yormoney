
CREATE TABLE account_type
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	name                 VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE bank
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	name                 VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE bank_account
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	purpose              VARCHAR(50) NULL,
	balance              INTEGER NULL,
	member_id            INTEGER NULL,
	account_type_id      INTEGER NULL,
	bank_id              INTEGER NULL,
	PRIMARY KEY (id)
);


CREATE TABLE banner
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	path                 VARCHAR(120) NULL,
	PRIMARY KEY (id)
);



CREATE TABLE category
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	name                 VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE event
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	active               INTEGER NULL,
	expenditure_item     CHAR(18) NULL,
	agreed_spend         INTEGER NULL,
	date                 DATE NULL,
	user_id              INTEGER NULL,
	PRIMARY KEY (id)
);



CREATE TABLE event_action
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	active               INTEGER NULL,
	expenditure_item     CHAR(18) NULL,
	agreed_spend         INTEGER NULL,
	date                 DATE NULL,
	event_detail_id      INTEGER NULL,
	PRIMARY KEY (id)
);


CREATE TABLE event_detail
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	active               INTEGER NULL,
	expenditure_item     CHAR(18) NULL,
	agreed_spend         INTEGER NULL,
	date                 DATE NULL,
	event_id             INTEGER NULL,
	PRIMARY KEY (id)
);


CREATE TABLE event_personal
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	active               INTEGER NULL,
	expenditure_item     CHAR(18) NULL,
	agreed_spend         INTEGER NULL,
	date                 DATE NULL,
	relationship_id      INTEGER NULL,
	event_action_id      INTEGER NULL,
	PRIMARY KEY (id)
);


CREATE TABLE event_type
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	date                 DATE NULL,
	name                 VARCHAR(30) NULL,
	event_id             INTEGER NULL,
	PRIMARY KEY (id)
);



CREATE TABLE expenditure
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	active               boolean NULL,
	expenditure_type     VARCHAR(30) NULL,
	Company_name         VARCHAR(30) NULL,
	paid_date_day        INTEGER NULL,
	frequency            VARCHAR(30) NULL,
	cost                 INTEGER NULL,
	paid_from_A_C        VARCHAR(30) NULL,
	member_id            INTEGER NULL,
	user_id              INTEGER NULL,
	expenditure_type_id  INTEGER NULL,
	PRIMARY KEY (id)
);



CREATE TABLE expenditure_type
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	name                 VARCHAR(50) NULL,
	category_id          INTEGER NULL,
	PRIMARY KEY (id)
);



CREATE TABLE income
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	active               boolean NULL,
	income_type          VARCHAR(30) NULL,
	income_source        VARCHAR(30) NULL,
	paid_date_day        INTEGER NULL,
	frequency            VARCHAR(30) NULL,
	amount               INTEGER NULL,
	paid_A_C             VARCHAR(30) NULL,
	income_type_id       INTEGER NULL,
	user_id              INTEGER NULL,
	member_id            INTEGER NULL,
	PRIMARY KEY (id)
);



CREATE TABLE income_type
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	name                 VARCHAR(30) NULL,
	user_id              INTEGER NULL,
	PRIMARY KEY (id)
);


CREATE TABLE member
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	date_of_birth        CHAR(18) NULL,
	account_holder       boolean NULL,
	last_name            VARCHAR(30) NULL,
	first_name           VARCHAR(30) NULL,
	address              VARCHAR(80) NULL,
	relationship_id      INTEGER NULL,
	user_id              INTEGER NULL,
	PRIMARY KEY (id)
);


CREATE TABLE page
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	description          VARCHAR(60) NULL,
	url                  VARCHAR(60) NULL,
	banner_id            INTEGER NULL,
	PRIMARY KEY (id)
);


CREATE TABLE relationship
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	name                 VARCHAR(30) NULL,
	PRIMARY KEY (id)
);


CREATE TABLE role
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	name                 VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
);



CREATE TABLE transaction
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	date                 DATE NULL,
	description          VARCHAR(20) NULL,
	user_id              INTEGER NULL,
	bank_account         INTEGER NULL,
	PRIMARY KEY (id)
);



CREATE TABLE user
(
	id                   INTEGER NOT NULL AUTO_INCREMENT,
	postcode             INTEGER NOT NULL,
	email                VARCHAR(30) NOT NULL,
	username             VARCHAR(30) NOT NULL,
	password             VARCHAR(20) NOT NULL,
	activation_code      VARCHAR(20) NULL,
	last_name            VARCHAR(30) NOT NULL,
	first_name           VARCHAR(30) NULL,
	address              VARCHAR(80) NULL,
	role_id              INTEGER NOT NULL,
	PRIMARY KEY (id)
);


ALTER TABLE bank_account
ADD FOREIGN KEY R_86 (member_id) REFERENCES member (id);



ALTER TABLE bank_account
ADD FOREIGN KEY R_87 (account_type_id) REFERENCES account_type (id);



ALTER TABLE bank_account
ADD FOREIGN KEY R_88 (bank_id) REFERENCES bank (id);



ALTER TABLE event
ADD FOREIGN KEY R_91 (user_id) REFERENCES user (id);



ALTER TABLE event_action
ADD FOREIGN KEY R_98 (event_detail_id) REFERENCES event_detail (id);



ALTER TABLE event_detail
ADD FOREIGN KEY R_97 (event_id) REFERENCES event (id);



ALTER TABLE event_personal
ADD FOREIGN KEY R_89 (relationship_id) REFERENCES relationship (id);



ALTER TABLE event_personal
ADD FOREIGN KEY R_99 (event_action_id) REFERENCES event_action (id);



ALTER TABLE event_type
ADD FOREIGN KEY R_90 (event_id) REFERENCES event (id);



ALTER TABLE expenditure
ADD FOREIGN KEY R_93 (member_id) REFERENCES member (id);



ALTER TABLE expenditure
ADD FOREIGN KEY R_94 (user_id) REFERENCES user (id);



ALTER TABLE expenditure
ADD FOREIGN KEY R_96 (expenditure_type_id) REFERENCES expenditure_type (id);



ALTER TABLE expenditure_type
ADD FOREIGN KEY R_92 (category_id) REFERENCES category (id);



ALTER TABLE income
ADD FOREIGN KEY R_80 (income_type_id) REFERENCES income_type (id);



ALTER TABLE income
ADD FOREIGN KEY R_81 (user_id) REFERENCES user (id);



ALTER TABLE income
ADD FOREIGN KEY R_82 (member_id) REFERENCES member (id);



ALTER TABLE income_type
ADD FOREIGN KEY R_79 (user_id) REFERENCES user (id);



ALTER TABLE member
ADD FOREIGN KEY R_83 (relationship_id) REFERENCES relationship (id);



ALTER TABLE member
ADD FOREIGN KEY R_101 (user_id) REFERENCES user (id);



ALTER TABLE page
ADD FOREIGN KEY R_100 (banner_id) REFERENCES banner (id);



ALTER TABLE transaction
ADD FOREIGN KEY R_84 (user_id) REFERENCES user (id);



ALTER TABLE transaction
ADD FOREIGN KEY R_85 (bank_account) REFERENCES bank_account (id);



ALTER TABLE user
ADD FOREIGN KEY R_106 (role_id) REFERENCES role (id);


