INSERT 
INTO `dvbank`.`customers`(
        created_date, email, mobile_number, 
        `role`, `name`,
        pwd
    )
VALUES(
	current_timestamp(), 'vutien.dat.3601@gmail.com', '0898993601', 
    'Vu Tien Dat', 'ROLE_ADMIN',
    '$2a$12$7pSVJr89FTNQRQMw6mKinOT/BvXazfbEOoyo2Agwcy4thmkLimEv2'
);