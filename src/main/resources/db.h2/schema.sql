create table board (
    seq int auto_increment primary key,
    title varchar(255) not null,
    contents varchar(255) not null,
    reg_user varchar(255) not null,
    reg_date TIMESTAMP default CURRENT_TIMESTAMP not null
);