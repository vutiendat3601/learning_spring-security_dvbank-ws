INSERT INTO `dvbank`.`notices` (
    notice_summary, 
    notice_details,
    begin_date, end_date, created_date, updated_date
)
VALUES (
    'Home Loan Interest rates reduced', 
    'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately',
    current_timestamp() - INTERVAL 30 DAY, current_timestamp() + INTERVAL 30 DAY, current_timestamp(), current_timestamp()
);

INSERT INTO `dvbank`.`notices` (
    notice_summary, 
    notice_details,
    begin_date, end_date, created_date, updated_date
)
VALUES (
    'Net Banking Offers', 
    'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
    current_timestamp() - INTERVAL 30 DAY, current_timestamp() + INTERVAL 30 DAY, current_timestamp(), current_timestamp()
);

INSERT INTO `dvbank`.`notices` (
    notice_summary, 
    notice_details,
    begin_date, end_date, created_date, updated_date
)
VALUES (
    'Mobile App Downtime', 
    'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
    current_timestamp() - INTERVAL 30 DAY, current_timestamp() + INTERVAL 30 DAY, current_timestamp(), current_timestamp()
);

INSERT INTO `dvbank`.`notices` (
    notice_summary, 
    notice_details,
    begin_date, end_date, created_date, updated_date
)
VALUES (
    'E Auction notice', 
    'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
    current_timestamp() - INTERVAL 30 DAY, current_timestamp() + INTERVAL 30 DAY, current_timestamp(), current_timestamp()
);

INSERT INTO `dvbank`.`notices` (
    notice_summary, 
    notice_details,
    begin_date, end_date, created_date, updated_date
)
VALUES (
    'Launch of Millennia Cards', 
    'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase',
    current_timestamp() - INTERVAL 30 DAY, current_timestamp() + INTERVAL 30 DAY, current_timestamp(), current_timestamp()
);

INSERT INTO `dvbank`.`notices` (
    notice_summary, 
    notice_details,
    begin_date, end_date, created_date, updated_date
)
VALUES (
    'COVID-19 Insurance', 
    'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
    current_timestamp() - INTERVAL 30 DAY, current_timestamp() + INTERVAL 30 DAY, current_timestamp(), current_timestamp()
);