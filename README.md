# Project with DB

## Create database

```sql
CREATE DATABASE mydatabase CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

mysql> CREATE USER 'jeffrey'@'localhost' IDENTIFIED BY 'password';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT ALL ON db1.* TO 'jeffrey'@'localhost';
Query OK, 0 rows affected (0.10 sec)

mysql>
