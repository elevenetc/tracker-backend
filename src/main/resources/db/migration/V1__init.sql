create table users
(
  name          varchar(255),
  email         varchar(320),
  password      varchar(255),
  password_salt varchar(255),
  id            binary(16) not null primary key
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

create table locations
(
  id            binary(16) not null primary key,
  lat           double,
  lon           double,
  date          long,
  motorcycle_id binary(16) not null,
  constraint locations_motorcycles_fk
    foreign key (motorcycle_id)
      references motorcycles (id)
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