# Project with DB

## Create database

```sql
CREATE DATABASE mydatabase CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

```
CREATE USER 'abc'@'localhost' IDENTIFIED BY 'hello';
GRANT ALL ON db1.* TO 'abc'@'localhost';
```

```
docker run -p 3307:3306 --name mariadb -e MYSQL_ROOT_PASSWORD=password -d mariadb:latest

docker exec -it <container id> bash

CREATE DATABASE mydatabase CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'fs'@'%' IDENTIFIED BY 'password';

GRANT ALL ON fs_db.* TO 'fs'@'%';
```