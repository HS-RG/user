create schema user;

use user;

create table collection
(
    user_id     bigint   not null,
    file_id     bigint   not null,
    create_time datetime not null,
    primary key (user_id, file_id)
);

create table user
(
    user_id     bigint       not null
        primary key,
    username    varchar(50)  not null,
    nickname   varchar(20)  not null,
    image_url   varchar(300) null,
    update_time datetime     not null,
    create_time datetime     not null,
    constraint username
        unique (username)
);
