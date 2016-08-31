insert into TOPCATEGORY (topcategory_id, title) values(seq_topcategory.nextval, '상의');
insert into TOPCATEGORY (topcategory_id, title) values(seq_topcategory.nextval, '하의');
insert into TOPCATEGORY (topcategory_id, title) values(seq_topcategory.nextval, '액세서리');
insert into TOPCATEGORY (topcategory_id, title) values(seq_topcategory.nextval, '신발');

commit;

select * from topcategory;

insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,1,'셔츠');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,1,'니트');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,1,'코트');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,1,'점퍼');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,2,'청바지');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,2,'면바지');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,2,'반바지');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,2,'치마');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,3,'시계');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,3,'팔찌');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,3,'귀걸이');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,3,'지갑');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,4,'운동화');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,4,'구두');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,4,'샌들');
insert into subcategory (subcategory_id, topcategory_id, title) values(seq_subcategory.nextval,4,'슬리퍼');

commit;

select * from subcategory;

insert into promotion (promotion_id, title) values(seq_promotion.nextval,'신상품');
insert into promotion (promotion_id, title) values(seq_promotion.nextval,'계절상품');
insert into promotion (promotion_id, title) values(seq_promotion.nextval,'MD추천상품');
insert into promotion (promotion_id, title) values(seq_promotion.nextval,'인기상품');

select * from promotion;

