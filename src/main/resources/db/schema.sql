DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS user_role;

-- user

CREATE TABLE IF NOT EXISTS user (
  id       BIGINT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50),
  fullname VARCHAR(50),
  email    VARCHAR(50),
  gender   VARCHAR(10),
  PRIMARY KEY (id),
  UNIQUE KEY (username)
);

-- role

CREATE TABLE IF NOT EXISTS role (
  id          BIGINT AUTO_INCREMENT,
  roleKey     VARCHAR(20) NOT NULL,
  name        VARCHAR(50) NOT NULL,
  description VARCHAR(500),
  PRIMARY KEY (id)
);

-- user_role

CREATE TABLE user_role (
  user_id BIGINT NOT NULL
  COMMENT '用户id',
  role_id BIGINT NOT NULL
  COMMENT '角色id'
);
