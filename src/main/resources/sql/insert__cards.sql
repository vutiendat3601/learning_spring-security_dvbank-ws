INSERT INTO `dvbank`.`cards`(
	`card_number`, `customer_id`, `card_type`, `created_date`, 
	 `total_limit`, `used_amount`, `available_amount`
)
VALUES (
    '4565XXXX4656', 1, 'Credit', current_timestamp(),
    10000, 500, 9500
);

INSERT INTO `dvbank`.`cards`(
	`card_number`, `customer_id`, `card_type`, `created_date`,
    `total_limit`, `used_amount`, `available_amount`
)
VALUES (
	'3455XXXX8673', 1, 'Credit', current_timestamp(),
    7500, 600, 6900
);

INSERT INTO `dvbank`.`cards`(
	`card_number`, `customer_id`, `card_type`, `created_date`,
    `total_limit`, `used_amount`, `available_amount`
)
VALUES (
	'2359XXXX9346', 1, 'Credit', current_timestamp(),
    20000, 4000, 16000
);