create database HMS;
use HMS;
create table hostel1(Floor int,TotalRoms int,RoomsOcccupied int,RoomsAvailable int);

insert into hostel1 values(20,15,5);
SELECT * from hostel1;
ALTER TABLE hostel1
ADD COLUMN floor int ;
insert into hostel1 (floor) values(1);	
delete from hostel1 where floor = 1;
delete from hostel1 where TotalRoms = 20;
insert into hostel1 values(20,15,5,1);

create table hostel2(StudentName varchar(10),Id int,Department varchar(5));
insert into hostel2 values("viswa",42,"ECE");
ALTER TABLE hostel2
ADD COLUMN  Room int ;
insert into hostel2 (Room) values(1);	
SELECT * from hostel2;
delete from hostel2 where Id = 121;
delete from hostel2 where Id = 44;
delete from hostel2 where Id = 32;
delete from hostel2 where Room = 1;
delete from hostel2 where ID = 32;
delete from hostel2 where ID = 37;
UPDATE hostel3
SET RoomAvailable = 1
WHERE RoomNo = 1;



insert into hostel2 values ("viswa",42,"CSE",14);




create table hostel3(RoomNo int,RoomFilled boolean,RoomAvailable boolean);
insert into hostel3 values (1, True,False);
insert into hostel3 values (2, True,False);
insert into hostel3 values (3, True,False);
insert into hostel3 values (4, True,False);
insert into hostel3 values (5, True,False);
insert into hostel3 values (6, True,False);
insert into hostel3 values (7, False,True);
insert into hostel3 values (8, True,False);
insert into hostel3 values (9, True,False);
insert into hostel3 values (10, True,False);
insert into hostel3 values (11, False,True);
insert into hostel3 values (12, True,False);
insert into hostel3 values (13, True,False);
insert into hostel3 values (14, False,True);
insert into hostel3 values (15, True,False);
insert into hostel3 values (16, True,False);
insert into hostel3 values (17, False,True);
insert into hostel3 values (18, True,False);
insert into hostel3 values (19, False,True);
insert into hostel3 values (20, True,False);
SELECT * from hostel3;

UPDATE hostel3
SET RoomFilled= 1
WHERE RoomNo = 7;

SELECT hostel2.StudentName, hostel2.Id, hostel2.Department, hostel2.Room, 
       hostel3.RoomNo, hostel3.RoomFilled, hostel3.RoomAvailable
FROM hostel2
JOIN hostel3 ON hostel2.Room = hostel3.RoomNo;


