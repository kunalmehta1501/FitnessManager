delimiter //
create trigger deleteUnamePass
after delete
on gym_member for each row
begin
delete from login_table where user_name=old.user_name;
end;
delimiter ;
