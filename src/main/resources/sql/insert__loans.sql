INSERT
INTO `dvbank`.`loans`(
		loan_type, total_loan, paid_amount, outstanding_amount, customer_id,
		`start_date`, created_date
	)
VALUES(
	'Home', 200000, 50000, 150000, 1,
    '2020-10-13', '2020-10-13'
);

INSERT
INTO `dvbank`.`loans`(
		loan_type, outstanding_amount, paid_amount, total_loan, customer_id,
		`start_date`, created_date
	)
VALUES(
	'Vehicle', 40000, 10000, 30000, 1,
    '2020-06-06', '2020-06-06'
);

INSERT
INTO `dvbank`.`loans`(
		loan_type, outstanding_amount, paid_amount, total_loan, customer_id,
		`start_date`, created_date
	)
VALUES(
	'Home', 50000, 10000, 40000, 1,
    '2018-02-14', '2018-02-14'
);

INSERT
INTO `dvbank`.`loans`(
		loan_type, outstanding_amount, paid_amount, total_loan, customer_id,
		`start_date`, created_date
	)
VALUES(
	'Personal', 10000, 3500, 6500, 1,
    '2018-02-14', '2018-02-14'
);