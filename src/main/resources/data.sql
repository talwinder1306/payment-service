create database payment;

create table transaction (
    transaction_id integer not null,
    booking_id integer not null,
    card_number varchar(255),
    payment_mode varchar(255),
    upi_id varchar(255),
    primary key (transaction_id)
);

create table hibernate_sequence (
    next_val bigint
);