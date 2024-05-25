drop table if exists merchandise CASCADE;

create table brand
(
    id   bigint unsigned auto_increment comment '식별값',
    name varchar(20) unique not null comment '이름',
    primary key (id)
) comment '브랜드';

create table category
(
    id   bigint unsigned auto_increment comment '식별값',
    name varchar(20) unique not null comment '이름',
    primary key (id)
) comment '카테고리';

CREATE INDEX idx_name ON category (name);

create table product
(
    id          bigint unsigned auto_increment comment '식별값',
    price       int unsigned not null comment '가격',
    brand_id    bigint unsigned comment '브랜드 식별값',
    category_id bigint unsigned comment '카테고리 식별값',
    primary key (id)
) comment '상품';

CREATE INDEX idx_category_id ON product (category_id);
CREATE INDEX idx_price ON product (price);
