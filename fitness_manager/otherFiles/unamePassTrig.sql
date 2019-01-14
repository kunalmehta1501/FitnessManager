delimiter //
create trigger unamePass
after insert
on gym_member for each row
begin
insert into login_table values(new.user_name,new.password,"member");
end;
delimiter ;
