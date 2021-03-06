-- DROP TABLE
-- If tables do not exist, this part should be excluded.
DROP TABLE TBL_EMPLOYEE CASCADE CONSTRAINTS;
DROP TABLE TBL_DEPARTMENT CASCADE CONSTRAINTS;
DROP TABLE TBL_POSITION CASCADE CONSTRAINTS;
DROP TABLE TBL_DIVISION CASCADE CONSTRAINTS;
DROP TABLE TBL_REGION CASCADE CONSTRAINTS;
DROP TABLE FREE_BOARD;
DROP TABLE MEMBER;

-- CREATE TABLE
CREATE TABLE TBL_REGION
(
    REGION_ID   VARCHAR2(3) PRIMARY KEY,
    REGION_INFO VARCHAR2(30)
);
COMMENT ON COLUMN TBL_REGION.REGION_ID IS '근무지역 코드';
COMMENT ON COLUMN TBL_REGION.REGION_INFO IS '근무지역 정보';

CREATE TABLE TBL_DIVISION
(
    DIVISION_ID   VARCHAR2(3) PRIMARY KEY,
    DIVISION_NAME VARCHAR2(40)
);
COMMENT ON COLUMN TBL_DIVISION.DIVISION_ID IS '사업본부 코드';
COMMENT ON COLUMN TBL_DIVISION.DIVISION_NAME IS '사업본부 이름';

CREATE TABLE TBL_DEPARTMENT
(
    DEPT_ID     VARCHAR2(3) PRIMARY KEY,
    DEPT_NAME   VARCHAR2(40),
    DIVISION_ID VARCHAR2(3) REFERENCES TBL_DIVISION,
    REGION_ID   VARCHAR2(3) REFERENCES TBL_REGION
);
COMMENT ON COLUMN TBL_DEPARTMENT.DEPT_ID IS '팀 코드';
COMMENT ON COLUMN TBL_DEPARTMENT.DEPT_NAME IS '팀 이름';
COMMENT ON COLUMN TBL_DEPARTMENT.DIVISION_ID IS '사업본부 코드';
COMMENT ON COLUMN TBL_DEPARTMENT.REGION_ID IS '근무지역 코드';

CREATE TABLE TBL_POSITION
(
    POSITION_ID         VARCHAR2(3) PRIMARY KEY,
    POSITION_NAME       VARCHAR2(40),
    PROMOTION_CONDITION NUMBER
);
COMMENT ON COLUMN TBL_POSITION.POSITION_ID IS '직급 코드';
COMMENT ON COLUMN TBL_POSITION.POSITION_NAME IS '직급 이름';
COMMENT ON COLUMN TBL_POSITION.PROMOTION_CONDITION IS '승진필요 근무년수';

CREATE TABLE TBL_EMPLOYEE
(
    EMP_NO           NUMBER PRIMARY KEY,
    EMP_NAME         VARCHAR2(30),
    EMP_DEPTID       VARCHAR2(3) REFERENCES TBL_DEPARTMENT,
    EMP_HIREDATE     DATE,
    EMP_POSITION     VARCHAR2(3) REFERENCES TBL_POSITION,
    EMP_ANNUALSALARY NUMBER
);
COMMENT ON COLUMN TBL_EMPLOYEE.EMP_NO IS '사번';
COMMENT ON COLUMN TBL_EMPLOYEE.EMP_NAME IS '이름';
COMMENT ON COLUMN TBL_EMPLOYEE.EMP_DEPTID IS '소속팀 코드';
COMMENT ON COLUMN TBL_EMPLOYEE.EMP_HIREDATE IS '입사일';
COMMENT ON COLUMN TBL_EMPLOYEE.EMP_POSITION IS '직급 코드';
COMMENT ON COLUMN TBL_EMPLOYEE.EMP_ANNUALSALARY IS '연봉';

CREATE TABLE MEMBER
(
    MEMBER_ID   VARCHAR2(20) PRIMARY KEY,
    MEMBER_PW   VARCHAR2(15),
    MEMBER_NAME VARCHAR2(20)
);

CREATE TABLE FREE_BOARD
(
    ID         NUMBER PRIMARY KEY,
    CONTENT    VARCHAR2(2000),
    WRITER_ID  VARCHAR2(20),
    WRITE_DATE DATE
);

-- INSERT DATA
INSERT INTO TBL_REGION
VALUES ('D01', '서울-프라임');
INSERT INTO TBL_REGION
VALUES ('D02', '서울-상암');
INSERT INTO TBL_REGION
VALUES ('D03', '서울-가산');
INSERT INTO TBL_REGION
VALUES ('D04', '서울-파이낸스');
INSERT INTO TBL_REGION
VALUES ('D05', '부평');
INSERT INTO TBL_REGION
VALUES ('D06', '대전');
INSERT INTO TBL_REGION
VALUES ('F01', '중국법인');
INSERT INTO TBL_REGION
VALUES ('F02', '일본법인');
INSERT INTO TBL_REGION
VALUES ('F03', '미주법인');
INSERT INTO TBL_REGION
VALUES ('F04', '인도법인');
INSERT INTO TBL_REGION
VALUES ('F05', '인도네시아법인');
INSERT INTO TBL_REGION
VALUES ('F06', '유럽법인');
INSERT INTO TBL_REGION
VALUES ('F07', '브라질법인');
INSERT INTO TBL_REGION
VALUES ('F08', '중동지사');

INSERT INTO TBL_DIVISION
VALUES ('DV1', '공공/SGT사업본부');
INSERT INTO TBL_DIVISION
VALUES ('DV2', '금융/통신사업본부');
INSERT INTO TBL_DIVISION
VALUES ('DV3', '솔루션사업본부');
INSERT INTO TBL_DIVISION
VALUES ('DV4', '하이테크사업본부');
INSERT INTO TBL_DIVISION
VALUES ('DV5', '글로벌전략본부');

INSERT INTO TBL_POSITION
VALUES ('P01', '사원', 3);
INSERT INTO TBL_POSITION
VALUES ('P02', '대리', 5);
INSERT INTO TBL_POSITION
VALUES ('P03', '과장', 5);
INSERT INTO TBL_POSITION
VALUES ('P04', '차장', 3);
INSERT INTO TBL_POSITION
VALUES ('P05', '부장', NULL);
INSERT INTO TBL_POSITION
VALUES ('P06', '연구원', NULL);
INSERT INTO TBL_POSITION
VALUES ('P07', '전임컨설턴트', 3);
INSERT INTO TBL_POSITION
VALUES ('P08', '선임컨설턴트', 5);
INSERT INTO TBL_POSITION
VALUES ('P09', '책임컨설턴트', 5);
INSERT INTO TBL_POSITION
VALUES ('P10', '총괄컨설턴트', NULL);
INSERT INTO TBL_POSITION
VALUES ('P99', '임원', NULL);
INSERT INTO TBL_POSITION
VALUES ('P00', '인턴', NULL);

INSERT INTO TBL_DEPARTMENT
VALUES ('T01', '공공사업팀', 'DV1', 'D01');
INSERT INTO TBL_DEPARTMENT
VALUES ('T02', '금융사업팀', 'DV2', 'D01');
INSERT INTO TBL_DEPARTMENT
VALUES ('T03', '통신서비스팀', 'DV3', 'D01');
INSERT INTO TBL_DEPARTMENT
VALUES ('T04', '연구개발팀', 'DV3', 'D01');
INSERT INTO TBL_DEPARTMENT
VALUES ('T05', '솔루션개발팀', 'DV3', 'D01');
INSERT INTO TBL_DEPARTMENT
VALUES ('T06', '컨설팅팀', 'DV3', 'D04');
INSERT INTO TBL_DEPARTMENT
VALUES ('T07', '모바일개발팀', 'DV4', 'D01');
INSERT INTO TBL_DEPARTMENT
VALUES ('T08', '아키텍처팀', 'DV3', 'D03');
INSERT INTO TBL_DEPARTMENT
VALUES ('T09', '글로벌영업1팀', NULL, 'F03');
INSERT INTO TBL_DEPARTMENT
VALUES ('T10', '글로벌영업2팀', NULL, 'F06');
INSERT INTO TBL_DEPARTMENT
VALUES ('T11', '글로벌영업3팀', NULL, 'F02');
INSERT INTO TBL_DEPARTMENT
VALUES ('T12', '글로벌영업4팀', NULL, 'F07');

INSERT INTO TBL_EMPLOYEE
VALUES (84553, '한요주', 'T01', TO_DATE('2011/01/01', 'YYYY/MM/DD'), 'P02', 50000000);
INSERT INTO TBL_EMPLOYEE
VALUES (86952, '김히선', 'T12', TO_DATE('2011/07/01', 'YYYY/MM/DD'), 'P05', 65000000);
INSERT INTO TBL_EMPLOYEE
VALUES (74286, '한애슬', 'T08', TO_DATE('2010/01/01', 'YYYY/MM/DD'), 'P02', 50000000);
INSERT INTO TBL_EMPLOYEE
VALUES (69124, '김화늘', 'T04', TO_DATE('2009/01/01', 'YYYY/MM/DD'), 'P03', 55000000);
INSERT INTO TBL_EMPLOYEE
VALUES (65293, '손중기', 'T09', TO_DATE('2009/05/01', 'YYYY/MM/DD'), 'P01', 40000000);
INSERT INTO TBL_EMPLOYEE
VALUES (86112, '박우천', 'T12', TO_DATE('2011/07/01', 'YYYY/MM/DD'), 'P01', 40000000);
INSERT INTO TBL_EMPLOYEE
VALUES (91879, '김슈헌', 'T03', TO_DATE('2013/01/01', 'YYYY/MM/DD'), 'P01', 40000000);
INSERT INTO TBL_EMPLOYEE
VALUES (81569, '문채언', 'T10', TO_DATE('2011/01/01', 'YYYY/MM/DD'), 'P01', 40000000);
INSERT INTO TBL_EMPLOYEE
VALUES (82564, '원뷘', 'T07', TO_DATE('2011/01/01', 'YYYY/MM/DD'), 'P03', 58000000);
INSERT INTO TBL_EMPLOYEE
VALUES (82698, '전지헌', 'T02', TO_DATE('2011/01/01', 'YYYY/MM/DD'), 'P04', 60000000);
INSERT INTO TBL_EMPLOYEE
VALUES (83667, '성해교', 'T05', TO_DATE('2009/07/01', 'YYYY/MM/DD'), 'P07', 40000000);
INSERT INTO TBL_EMPLOYEE
VALUES (80529, '하지언', 'T06', TO_DATE('2008/01/01', 'YYYY/MM/DD'), 'P08', 50000000);
INSERT INTO TBL_EMPLOYEE
VALUES (79898, '이민졍', 'T01', TO_DATE('2010/07/01', 'YYYY/MM/DD'), 'P01', 40000000);
INSERT INTO TBL_EMPLOYEE
VALUES (73968, '김해수', 'T05', TO_DATE('2010/01/01', 'YYYY/MM/DD'), 'P05', 65000000);
INSERT INTO TBL_EMPLOYEE
VALUES (79836, '이벙헌', 'T09', TO_DATE('2007/07/01', 'YYYY/MM/DD'), 'P10', 70000000);
INSERT INTO TBL_EMPLOYEE
VALUES (75487, '윤은해', 'T03', TO_DATE('2010/01/01', 'YYYY/MM/DD'), 'P02', 50000000);
INSERT INTO TBL_EMPLOYEE
VALUES (90857, '장돈건', 'T02', TO_DATE('2012/07/01', 'YYYY/MM/DD'), 'P03', 55000000);
INSERT INTO TBL_EMPLOYEE
VALUES (89969, '김하중', 'T10', TO_DATE('2010/01/01', 'YYYY/MM/DD'), 'P06', 40000000);
INSERT INTO TBL_EMPLOYEE
VALUES (86415, '현뷘', NULL, TO_DATE('2011/07/01', 'YYYY/MM/DD'), 'P00', 50000000);
INSERT INTO TBL_EMPLOYEE
VALUES (72451, '김태히', 'T08', TO_DATE('2008/01/01', 'YYYY/MM/DD'), 'P09', 60000000);
INSERT INTO TBL_EMPLOYEE
VALUES (77858, '소지섬', 'T07', TO_DATE('2011/03/01', 'YYYY/MM/DD'), 'P02', 50000000);
INSERT INTO TBL_EMPLOYEE
VALUES (91580, '유승오', 'T03', TO_DATE('2013/01/01', 'YYYY/MM/DD'), NULL, 30000000);
INSERT INTO TBL_EMPLOYEE
VALUES (99999, '한아름송이', NULL, NULL, NULL, NULL);

INSERT INTO MEMBER(MEMBER_ID, MEMBER_PW, MEMBER_NAME)
VALUES ('test', 'test', '테스트');

INSERT INTO FREE_BOARD(ID, CONTENT, WRITER_ID, WRITE_DATE)
VALUES (1, '첫번째 내용입니다.', 'test', SYSDATE);

COMMIT;