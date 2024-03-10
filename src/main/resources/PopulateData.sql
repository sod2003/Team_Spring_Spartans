-- Disabling Foreign Key Constraint checks in order to truncate the tables.
SET FOREIGN_KEY_CHECKS = 0;

-- Truncating all tables
TRUNCATE spartan.customer_plan;
TRUNCATE spartan.phone_plan;
TRUNCATE spartan.phone_line;
TRUNCATE spartan.customer;
TRUNCATE spartan.device;
TRUNCATE spartan.user;

-- Enabling Foreign Key Constraint checks so that MySQL will operate normally.
SET FOREIGN_KEY_CHECKS = 1;

-- Populating tables with fresh test data
INSERT INTO spartan.customer (name, address, email, archived)
VALUES
("Sean", "123 Peachtree Street", "sean@spartanwireless.com", 0),
("Matt", "456 Peachtree Road", "matt@spartanwireless.com", 0), 
("Carlos", "789 Peachtree Avenue", "carlos@spartanwireless.com", 0),
("Sam", "1010 Piedmont Street", "sam@spartanwireless.com", 0);

INSERT INTO spartan.phone_plan (cost, data_limit, phone_lines, phone_plan_id)
VALUES
(50.99, 5, 1, 1),
(79.99, 10, 2, 2),
(99.99, 25, 3, 3);

INSERT INTO spartan.device (price, brand, name)
VALUES
(899.99, "Apple", "iPhone X"),
(999.99, "Apple", "iPhone X Plus"),
(799.99, "Samsung", "Galaxy S20");

INSERT INTO spartan.customer_plan ()
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 1);

INSERT INTO spartan.phone_line ()
VALUES
(1, 3, "678-867-5309"),
(2, 1, "678-867-5308"),
(3, 2, "678-867-5310"),
(3, 2, "678-867-5311"),
(4, 1, "678-867-5312");

INSERT INTO spartan.user ()
VALUES
(1, "seanone", "sean"),
(3, "carlostwo", "carlos"),
(4, "samthree", "sam");