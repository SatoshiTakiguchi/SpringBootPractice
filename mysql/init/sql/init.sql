CREATE DATABASE IF NOT EXISTS sample;

CREATE TABLE users (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  inquiry VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE contacts (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  content VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO users (
  name,
  email,
  inquiry
) values (
  'aaa',
  'aa@aa.com',
  'aaaaa'
);

INSERT INTO contacts (
  name,
  email,
  content
) values (
  'bbb',
  'bb@bb.com',
  'bbbbbb'
);