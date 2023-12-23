-- password = password1234
INSERT INTO users (username, password, authority) VALUES ('tom', '$2a$10$iDFub7VH/DFDtUF6AFPXuuTDHI56oXWdXz.7F3L7xgUTFh004InNm', 'ADMIN');
-- password = password1234
INSERT INTO users (username, password, authority) VALUES ('bob', '$2a$10$Uz3R17Fn4izSBDO15I5TpeEgb0ugusFqdHfxqic.7DbEMFzL8pW4O', 'MEMBER');

INSERT INTO notifications(username, message) VALUES ('tom', 'これはテストのおしらせです。1');
INSERT INTO notifications(username, message) VALUES ('bob', 'これはテストのおしらせです。2');
