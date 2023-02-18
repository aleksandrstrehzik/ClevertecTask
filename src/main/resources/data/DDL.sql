create table product
(
    id             int primary key,
    marking        text           not null,
    type           varchar(30)    not null,
    is_on_discount boolean        not null,
    description    varchar(30)    not null,
    price          decimal(19, 2) not null
);

create table discount_card
(
    id       int primary key,
    discount decimal(19, 2) not null
);
