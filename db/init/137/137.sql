ALTer table income DROP column paid_A_C;


ALTER table income ADD Column paid_ac_id int(11);

ALTER table income ADD FOREIGN KEY (paid_ac_id) REFERENCES bank_account(id);
