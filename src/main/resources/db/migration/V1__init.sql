create table locations
(
  lat     double,
  lon     double,
  moto_id int,
  id      int not null auto_increment primary key
);

create table users
(
  name         int,
  email        char,
  password     char,
  passwordSalt char,
  id           int not null auto_increment primary key
);

create table motorcycles
(
  name     int,
  owner_id int,
  id       int not null auto_increment primary key,
  user_id  int not null,
  constraint motorcycles_users_fk
    foreign key (user_id)
      references users (id)
);