create type enum_gender as enum (
    'MALE',
    'FEMALE'
);

create table employee (
    employee_id bigserial primary key ,
    first_name varchar,
    last_name varchar,
    department_id bigint,
    job_title varchar,
    gender enum_gender,
    date_of_birth varchar
);
