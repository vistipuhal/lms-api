-- User Table
CREATE SEQUENCE app_user_id_seq START WITH 1000;

CREATE TABLE app_user (
    user_id INTEGER PRIMARY KEY DEFAULT nextval('app_user_id_seq'),
    email VARCHAR(100) UNIQUE,
    password_hash VARCHAR,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL
);

-- League Table
CREATE SEQUENCE league_id_seq START WITH 1000 INCREMENT BY 10;

CREATE TABLE league (
    league_id INTEGER PRIMARY KEY DEFAULT nextval('league_id_seq'),
    name VARCHAR(100) NOT NULL UNIQUE
);

ALTER SEQUENCE league_id_seq OWNED BY league.league_id;

-- League Member Table
CREATE SEQUENCE league_member_id_seq START WITH 1000 INCREMENT BY 10;

CREATE TABLE league_member (
    league_member_id INTEGER PRIMARY KEY DEFAULT nextval('league_member_id_seq'),
    league_id INTEGER REFERENCES league (league_id) NOT NULL,
    user_id INTEGER REFERENCES app_user (user_id) NOT NULL
);

ALTER SEQUENCE league_member_id_seq OWNED BY league_member.league_member_id;

