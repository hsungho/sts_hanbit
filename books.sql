DROP SEQUENCE book_seq;
DROP SEQUENCE customer_seq;
DROP SEQUENCE order_seq;

CREATE SEQUENCE book_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE customer_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE order_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;

DROP TABLE Book CASCADE CONSTRAINT;
DROP TABLE Customer CASCADE CONSTRAINT;
DROP TABLE Orders CASCADE CONSTRAINT;

CREATE TABLE Book(
  book_seq    INT           CONSTRAINT book_pk PRIMARY KEY,
  book_name   VARCHAR2(40)  NOT NULL,
  publisher   VARCHAR2(40)  NOT NULL,
  price       NUMBER        DEFAULT 0 NOT NULL 
);

CREATE TABLE Customer(
	customer_seq  INT CONSTRAINT customer_pk PRIMARY KEY,
	customer_name VARCHAR2(40)   NOT NULL,
    address       VARCHAR2(50)   NOT NULL,
	phone         VARCHAR2(13)   NOT NULL
);

CREATE TABLE Orders(
  order_seq    INT CONSTRAINT order_pk PRIMARY KEY,
  sale_qty     NUMBER  NOT NULL,
  customer_seq INT     NOT NULL,
  book_seq     INT     NOT NULL,
  CONSTRAINT book_order_fk FOREIGN KEY(book_seq)
	REFERENCES book(book_seq) ON DELETE CASCADE,
  CONSTRAINT customer_order_fk FOREIGN KEY(customer_seq)
	REFERENCES customer(customer_seq) ON DELETE CASCADE	
);

CREATE OR REPLACE VIEW Order_view AS
SELECT b.book_seq
      ,b.book_name
      ,b.publisher
      ,b.price
      ,c.CUSTOMER_SEQ
      ,c.customer_name
      ,c.ADDRESS
      ,c.PHONE
      ,o.ORDER_SEQ
      ,o.SALE_QTY
FROM   Book      b
      ,Customer  c
      ,Orders    o
WHERE  o.book_seq     = b.book_seq
AND    o.customer_seq = o.customer_seq   
;

