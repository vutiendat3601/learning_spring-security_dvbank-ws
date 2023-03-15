INSERT
INTO `dvbank`.`account_transactions`(
	transaction_id,  created_date, transaction_date,
    transaction_amount, closing_balance, transaction_summary, transaction_type,
    account_number, customer_id
)
VALUES(
	uuid(), current_timestamp() - 6, current_timestamp() - 6,
    30, 34500, 'Coffee Shop', 'Withdrawal',
    186576453434, 1
);

INSERT
INTO `dvbank`.`account_transactions`(
	transaction_id,  created_date, transaction_date,
    transaction_amount, closing_balance, transaction_summary, transaction_type,
    account_number, customer_id
)
VALUES(
	uuid(), current_timestamp() - 5, current_timestamp() - 5,
    100, 34400, 'Uber', 'Withdrawal',
    186576453434, 1
);

INSERT
INTO `dvbank`.`account_transactions`(
	transaction_id,  created_date, transaction_date,
    transaction_amount, closing_balance, transaction_summary, transaction_type,
    account_number, customer_id
)
VALUES(
	uuid(), current_timestamp() - 4, current_timestamp() - 4,
    500, 34900, 'Self Deposit', 'Deposit',
    186576453434, 1
);

INSERT
INTO `dvbank`.`account_transactions`(
	transaction_id,  created_date, transaction_date,
    transaction_amount, closing_balance, transaction_summary, transaction_type,
    account_number, customer_id
)
VALUES(
	uuid(), current_timestamp() - 3, current_timestamp() - 3,
    600, 34300, 'Ebay', 'Withdrawal',
    186576453434, 1
);

INSERT
INTO `dvbank`.`account_transactions`(
	transaction_id,  created_date, transaction_date,
    transaction_amount, closing_balance, transaction_summary, transaction_type,
    account_number, customer_id
)
VALUES(
	uuid(), current_timestamp() - 2, current_timestamp() - 2,
    700, 35000, 'Online Transfer', 'Deposit',
    186576453434, 1
);

INSERT
INTO `dvbank`.`account_transactions`(
	transaction_id,  created_date, transaction_date,
    transaction_amount, closing_balance, transaction_summary, transaction_type,
    account_number, customer_id
)
VALUES(
	uuid(), current_timestamp() - 1, current_timestamp() - 1,
    100, 34900, 'Amazon.com', 'Withdrawal',
    186576453434, 1
);