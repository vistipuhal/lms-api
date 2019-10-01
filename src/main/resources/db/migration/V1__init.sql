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
CREATE SEQUENCE league_id_seq START WITH 1000;

CREATE TABLE league (
    league_id INTEGER PRIMARY KEY DEFAULT nextval('league_id_seq'),
    name VARCHAR(100) NOT NULL UNIQUE
);

ALTER SEQUENCE league_id_seq OWNED BY league.league_id;

-- League Member Table
CREATE SEQUENCE league_member_id_seq START WITH 1000;

CREATE TABLE league_member (
    league_member_id INTEGER PRIMARY KEY DEFAULT nextval('league_member_id_seq'),
    league_id INTEGER REFERENCES league (league_id) NOT NULL,
    user_id INTEGER REFERENCES app_user (user_id) NOT NULL
);

ALTER SEQUENCE league_member_id_seq OWNED BY league_member.league_member_id;

-- Season Table
CREATE SEQUENCE season_id_seq START WITH 1000;

CREATE TABLE season (
    season_id INTEGER PRIMARY KEY DEFAULT nextval('season_id_seq'),
    league_id INTEGER REFERENCES league (league_id) NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL
);

ALTER SEQUENCE season_id_seq OWNED BY season.season_id;

-- Event Table
CREATE SEQUENCE event_id_seq START WITH 1000;

CREATE TABLE event (
    event_id INTEGER PRIMARY KEY DEFAULT nextval('event_id_seq'),
    league_id INTEGER REFERENCES league (league_id) NOT NULL,
    season_id INTEGER REFERENCES season (season_id),
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    event_date date NOT NULL,
    event_time time NOT NULL
);

ALTER SEQUENCE event_id_seq OWNED BY event.event_id;
