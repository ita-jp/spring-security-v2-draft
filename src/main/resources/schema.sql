CREATE TABLE users
(
    username  VARCHAR(50)             NOT NULL PRIMARY KEY,
    password  VARCHAR(100)            NOT NULL,
    authority ENUM('ADMIN', 'MEMBER') NOT NULL
);

CREATE TABLE notifications
(
    id         BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    message    VARCHAR(256) NOT NULL,
    username   VARCHAR(50)  NOT NULL REFERENCES users (username),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
