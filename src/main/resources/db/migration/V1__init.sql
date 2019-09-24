CREATE SEQUENCE app_user_id_seq START WITH 1000 INCREMENT BY 10;

CREATE TABLE app_user (
    user_id INTEGER PRIMARY KEY DEFAULT nextval('app_user_id_seq'),
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR NOT NULL
);

CREATE TABLE app_user_profile (
    user_id INTEGER PRIMARY KEY REFERENCES app_user (user_id),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL
);

CREATE SEQUENCE league_id_seq START WITH 1000 INCREMENT BY 10;

CREATE TABLE league (
    league_id INTEGER PRIMARY KEY DEFAULT nextval('league_id_seq'),
    name VARCHAR(100) NOT NULL UNIQUE
);

ALTER SEQUENCE league_id_seq OWNED BY league.league_id;

CREATE SEQUENCE league_member_id_seq START WITH 1000 INCREMENT BY 10;

CREATE TABLE league_member (
    league_member_id INTEGER PRIMARY KEY DEFAULT nextval('league_member_id_seq'),
    league_id INTEGER REFERENCES league (league_id) NOT NULL,
    user_id INTEGER REFERENCES app_user_profile (user_id) NOT NULL
);

ALTER SEQUENCE league_member_id_seq OWNED BY league_member.league_member_id;

