--shoppingmall DDL!!

create tablespace shopping
datafile 'C:\oraclexe\app\oracle\oradata\shopping.dbf'
size 2m;

--create user
create user shop
identified by shop
default TABLESPACE shopping
quota UNLIMITED on shopping;

--grant
grant create session, create table, create sequence to shop; 

create table promotion (
promotion_id number primary key
, title varchar2(30)
);
create SEQUENCE seq_promotion
increment by 1
start with 1;

create table topcategory(
topcategory_id number primary key
, title varchar2(20)
);
create SEQUENCE seq_topcategory
increment by 1
start with 1;

create table subcategory(
subcategory_id number primary key
, topcategory_id number
, title varchar2(30)
);
create SEQUENCE seq_subcategory
increment by 1
start with 1;

create table promotion_product(
promotion_product_id number primary key
, product_id number --which product
, promotion_id number -- which promotion
);
create SEQUENCE seq_promotion_product
increment by 1
start with 1;

create table product(
product_id number primary key
, subcategory_id number
, product_name varchar2(30)
, price number default 0
, stock number default 0
, img varchar2(20)
, detail clob -- mysql, mariadb(similar as text)
);
create SEQUENCE seq_product
increment by 1
start with 1;




