
/*회원 테이블 및 시퀀스*/

create sequence system.usertb_seq increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

create table usertb(usertbid int primary key, u_id varchar2(500) unique, pw varchar2(500) not null, 
uname varchar2(500) not null, email varchar2(500) not null, q varchar2(200) not null, 
a varchar2(200) not null, add1 varchar2(100) not null, add2 varchar2(200) not null, 
regdate date default sysdate, cp int default 0);

insert into usertb values (usertb_seq.nextval, 'kwa1032', 'qwerasdf', '홍길동', 'hong@naver.com', 
'태어난 곳은?', '병원', '10446', '고양시 일산동구', sysdate, 0)

/*관리자용 판매 테이블 및 시퀀스*/

create sequence system.sales_seq increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

create table sales(salesid int primary key, scode varchar2(30) unique, cnt int not null, 
price int not null, dc decimal default 0, pay int not null);

insert into sales values (sales_seq.nextval, 'A001', 30, 9800, 0.8, 235200)

/*쿠폰 테이블 및 시퀀스*/

create sequence system.coupon_seq increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

create table coupon(couponid int primary key, ccode varchar2(30) unique, cname varchar2(500) not null, 
dc decimal not null, use varchar2(10) default 'no');

insert into coupon values (coupon_seq.nextval, 'A02', '설날기념', '0.9', 'no')

/*쿠폰발급내역 테이블 및 시퀀스*/

create sequence system.issuecoupon_seq increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

create table issuecoupon (issuecouponid int primary key, icode varchar2(30) unique, iname varchar2(500) not null, 
dc decimal not null, use varchar2(10) default 'no', holder varchar2(500) not null, receivedate date default sysdate)

insert into issuecoupon values (issuecoupon_seq.nextval, 'A001', '크리스마스쿠폰', '0.9', 'no', 'kwak12', sysdate)

/* 고객센터 테이블 및 시퀀스 */
create sequence system.qna_seq increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

create table qna (qnaid int primary key, tit varchar2(200) not null, 
con varchar2(500) not null, author varchar2(500) not null,
pw int not null, regdate date default sysdate);

insert into qna values (qna_seq.nextval, '안녕하세요', '내용1', 'hong11', 1234, sysdate)

/*제품목록 테이블 및 시퀀스*/

create sequence system.prolist_seq increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

create table prolist (prolistid int primary key, pcode varchar2(30) unique, pname varchar2(500) not null, 
nat varchar2(500) not null, genre varchar2(500) not null,
price int not null, img varchar2(500), cnt int default 0);

/* 국내 소설 */
insert into prolist values(prolist_seq.nextval, 'A001', '불편한 편의점', '국내', '소설', '18900', './img/a001.jpg', 40);
insert into prolist values(prolist_seq.nextval, 'A002', '한밤의 도서관', '국내', '소설', '18900', './img/a002.jpg', 30);
insert into prolist values(prolist_seq.nextval, 'A003', '달리구트 꿈 백화점 1', '국내', '소설', '18900', './img/a003.jpg', 43);
insert into prolist values(prolist_seq.nextval, 'A004', '달리구트 꿈 백화점 2', '국내', '소설', '18900', './img/a004.jpg', 67)

/* 해외 소설 */
insert into prolist values(prolist_seq.nextval, 'B001', 'Mango Street', '해외', '소설', '15900', './img/b001.jpg',14);
insert into prolist values(prolist_seq.nextval, 'B002', 'MidNight Library', '해외', '소설', '19900', './img/b002.jpg',39);
insert into prolist values(prolist_seq.nextval, 'B003', 'Wonder', '해외', '소설', '15900', './img/b003.jpg',5);
insert into prolist values(prolist_seq.nextval, 'B004', 'Morrie', '해외', '소설', '15900', './img/b004.jpg',56)

/* 해외 아동 */
insert into prolist values(prolist_seq.nextval, 'C001', 'Bricks Reading 50', '해외', '아동', '8900', './img/c001.jpg',10);
insert into prolist values(prolist_seq.nextval, 'C002', 'Smart Phonics 1', '해외', '아동', '11900', './img/c002.jpg',23);
insert into prolist values(prolist_seq.nextval, 'C003', 'Smart Phonics 1', '해외', '아동', '7900', './img/c003.jpg',31);
insert into prolist values(prolist_seq.nextval, 'C004', 'Bricks Reading 150', '해외', '아동', '10900', './img/c004.jpg',22)

/* 국내 아동 */
insert into prolist values(prolist_seq.nextval, 'D001', '전래동화 50선', '국내', '아동', '12900', './img/d001.jpg',11);
insert into prolist values(prolist_seq.nextval, 'D002', '엔칸토 마법의 세계', '국내', '아동', '13900', './img/d002.jpg',29);
insert into prolist values(prolist_seq.nextval, 'D003', '소울', '국내',  '아동', '13900', './img/d003.jpg',22);
insert into prolist values(prolist_seq.nextval, 'D004', '읽기 떼는 동화', '국내', '아동', '8900', './img/d004.jpg',56)


/* 결제 테이블 및 시퀀스*/

create sequence system.buy_seq increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

create table buy (buyid int primary key, bcode varchar2(30) unique, buyer varchar2(500) not null, 
email varchar2(500) not null, tel varchar2(500) not null, add1 varchar2(100) not null, 
add2 varchar2(200) not null, add3 varchar2(300) not null, note varchar2(500), 
bitem varchar2(500) not null, bitemid int not null, cnt int not null, amount int not null, cpuse varchar2(10) default 'no',
paytype varchar2(200) not null, payprop varchar2(200) not null);

insert into buy values(buy_seq.nextval, 'A001', 'kks123', 'asd@naver.com', '01023435531', 
'10334', '백석로 26', '3단지 111호', '문앞에 놔주세요', '셜록홈즈', 1, 1, 19000, 'no', '신용카드', '189343-02-422579');

/* 장바구니 테이블 및 시퀀스 */

create sequence system.orderbasket_seq increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

create table orderbasket (orderbasketid int primary key, ocode varchar2(30) unique, throwerid int not null,
oitem varchar2(500) not null, oitemid int not null, cnt int not null, validity int default 1);

/* 답변형 게시판 테이블 및 시퀀스 */

create sequence system.re_seq increment by 1 start with 1 minvalue 1 maxvalue 999999 nocycle nocache;

CREATE TABLE board(
  board_num NUMBER NOT NULL PRIMARY KEY,
  board_id VARCHAR2(50),
  board_subject VARCHAR2(100),
  board_content VARCHAR2(2000),
  board_file VARCHAR2(100),
  board_re_ref NUMBER,
  board_re_lev NUMBER,
  board_re_seq NUMBER,
  board_count NUMBER,
  board_date DATE
);

insert into board values (re_seq.nextval, 'admin', '안녕하세요', '테스트내용', '경로1', 1, 1, 1, 0, sysdate)

select * from (select rownum rnum, board_num, board_id, board_subject, board_content, board_file, 
board_re_ref, board_re_lev, board_re_seq, board_count, board_date 
from (select * from board order by board_re_ref desc, board_re_seq asc )) where rnum>=1 and rnum<=10

commit