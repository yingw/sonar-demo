
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (1, 'yinguowei', '111111', 'Yin Guo Wei', 'yinguowei@gmail.com', 'Male');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (2, 'yinxiaoqin', 'Yin Xiao Qin', 'yinxiaoqin2009@gmail.com', '222222', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (3, 'Test3', '111111', 'Test3', 'test3@test.com', 'Male');

INSERT INTO role (id, roleKey, name) VALUES (1, 'admin', '管理员');
INSERT INTO role (id, roleKey, name) VALUES (2, 'user', '注册用户');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);