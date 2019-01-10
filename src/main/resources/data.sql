--Insert projects
insert into project(id, name) values(10001, 'project 1');
insert into project(id, name) values(10002, 'project 2');
insert into project(id, name) values(10003, 'project 2');

--Insert user
insert into user(id, name) values(20001, 'user 1');
insert into user(id, name) values(20002, 'user 2');

--Insert tasks
insert into task(id, name, assignee_id, creator_id, project_id)
  values(30001, 'parent task 1', 20001, 20002, 10002);
  
insert into task(id, name, assignee_id, creator_id, parent_task_id, project_id)
  values(30002, 'task 2', 20001, 20002, 30001, 10002);


--Insert comments
insert into comment(id, comment, task_id, user_id)
	values(40001, 'comment 1', 30001, 20001);
	
insert into comment(id, comment, task_id, user_id)
	values(40002, 'comment 2', 30001, 20002);

