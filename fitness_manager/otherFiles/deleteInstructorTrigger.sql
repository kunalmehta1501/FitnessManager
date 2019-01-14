delimiter //
create trigger deleteUnamePassInstruct
after delete
on instructor for each row
begin
delete from login_table where user_name=old.tuser_name;
end;
delimiter ;
