-- BOX OFFICE DDL --

 -- DROP SCHEMA boxoffice;
 CREATE SCHEMA boxoffice;
 USE boxoffice;

CREATE TABLE member(
    mno         INT AUTO_INCREMENT,
	id 	        VARCHAR(30) NOT NULL UNIQUE,
	password 	VARCHAR(30) NOT NULL,
	name        VARCHAR(30) NOT NULL,
    PRIMARY KEY (mno)
);

INSERT INTO member VALUES(0, 'test1','1234','홍길동');
INSERT INTO member VALUES(0, 'test2','1234','최길동');

SELECT * FROM member;


-- WEEKLY_BOXOFFICE : 영화정보
CREATE TABLE weekly_boxoffice(
    bno             INT AUTO_INCREMENT,
	rnum			INT,	        --	순번을 출력합니다.
	boxoffice_rank	INT,	        --	해당일자의 박스오피스 순위를 출력합니다.
	rankinten		INT,	        --	전일대비 순위의 증감분을 출력합니다.
	rankoldandnew	VARCHAR(30),	--	랭킹에 신규진입여부를 출력합니다.“OLD” : 기존 , “NEW” : 신규
	moviecd			VARCHAR(30),	--	영화의 대표코드를 출력합니다.
	movienm			VARCHAR(300),	--	영화명(국문)을 출력합니다.
	opendt			DATE,	        --	영화의 개봉일을 출력합니다.
	salesamt		BIGINT,	        --	해당일의 매출액을 출력합니다.
	salesshare		DOUBLE,	        --	해당일자 상영작의 매출총액 대비 해당 영화의 매출비율을 출력합니다.
	salesinten		BIGINT,	        --	전일 대비 매출액 증감분을 출력합니다.
	saleschange		DOUBLE,	        --	전일 대비 매출액 증감 비율을 출력합니다.
	salesacc		BIGINT,	        --	누적매출액을 출력합니다.
	audicnt			BIGINT,	        --	해당일의 관객수를 출력합니다.
	audiinten		BIGINT,	        --	전일 대비 관객수 증감분을 출력합니다.
	audichange		DOUBLE,	        --	전일 대비 관객수 증감 비율을 출력합니다.
	audiacc			BIGINT,	        --	누적관객수를 출력합니다.
	scrncnt			BIGINT,	        --	해당일자에 상영한 스크린수를 출력합니다.
	showcnt			BIGINT,	        --	해당일자에 상영된 횟수를 출력합니다.
    boxofficetype	VARCHAR(100),	--	박스오피스 종류를 출력합니다.
	showrange		VARCHAR(100),	--	대상 상영기간을 출력합니다.
	yearweektime	VARCHAR(100),	--	조회일자에 해당하는 연도와 주차를 출력합니다.(YYYYIW)
    PRIMARY KEY (bno)
);


INSERT INTO 
WEEKLY_BOXOFFICE(bno, rnum, boxoffice_rank, rankinten, rankoldandnew, moviecd, movienm,
                 opendt, salesamt, salesshare, salesinten, saleschange, salesacc,
                 audicnt, audiinten, audichange, audiacc, scrncnt, showcnt,
                 boxofficetype, showrange, yearweektime)
VALUES(0, 1, 1, 0, 'OLD', '20112207', '미션임파서블:고스트프로토콜', '20111215', 
        7840509500, 35.8, -1706758500, -17.9, 40541108500, 1007683, -234848, -18.9, 5328435,
        697, 9677, '주말 박스오피스', '20111230~20120101', '201152');

        
INSERT INTO 
WEEKLY_BOXOFFICE(bno, rnum, boxoffice_rank, rankinten, rankoldandnew, moviecd, movienm,
                 opendt, salesamt, salesshare, salesinten, saleschange, salesacc,
                 audicnt, audiinten, audichange, audiacc, scrncnt, showcnt,
                 boxofficetype, showrange, yearweektime)
        VALUES(0, 2, 2, 0, 'OLD', '20112207', '미션임파서블:고스트프로토콜2', '20111215', 
        7840509500, 35.8, -1706758500, -17.9, 40541108500, 1007683, -234848, -18.9, 5328435,
        697, 9677, '주말 박스오피스', '20111230~20120101', '201152');

-- 전체 조회
SELECT * FROM weekly_boxoffice ORDER BY boxoffice_rank;


-- 영화 이름 검색 (부분 허용)
SELECT * FROM weekly_boxoffice WHERE movienm LIKE '%프로토콜2%';


-- 영화 주간 검색 201152
SELECT * FROM weekly_boxoffice WHERE yearweektime = '201152';



-- 영화 즐겨찾기
CREATE TABLE favorite_boxoffice(
    bno             INT,
	mno             INT,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (bno, mno),
    FOREIGN KEY (bno) REFERENCES weekly_boxoffice(bno),
    FOREIGN KEY (mno) REFERENCES member(mno)
);

INSERT INTO favorite_boxoffice(bno, mno) VALUES(1, 1);
INSERT INTO favorite_boxoffice(bno, mno) VALUES(1, 2);

SELECT * FROM favorite_boxoffice WHERE mno = 1;

SELECT * FROM favorite_boxoffice, weekly_boxoffice WHERE mno = 1;


SELECT f.bno, f.mno, f.create_date, m.id, b.movienm
FROM favorite_boxoffice f
JOIN member m on (f.mno = m.mno)
JOIN weekly_boxoffice b on (b.bno = f.bno)
WHERE f.bno = 1;


SELECT COUNT(*) FROM favorite_boxoffice WHERE bno = 1;




-- 영화 리뷰 달기
CREATE TABLE review_boxoffice(
    rno             INT AUTO_INCREMENT,
    bno             INT,
	mno             INT,
    title           VARCHAR(200),
    content         TEXT,
    score           INT,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (rno),
    FOREIGN KEY (bno) REFERENCES weekly_boxoffice(bno),
    FOREIGN KEY (mno) REFERENCES member(mno)
);


INSERT INTO review_boxoffice(rno, bno, mno, title, content, score)
VALUES(0, 1, 1, '미션임파서블 보고왔습니다.', '영화관에서 봤는데, 참 재밋네요!', 5);


INSERT INTO review_boxoffice(rno, bno, mno, title, content, score)
VALUES(0, 1, 2, '미션임파서블 보다가 졸았습니다.', '영화관에서 봤는데, 시트가 참 편하네요.', 1);

SELECT * FROM review_boxoffice;



SELECT r.rno, r.bno, r.mno, r.title, r.content, r.score, r.create_date, m.id, b.movienm
FROM review_boxoffice r
JOIN member m on r.mno = m.mno
JOIN weekly_boxoffice b ON r.bno = b.bno;


SELECT b.*, m.*, r.*
FROM review_boxoffice r
JOIN member m ON r.mno = m.mno
JOIN weekly_boxoffice b ON r.bno = b.bno;



COMMIT;

SELECT * FROM weekly_boxoffice ORDER BY yearweektime, boxoffice_rank;
