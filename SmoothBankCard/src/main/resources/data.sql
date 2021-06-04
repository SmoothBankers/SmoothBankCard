DROP TABLE IF EXISTS cardRecord;
DROP TABLE IF EXISTS loanRecord;

DROP TABLE IF EXISTS holder;

DROP TABLE IF EXISTS card;
DROP TABLE IF EXISTS cardType;

DROP TABLE IF EXISTS loan;
DROP TABLE IF EXISTS loanType;

CREATE TABLE holder (
    id INT PRIMARY KEY,
    holder_name VARCHAR(127),
    home_phone VARCHAR(10),
    cell_phone VARCHAR(10),
    work_phone VARCHAR(14),
    email VARCHAR(127),
    ssn VARCHAR(10),
    address VARCHAR(127),
    zipcode INT,
    monthly_income INT
);

CREATE TABLE cardType (
    id INT PRIMARY KEY,
    title VARCHAR(45),
    description VARCHAR(255),
    rate DECIMAL
);

CREATE TABLE card (
    id BIGINT PRIMARY KEY,
    csv INT,
    balance DECIMAL,
    cashback DECIMAL,
    expiration_month INT,
    expiration_year INT,
    holder_name VARCHAR(45),
    card_type INT,
    FOREIGN KEY (card_type)
        REFERENCES cardType (id)
);

CREATE TABLE loanType (
    id INT PRIMARY KEY,
    title VARCHAR(45),
    description VARCHAR(255),
    rate DECIMAL
);

CREATE TABLE loan (
    id BIGINT PRIMARY KEY,
    balance DECIMAL,
    loan_type INT,
    FOREIGN KEY (loan_type)
        REFERENCES loanType (id),
    holder_name VARCHAR(45)
);

CREATE TABLE loanRecord (
    holder_id INT,
    loan_id INT,
    id INT PRIMARY KEY,
    FOREIGN KEY (holder_id)
        REFERENCES holder (id),
    FOREIGN KEY (loan_id)
        REFERENCES loan (id)
);
CREATE TABLE cardRecord (
    holder_id INT,
    card_id BIGINT,
    id INT PRIMARY KEY,
    FOREIGN KEY (holder_id)
        REFERENCES holder (id),
    FOREIGN KEY (card_id)
        REFERENCES card (id)
);

insert into cardType (id, title, description, rate) values 
(1, 'Debit card', 'A general use debit card. Transactions withdraw funds from account immediately.', 0.00),
(2, 'Promo credit card', 'A promotional credit card available to accounts within 6 months of creation.', 0.05);

insert into card (id, csv, balance, cashback, expiration_month, expiration_year, holder_name, card_type) values
(6507016719651110, 940, 0.00, 0.00, 8, 2025, 'John Appleseed', 1),
(6011635835271575, 960, 0.00, 0.00, 2, 2024, 'Abbatha Road', 2),
(43210008765432104, 545, 0.00, 0.00, 3, 2024, 'Cate Dupli', 1);

insert into loanType (id, title, description, rate) values
(1, 'Personal Loan', 'A loan for your personal needs, from an unexpected bill to helping pay for that vacation you always wanted.', 10.50),
(2, 'Home Loan','Need help with buying your dream home? This loan can help with that.', 15.00),
(3, 'Business Loan', 'Give your startup business a boost with one of our loans.', 12.50);

insert into loan (id, balance, loan_type, holder_name) values
(43210008765432104, 0.00, 1, 'Owen L. Holden');