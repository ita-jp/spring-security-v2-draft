CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE notifications
(
    id         BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    message    VARCHAR(256) NOT NULL,
    username   VARCHAR(50)  NOT NULL REFERENCES users (username),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority ENUM('ADMIN', 'MEMBER') NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);