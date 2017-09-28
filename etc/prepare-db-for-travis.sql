DROP DATABASE kandidatentest;
DROP USER kandidatentest;
DROP ROLE kandidatentest;

CREATE USER kandidatentest WITH PASSWORD 'kandidatentestpwd' LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION;

GRANT pg_signal_backend, postgres TO kandidatentest WITH ADMIN OPTION;

CREATE DATABASE kandidatentest WITH OWNER = kandidatentest ENCODING = 'UTF8' LC_COLLATE = 'de_DE.UTF-8' LC_CTYPE = 'de_DE.UTF-8' CONNECTION LIMIT = -1;
