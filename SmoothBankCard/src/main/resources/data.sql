DROP TABLE IF EXISTS card;
DROP TABLE IF EXISTS cardType;
DROP TABLE IF EXISTS loan;
DROP TABLE IF EXISTS loanType;


create table cardType(
	id int primary key,
    title VARCHAR(45),
    description varchar(255),
    rate decimal
);

create table card(
	id BIGINT primary key,
    csv int,
    balance decimal,
    cashback decimal,
    expiration_month int,
    expiration_year int,
    holder_name varchar(45),
	card_type int,
    foreign key (card_type) references cardType(id)
);

create table loanType(
	id INT primary key,
    title VARCHAR(45),
    description VARCHAR(255),
    rate DECIMAL
);

create table loan(
	id INT primary key,
    balance DECIMAL,
    loan_type int,
    foreign key (loan_type) references loanType(id)
);

insert into cardType (id, title, description, rate) values 
(1, 'Debit card', 'A general use debit card. Transactions withdraw funds from account immediately.', 0.00),
(2, 'Promo credit card', 'A promotional credit card available to accounts within 6 months of creation.', 0.05);

insert into card (id, csv, balance, cashback, expiration_month, expiration_year, holder_name, card_type) values
(6507016719651110, 940, 0.00, 0.00, 8, 2025, 'John Appleseed', 1),
(6011635835271575, 960, 0.00, 0.00, 2, 2024, 'Abbatha Road', 2),
(43210008765432104, 545, 0.00, 0.00, 3, 2024, 'Cate Dupli', 1);

insert into loanType (id, title, description, rate) values
(1, 'Promotional loan', 'A promotional loan for new accounts with a low rate', 0.03),
(2, 'VIP Loan','A loan given only to premier members', 0.00),
(3, 'Standard Loan', 'One of our more poular loans', 0.05);