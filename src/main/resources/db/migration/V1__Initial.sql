CREATE TABLE BRANDS
(
    ID          INT PRIMARY KEY,
    DESCRIPTION VARCHAR(45)
);

INSERT INTO BRANDS (ID, DESCRIPTION)
VALUES (1, 'ZARA');


CREATE TABLE PRICES
(
    ID         INT AUTO_INCREMENT PRIMARY KEY,
    BRAND_ID   INT,
    START_DATE TIMESTAMP,
    END_DATE   TIMESTAMP,
    PRICE_LIST INT,
    PRODUCT_ID INT,
    PRIORITY   INT,
    PRICE      NUMERIC,
    CURR       VARCHAR(3)
);

ALTER TABLE PRICES
    ADD CONSTRAINT PRICES_BRAND_FK
        FOREIGN KEY (BRAND_ID) REFERENCES BRANDS;

INSERT INTO PRICES (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES (1,
        to_timestamp('14/06/20 00:00:00,000000000', 'DD/MM/RR HH24:MI:SSXFF'),
        to_timestamp('31/12/20 23:59:59,000000000', 'DD/MM/RR HH24:MI:SSXFF'),
        1,
        35455,
        0,
        '35.50',
        'EUR');
INSERT INTO PRICES (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES (1,
        to_timestamp('14/06/20 15:00:00,000000000', 'DD/MM/RR HH24:MI:SSXFF'),
        to_timestamp('14/06/20 18:30:00,000000000', 'DD/MM/RR HH24:MI:SSXFF'),
        2,
        35455,
        1,
        '25.45',
        'EUR');

INSERT INTO PRICES (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES (1,
        to_timestamp('15/06/20 00:00:00,000000000', 'DD/MM/RR HH24:MI:SSXFF'),
        to_timestamp('15/06/20 11:00:00,000000000', 'DD/MM/RR HH24:MI:SSXFF'),
        3,
        35455,
        1,
        '30.50',
        'EUR');

INSERT INTO PRICES (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES (1,
        to_timestamp('15/06/20 16:00:00,000000000', 'DD/MM/RR HH24:MI:SSXFF'),
        to_timestamp('31/12/20 23:59:59,000000000', 'DD/MM/RR HH24:MI:SSXFF'),
        4,
        35455,
        1,
        '38.95',
        'EUR');

