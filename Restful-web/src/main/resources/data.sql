insert into user_details(id, birth_date, name)
values (10001, current_date(), 'seungjae');

insert into user_details(id, birth_date, name)
values (10002, current_date(), 'seungjae2');

insert into user_details(id, birth_date, name)
values (10003, current_date(), 'seungjae3');

insert into post(id, description, user_id)
values (20001, 'first post', 10001);

insert into post(id, description, user_id)
values (20002, 'second post', 10001);

insert into post(id, description, user_id)
values (20003, 'third post', 10002);

insert into post(id, description, user_id)
values (20004, 'fourth post', 10002);