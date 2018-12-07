
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (1, 'yinguowei', '111111', 'Yin Guo Wei', 'yinguowei@gmail.com', 'Male');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (2, 'yinxiaoqin', 'Yin Xiao Qin', 'yinxiaoqin2009@gmail.com', '222222', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (3, 'Test3', '111111', 'Test3', 'test3@test.com', 'Male');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (4, 'Test4', '111111', 'Test4', 'test4@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (5, 'Test5', '111111', 'Test5', 'test5@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (6, 'Test6', '111111', 'Test6', 'test6@test.com', 'Male');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (7, 'Test7', '111111', 'Test7', 'test7@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (8, 'Test8', '111111', 'Test8', 'test8@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (9, 'Test9', '111111', 'Test9', 'test9@test.com', 'Male');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (10, 'Test10', '111111', 'Test10', 'test10@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (11, 'Test11', '111111', 'Test11', 'test11@test.com', 'Male');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (12, 'Test12', '111111', 'Test12', 'test12@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (13, 'Test13', '111111', 'Test13', 'test13@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (14, 'Test14', '111111', 'Test14', 'test14@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (15, 'Test15', '111111', 'Test15', 'test15@test.com', 'Male');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (16, 'Test16', '111111', 'Test16', 'test16@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (17, 'Test17', '111111', 'Test17', 'test17@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (18, 'Test18', '111111', 'Test18', 'test18@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (19, 'Test19', '111111', 'Test19', 'test19@test.com', 'Female');
INSERT INTO user (id, username, password, fullname, email, gender) VALUES (20, 'Test20', '111111', 'Test20', 'test20@test.com', 'Female');

INSERT INTO role (id, roleKey, name) VALUES (1, 'admin', '管理员');
INSERT INTO role (id, roleKey, name) VALUES (2, 'user', '注册用户');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);