CREATE TABLE users (
    user_id CHAR NOT NULL PRIMARY KEY,
    user CHAR NOT NULL
);
CREATE TABLE income (
    id IDENTITY,
    user_id CHAR NOT NULL REFERENCES users(user_id),
    date CHAR NOT NULL,
    money INT NOT NULL,
    memo CHAR
);
CREATE TABLE spend (
    id IDENTITY,
    user_id CHAR NOT NULL REFERENCES users(user_id),
    date CHAR NOT NULL,
    money INT NOT NULL,
    memo CHAR
);
