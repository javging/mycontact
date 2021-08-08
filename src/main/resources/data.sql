-- insert into person (`id`, `name`, `age`, `blood_type`, `year_of_birthday`, `month_of_birthday`, `day_of_birthday`) values (1, 'martin', 10, 'A', 1991, 8, 15);
-- insert into person (`id`, `name`, `age`, `blood_type`, `year_of_birthday`, `month_of_birthday`, `day_of_birthday`) values (2, 'david', 10, 'B', 1992, 7, 10);
-- insert into person (`id`, `name`, `age`, `blood_type`, `year_of_birthday`, `month_of_birthday`, `day_of_birthday`) values (3, 'dennis', 10, 'O', 1993, 10, 5);
-- insert into person (`id`, `name`, `age`, `blood_type`, `year_of_birthday`, `month_of_birthday`, `day_of_birthday`) values (4, 'sophia', 10, 'A', 1994, 8, 9);
--
-- insert into block (`id`, `name`) values (1, 'dennis');
-- insert into block (`id`, `name`) values (2, 'sophia');
--
-- update person set block_id = 1 where id = 3;
-- update person set block_id = 2 where id = 4;
--
-- insert into person (`id`, `name`, `age`, `year_of_birthday`, `month_of_birthday`, `day_of_birthday`) values (5, 'benny', 10, 1995, 12, 23);
-- insert into person (`id`, `name`, `age`, `year_of_birthday`, `month_of_birthday`, `day_of_birthday`, `job`, `hobby`, `phone_number`, `address`)
-- values (6, 'tony', 10, 1991, 7, 10, 'officer', 'reading', '010-2222-5555', '서울');
-- insert into person (`id`, `name`, `age`) values (7, 'andrew', 10);

select 1; -- 테스트 데이터 입력 코드가 main, test 에 둘 다 있으면, 충돌 생김.. 근데 전부 다 주석으로 되어있으면 에러남.