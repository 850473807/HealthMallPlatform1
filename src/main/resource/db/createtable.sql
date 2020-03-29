SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `TPM_TEST_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `TPM_TEST_LOG`;
CREATE TABLE `TPM_TEST_LOG` (
  `LOG_UUID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `TESTMAIN_UUID` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `OPERATION` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `SYSCREATEDATE` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`LOG_UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS SYS_USER;
CREATE TABLE SYS_USER (
    U_ID bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    U_NAME varchar(32) not null ,
    U_NAME varchar(32) not null ,
    U_PASSWORD varchar(20) not null ,
    U_PHONE varchar(20) ,
    primary key (U_ID)
);
CREATE table category(
    c_id bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    c_name varchar(32) not null,
    primary key (c_id)
);
CREATE TABLE	product(
    p_id bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    p_category bigint(20) not null,
    p_brand bigint(20) not null,
    p_name varchar(32) not null,
    p_count bigint(20) not null,
    p_price bigint(20) not null,
    p_status varchar(1),
    p_detail varchar(128),
    p_img varchar(128) not null,
    p_sales bigint(20),
    primary key (p_id)
);

CREATE TABLE brand(
    b_id bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    b_name varchar(32) not null,
    primary key (b_id)
);

CREATE TABLE appraisal(
    u_id bigint(20) not null,
    p_id bigint(20) not null,
    a_time date,
    a_detail varchar(128) not null,
    a_level varchar(1),
    primary key (u_id,p_id)
);

CREATE TABLE	product_detail(
    p_id bigint(20)  NOT NULL,
    p_bigImg varchar(64) not null,
    p_smallIMG varchar(256) not null,
    p_platformPrice int(10),
    p_grade tinyint(2),
    p_baoyou smallint(5),
    p_changdi varchar(64),
    p_level varchar(64),
    p_baozhiqi tinyint(3),
    p_code varchar(64),
    p_guige varchar(64),
)ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE	cart(
    u_id bigint(20)  NOT NULL,
    p_id bigint(20)  NOT NULL,
    p_count bigint(20)  NOT NULL
);