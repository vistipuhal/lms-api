insert into app_user (user_id, email, password_hash, first_name, last_name) values (1, 'gary.golfer@gmail.com', '$2a$10$Dulc4UDptjo3DQw/K0Ja7OAYYWQf/S6E7sP/9Qj8PAGt.o1lD.Dk2', 'Gary', 'Golfer');

insert into league (league_id, name) values (1, 'Kingwood Men''s Golf Association');
insert into league_member (league_member_id, league_id, user_id) values (1, 1, 1);

insert into league (league_id, name) values (2, 'Deerwood Men''s Golf Association');
--insert into league_member (league_member_id, league_id, user_id) values (2, 2, 1);

