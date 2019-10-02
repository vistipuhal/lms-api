insert into app_user (user_id, email, password_hash, first_name, last_name) values (1, 'gary.golfer@gmail.com', '$2a$10$Dulc4UDptjo3DQw/K0Ja7OAYYWQf/S6E7sP/9Qj8PAGt.o1lD.Dk2', 'Gary', 'Golfer');
insert into app_user (user_id, email, password_hash, first_name, last_name) values (2, null, null, 'Drew', 'Brees');

insert into league (league_id, name) values (1, 'Kingwood Men''s Golf Association');
insert into league_member (league_member_id, league_id, user_id) values (1, 1, 1);
insert into league_member (league_member_id, league_id, user_id) values (2, 1, 2);

insert into league (league_id, name) values (2, 'Deerwood Men''s Golf Association');
insert into league_member (league_member_id, league_id, user_id) values (3, 2, 1);

insert into season (season_id, league_id, start_date, end_date) values (1, 1, '2019-10-01', '2020-09-30');

insert into event (event_id, league_id, season_id, name, description, event_date, event_time) values (1, 1, 1, '4 Man Scramble', 'It''s a 4 man scramble', '2019-10-30', '09:00:00');
insert into event (event_id, league_id, season_id, name, description, event_date, event_time) values (2, 1, 1, 'Red, White and Blue Lone Ranger', 'Three games in one.', '2019-11-15', '10:00:00');
insert into event (event_id, league_id, season_id, name, description, event_date, event_time) values (3, 1, 1, 'Pink Ball', '4 player scramble', '2019-12-05', '09:00:00');