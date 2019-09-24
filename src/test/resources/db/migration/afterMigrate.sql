insert into app_user (user_id, email, password_hash) values (1, 'gary.golfer@gmail.com', 'password');
insert into app_user_profile (user_id, first_name, last_name) values (1, 'Gary', 'Golfer');

insert into league (league_id, name) values (1, 'Kingwood Men''s Golf Association');
insert into league_member (league_member_id, league_id, user_id) values (1, 1, 1);

