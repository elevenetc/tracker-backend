create table users
(
    id            binary(16) not null primary key,
    name          varchar(255),
    email         varchar(320) unique,
    password      varchar(255),
    password_salt varchar(255)
);

create table motorcycles
(
    name    varchar(255),
    id      binary(16) not null primary key,
    user_id binary(16) not null,
    constraint motorcycles_users_fk
        foreign key (user_id)
            references users (id)
);

create table devices
(
    id            binary(16) not null primary key,
    hardware_id   varchar(255) unique ,
    name          varchar(255),
    manufacturer  varchar(255),
    mode          varchar(255),

    user_id       binary(16) not null,
    constraint devices_users_fk
        foreign key (user_id)
            references users (id),

    motorcycle_id binary(16),
    constraint devices_motorcycles_fk
        foreign key (motorcycle_id)
            references motorcycles (id)
);

create table device_states
(
    id        binary(16) not null primary key,
    lat       double,
    lon       double,
    battery   float,
    date      long,
    device_id binary(16) not null,
    constraint device_states_devices_fk
        foreign key (device_id)
            references devices (id)
);

create table access_tokens
(
    id      binary(16) not null primary key,
    date    long,
    value   varchar(255),
    user_id binary(16) not null,
    constraint access_tokens_users_fk
        foreign key (user_id)
            references users (id)
);