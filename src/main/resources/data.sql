--Insert projects
--insert into project(id, project_name, status) values(10001, 'project 1','ongoing');
--insert into project(id, project_name, status) values(10002, 'project 2','completed');
--insert into project(id, project_name, status) values(10003, 'project 3','ongoing');

insert into project(id, project_name, client_id, status, project_mgr_id) values(10001, 'project 1',20006,'ongoing',20001);
insert into project(id, project_name, client_id, status, project_mgr_id) values(10002, 'project 2',20006,'completed', 20001);
insert into project(id, project_name, client_id, status, project_mgr_id) values(10003, 'project 3',20007,'ongoing', 20002);

--Insert user
insert into user(id, name, email,user_role, password) values(20001, 'pmanager01','pm1@gmail.com','PM', '9ughWviKqRrtM7I1kEBANg==');
insert into user(id, name, email,user_role, password) values(20002, 'pmanager02','pm2@gmail.com','PM', '1234pm2');
insert into user(id, name, email,user_role, password) values(20003, 'pmanager03','pm3@gmail.com','PM', '1234pm3');
insert into user(id, name, email,user_role, password) values(20006, 'cl01','cl@gmail.com', 'CL', 'UW3sLdY5oqC/kuEYtvXyCA==');
insert into user(id, name, email,user_role, password) values(20007, 'cl02','cl2@gmail.com', 'CL', '1234cl2');
insert into user(id, name, email,user_role, password) values(20008, 'cl03','cl3@gmail.com', 'CL', '1234cl3');
insert into user(id, name, email,user_role, password) values(20011, 'con01','con@gmail.com', 'CON', '1234con');
insert into user(id, name, email,user_role, password) values(20012, 'con02','con2@gmail.com', 'CON', '1234con2');
insert into user(id, name, email,user_role, password) values(20013, 'con03','con3@gmail.com', 'CON', '1234con3');
insert into user(id, name, email,user_role, password) values(20017, 'eng01','eng@gmail.com', 'ENG', '1234eng');
insert into user(id, name, email,user_role, password) values(20018, 'eng02','eng2@gmail.com', 'ENG', '1234eng2');
insert into user(id, name, email,user_role, password) values(20019, 'eng03','eng3@gmail.com', 'ENG', '1234eng3');


--Insert tasks
insert into task(id, task_name, assignee_id, project_id, status)
  values(30001, 'task 1', 20011, 10002, 'ongoing');
  
insert into task(id, task_name, assignee_id, project_id, status)
  values(30002, 'task 2', 20013, 10002, 'completed');

--insert into task(id, task_name, assignee_id, creator_id, project_id, status)
  --values(30003, 'task 3', 20012, 20003, 10001, 'ongoing');

--insert into task(id, task_name, assignee_id, creator_id, project_id, status)
  --values(30004, 'task 4', 20011, 20001, 10001, 'completed');
--insert into task(id, task_name, assignee_id, creator_id, project_id, status)
 -- values(30005, 'task 5', 20012, 20002, 10003, 'ongoing');
--insert into task(id, task_name, assignee_id, creator_id, project_id, status)
  --values(30006, 'task 6', 20013, 20003, 10003, 'completed');

--Insert comments
insert into comment(id, comment, task_id, user_id)
	values(40001, 'comment 1', 30001, 20001);
	
insert into comment(id, comment, task_id, user_id)
	values(40002, 'comment 2', 30001, 20002);

--Insert issues
insert into issue(id, comment, name, project_id)
values(50001, 'comment 6', 'issue 01', 10001);

insert into issue(id, comment, name, project_id)
values(50002, 'comment 7', 'issue 02', 10001);

insert into issue(id, comment, name, project_id)
values(50003, 'comment 8', 'issue 03', 10001);

insert into issue(id, comment, name, project_id)
values(50004, 'comment 9', 'issue 04', 10002);

insert into issue(id, comment, name, project_id)
values(50005, 'comment 10', 'issue 05', 10002);

insert into issue(id, comment, name, project_id)
values(50006, 'comment 11', 'issue 06', 10002);

insert into issue(id, comment, name, project_id)
values(50007, 'comment 12', 'issue 07', 10003);

insert into issue(id, comment, name, project_id)
values(50008, 'comment 13', 'issue 08', 10003);

insert into issue(id, comment, name, project_id)
values(50009, 'comment 14', 'issue 09', 10003);


