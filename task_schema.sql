create table task
(
    id          int primary key generated always as IDENTITY,
    short_desc  VARCHAR(200),
    long_desc   VARCHAR(2000),
    create_date DATE,
    target_date DATE,
    created_by  varchar(100),
    status      VARCHAR(20) -- COMPLETE, CANCELED
);

create table task_action
(
    id          int generated always as IDENTITY,
    task_id     int,
    update_by   varchar(20),
    update_time TIMESTAMP,
    action      varchar(100) NOT NULL,
    CONSTRAINT cx_fk_task_id FOREIGN KEY (task_id) REFERENCES task (id)
);


