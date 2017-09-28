DROP DATABASE kandidatentest;
DROP USER kandidatentest;
DROP ROLE kandidatentest;

CREATE USER kandidatentest WITH PASSWORD 'kandidatentestpwd';
GRANT pg_signal_backend, postgres TO kandidatentest WITH ADMIN OPTION;

CREATE DATABASE kandidatentest WITH OWNER = kandidatentest;
