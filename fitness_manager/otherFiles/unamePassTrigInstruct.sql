delimiter //
create trigger unamePassInstruct
after insert
on instructor for each row
begin
insert into login_table values(new.tuser_name,new.tpassword,"member");
end;
delimiter ;

