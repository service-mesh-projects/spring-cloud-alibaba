CREATE TABLE `t_producer`
(
    id         BIGINT PRIMARY KEY,
    context    VARCHAR(255) NOT NULL,
    created_at DATETIME(6)  NOT NULL
);