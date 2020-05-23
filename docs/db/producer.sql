CREATE TABLE `t_producer`
(
    id         BIGINT PRIMARY KEY,
    context    VARCHAR(255) NOT NULL,
    created_at DATETIME(6)  NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COMMENT 'Producer 表';