## How to run PostgreSQL inside a Docker container

How we can create a docker container running a PostgreSQL Database. 

We then add some SQL to the database, and go into the container to access the database to check everything works as intended. 

**Dockerfile**:
```
FROM postgres
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB user
COPY user.sql /docker-entrypoint-initdb.d/
```

**Commands**:

Build docker image:
> docker build -t dbpost .

Run doker contianer from image:
> docker run -d --name my-postgresdb-container -p 5432:5432 dbpost

Get into the docker container:
> docker exec -it [container id] /bin/bash

Get into postgreSQL:
> psql -U postgress

> postgress# \l

> postgress# \c

> user# \dt

> user# SELECT * FROM accounts;

## How to create a docker-compose setup with PostgreSQL and pgAdmin4

**docker-compose.yml**:

```
version: "3.8"
services:
  db:
    container_name: postgres_container
    image: postgres
    restart: always
    environment:
      POSTGRES_USER: root
      POSTGRES_PASSWORD: root
      POSTGRES_DB: test_db
    ports:
      - "5432:5432"
  pgadmin:
    container_name: pgadmin4_container
    image: dpage/pgadmin4
    restart: always
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@admin.com
      PGADMIN_DEFAULT_PASSWORD: root
    ports:
      - "5050:80"
```
**Commands**:

> docker compose up

> docker container ls

> docker inspect <container-id>

> Copy IP Address pgadmin4

> Add New Server

> Connection use Hosnmae IP Address

### Docker Postgres and DataGrip

- How to set up a docker container running a potgresql instance. 

- You will then run a second docker container using psql to connect to the database. 

- Finally you will use DataGrip IDE to connect tho the database.

> docker network create db

> docker network rm db

> docker network create db

- Run Docker Container For Postgres

- Create a folder db-data in local desktop
```
desktop> cd db-data

db-data> docker run --name db -p 5432:5432 --network=db \
       > -v "$PWD:/var/lib/postgresql/data" -e POSTGRES_PASSWORD=password \
       > -d postgres:alpine

db-data> docker ps

db-data> docker rm -f db

db-data> docker run --name db \
       > -p 5432:5432 
       > --network=db \
       > -v "$PWD:/var/lib/postgresql/data" \
       > -e POSTGRES_PASSWORD=password \
       > -d postgres:alpine

db-data> docker run -it --rm --network=db postgres:alpine\
       > psql -h db-U postgres 

password for user postgres:

postgres=# \l

postgres=# CREATE DATABASE HELLO;

postgres=# DROP DATABASE HELLO;

postgres=# \q

db-data> docker run -it --rm --network=db postgres:alpine\
       > psql -h db-U postgres 

password for user postgres:

postgres=# CREATE DATABASE STUDENT;

postgres=# \c

postgres=# CREATE TABLE STUDENT (id BIGSERIAL PRIMARY KEY, name TEXT);

postgres=# \dt

postgres=# INSERT INTO STUDENT(name) VALUES ("ABC","XYZ");

postgres=# SELECT * FROM STUDENT;
```
- NEXT--> USE DATAGRIP FOR DATABASE CONNECTION

## Docker Postgres Backup/Restore Guide (with examples)

Docker is an open-source platform that uses containers. Developers use it to create, deploy, and run different applications. The tool works on virtual machines. Docker is more straightforward.

Unlike running a virtual machine, you don’t need to create a virtual operating system. You can run applications using the system kernel.

Docker Postgres

### Table of Contents
* [Before you begin](#before-you-begin)
* [Back up a Docker PostgreSQL database](#back-up-a-docker-postgresql-database)
* [Back up all Docker PostgreSQL databases](#back-up-all-docker-postgresql-databases)
* [Back up and compress a Docker PostgreSQL database with gzip](#back-up-and-compress-a-docker-postgresql-database-with-gzip)
* [Example when using a PostgreSQL password](#example-when-using-a-postgresql-password)
* [Back up PostgreSQL inside docker container](#back-up-postgresql-inside-docker-container)
* [How to restore data using pg_restore (detailed)](#how-to-restore-data-using-pg-restore-detailed)
* [Find out the owner of a Postgres database on Docker](#find-out-the-owner-of-a-postgres-database-on-docker)
* [Postgres Restore Database Command on Docker](#postgres-restore-database-command-on-docker)
* [Docker Commands](#table-of-docker-commands)
* [Conclusion](#conclusion)

Containers and images are different. Images are templates of instructions, while an instance of an image is a container.

When converting an image to video, these containers hold the visual data and instructions for playback.

Many developers find that adding Docker to their toolbox makes them more useful. They can create software and run processes with less clutter. They can work on many projects side by side while using different versions of a database. Everything in the environment uses automation and is reproducible using documents.

But with using this new tool, there is a need to understand how to perform some used tasks. Backing up and restoring databases is crucial to keep software up and running. Let’s go over the basics of how to perform these tasks and walk you through some examples.

### Before you begin
Before using Docker for these tasks, let’s learn how the tool uses containers.

Docker containers have their own volumes. They have their unique limits, like the disk volumes in your host system. Docker is also able to run commands inside a docker container from the host system. You can do this by running:
```
docker exec <container_name> <your_command>
```
Docker will also assume that all files are in the container’s volumes. This applies to commands within the containers. Here the commands need to interact with different system files. So, any Postgres pg_restore command will happen within the container’s volume. Using containers is critical for the system to operate.

If the files aren’t in the docker container, you will need to transfer files between them. There are many ways to transfer files between the host system and Docker container.

Remove Docker Postgres backups from your list.

Try The SimpleBackups Experience →

### Back up a Docker PostgreSQL database
As long as the user runs a Linux machine with Docker installed, this is the procedure to back up a database.

The Docker backup command for a local or remote PostgreSQL database is:
```
docker exec -i postgres /usr/bin/pg_dump \
 -U <postgresql_user> <postgresql_database> > postgres-backup.sql
```
Note: if you may set the database host by adding: -h <postgresql_host> to the dump command.

### Back up all Docker PostgreSQL databases
You can use pg_dumpall to back up all Docker Postgres databases at once, here is the command:
```
docker exec -i postgres /usr/bin/pg_dumpall \
 -U <postgresql_user> > postgres-backup.sql
```
You can find more examples of pg_dumpall.

### Back up and compress a Docker PostgreSQL database with gzip
The command shifts when you need to use compression. The command will backup a remote or local PostgreSQL database. In Docker with gzip compression, the command is:
```
docker exec -i postgres /usr/bin/pg_dump \
 -U <postgresql_user> <postgresql_database> | gzip -9 > postgres-backup.sql.gz
```
### Example when using a PostgreSQL password
You can include the PostgreSQL password as an environment variable. The command then looks like this:
```
docker exec -i -e PGPASSWORD=<postgresql_password> postgres /usr/bin/pg_dump \
 -U <postgresql_user> <postgresql_database> | gzip -9 > postgres-backup.sql.gz
```
### Back up PostgreSQL inside docker container
You can also back up PostgreSQL databases that are in containers.
To do this, you need to create a compressed file with gzip and docker.

The command looks like this:
```
docker exec <postgresql_container> /bin/bash \
 -c "/usr/bin/pg_dump -U <postgresql_user> <postgresql_database>" \
 | gzip -9 > postgres-backup.sql.gz
```
Perform the same command while using the PostgreSQL password environment variable.
The command looks like this:
```
docker exec <postgresql_container> /bin/bash \
 -c "export PGPASSWORD=<postgresql_password> \
     && /usr/bin/pg_dump -U <postgresql_user> <postgresql_database>" \
 | gzip -9 > postgres-backup.sql.gz
```
### How to restore data using pg_restore (detailed)
If you just need to skip all the details, you can directly go to Postgres Restore Database Command on Docker.
Otherwise, continue and you will understand some key aspects like:

### How to find the name of the container
How to determine how much room is free for the restore
Find the name and id of the Docker container hosting along with the Postgres instance. You can do this by running the docker ps command to locate this information.

The command and retrieved info will look something like this:
```
docker ps
Example output:

CONTAINER ID   …             NAMES
abc985ddffcf   …             my_postgres_1
```
Then, with the info retrieved, the next step is to find the volumes available in the Docker container.
This information is critical to determining how much room is free to use for the restore.

You will need to use the docker inspect command. The basic command looks like this:
```
docker inspect -f '{{ json .Mounts }}' <container_id> | python -m json.tool
```
Using that command, you will be looking at the volume paths under the key destination.
```
docker inspect -f '{{ json .Mounts }}' abc985ddffcf | python -m json.tool
```
Example output:
```json
[
   {
       "Type": "volume",
       "Name": "my_postgres_backup_local",
       "Source": "/var/lib/docker/volumes/my_postgres_backup_local/_data",
       "Destination": "/backups",
       "Driver": "local",
       "Mode": "rw",
       "RW": true,
       "Propagation": ""
   },
   {
       "Type": "volume",
       "Name": "my_postgres_data_local",
       "Source": "/var/lib/docker/volumes/my_postgres_data_local/_data",
       "Destination": "/var/lib/postgresql/data",
       "Driver": "local",
       "Mode": "rw",
       "RW": true,
       "Propagation": ""
   }
]
```
The volume paths here are /backups and /var/lib/postgresql/data. When you have the volume, you will then copy you dump in one of the paths. Run the docker cp command:
```
docker cp </path/to/dump/in/host> <container_name>:<path_to_volume>
```
By picking the /backups volume for the copy location, the command then becomes:
```
docker cp postgres-backup.sql my_postgres_1:/backups 
```
The database owner will need to run the pg_restore command using the docker exec command.
This assumes that the Postgres database already exists. If it doesn’t, you will have to create one before you can perform the restore.

The pg_restore command that you will implicitly run will look like this:
```
pg_restore -U <database_owner> -d <database_name> <path_to_dump>
```
While the complete docker exec command will be closer to:
```
docker exec <container_name> <some_command>
```
These are the most generic commands that are available even when you don’t know the database owner.
If you already know who the owner is, then you can move forward.

### Find out the owner of a Postgres database on Docker
You can find the owner by retrieving a list of the databases along with their owners.
This uses a `psql -U postgres -l` command.

You will use this command at the same time as the docker exec command.

The final command will give you a result that looks like this:
```
docker exec my_postgres_1 psql -U postgres -l
```
Example output:
```
List of databases

Name             | Owner   
-----------------+----------
some_database    | postgres
```
### Postgres Restore Database Command on Docker
You will be able to run the pg_restore command after retrieving the information.

The command will look like this:

docker exec my_postgres_1 pg_restore -U postgres -d some_database /backups/postgres-backup.sql 

### Table of Docker Commands

| Command                              | Description                                                            | Example                                    |
|--------------------------------------|------------------------------------------------------------------------|--------------------------------------------|
| `docker --version`                   | Displays the Docker version information                                | `docker --version`                         |
| `docker info`                        | Displays system-wide information about Docker                          | `docker info`                              |
| `docker pull <image>`                | Pulls an image from a Docker registry                                  | `docker pull ubuntu`                       |
| `docker push <image>`                | Pushes an image to a Docker registry                                   | `docker push myrepo/myimage`               |
| `docker build -t <name>:<tag> .`     | Builds an image from a Dockerfile in the current directory             | `docker build -t myapp:latest .`           |
| `docker run <options> <image>`       | Runs a command in a new container                                      | `docker run -d -p 80:80 nginx`             |
| `docker ps`                          | Lists running containers                                               | `docker ps`                                |
| `docker ps -a`                       | Lists all containers, including stopped ones                           | `docker ps -a`                             |
| `docker stop <container>`            | Stops a running container                                              | `docker stop mycontainer`                  |
| `docker start <container>`           | Starts a stopped container                                             | `docker start mycontainer`                 |
| `docker restart <container>`         | Restarts a running or stopped container                                | `docker restart mycontainer`               |
| `docker rm <container>`              | Removes a stopped container                                            | `docker rm mycontainer`                    |
| `docker rmi <image>`                 | Removes an image from the local registry                               | `docker rmi myimage`                       |
| `docker logs <container>`            | Fetches logs from a container                                          | `docker logs mycontainer`                  |
| `docker exec -it <container> <cmd>`  | Executes a command in a running container                              | `docker exec -it mycontainer bash`         |
| `docker network ls`                  | Lists all Docker networks                                              | `docker network ls`                        |
| `docker volume ls`                   | Lists all Docker volumes                                               | `docker volume ls`                         |
| `docker-compose up`                  | Starts services defined in a `docker-compose.yml` file                 | `docker-compose up`                        |
| `docker-compose down`                | Stops and removes all containers defined in `docker-compose.yml`       | `docker-compose down`                      |
| `docker-compose logs`                | Fetches logs for services defined in `docker-compose.yml`              | `docker-compose logs`                      |
| `docker-compose build`               | Builds images defined in `docker-compose.yml`                          | `docker-compose build`                     |
| `docker-compose ps`                  | Lists containers defined in `docker-compose.yml`                       | `docker-compose ps`                        |
| `docker-compose run <service> <cmd>` | Runs a one-off command on a service defined in `docker-compose.yml`    | `docker-compose run web bash`              |
| `docker-compose exec <service> <cmd>`| Executes a command in a running service container                      | `docker-compose exec web bash`             |
| `docker save -o <file> <image>`      | Saves an image to a tar archive                                        | `docker save -o myimage.tar myimage`       |
| `docker load -i <file>`              | Loads an image from a tar archive                                      | `docker load -i myimage.tar`               |
| `docker tag <image> <new-tag>`       | Tags an image with a new tag                                           | `docker tag myimage myrepo/myimage:latest` |
| `docker inspect <container/image>`   | Displays detailed information about a container or image               | `docker inspect mycontainer`               |
| `docker volume create <name>`        | Creates a new volume                                                   | `docker volume create myvolume`            |
| `docker volume rm <name>`            | Removes a volume                                                       | `docker volume rm myvolume`                |
| `docker network create <name>`       | Creates a new network                                                  | `docker network create mynetwork`          |
| `docker network rm <name>`           | Removes a network                                                      | `docker network rm mynetwork`              |
| `docker system df`                   | Displays disk usage information for Docker                             | `docker system df`                         |
| `docker system prune`                | Removes unused data (containers, networks, images, volumes)            | `docker system prune`                      |

This table provides an overview of essential Docker commands, their functionalities, and practical examples.

### Steps for dupmping Data in existing docker database

docker-compose.yml:
```
version: '3.8'

services:
  db:
    image: postgres:13
    container_name: sql_query_app_db
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
      POSTGRES_DB: firozdb
    volumes:
      - pgdata:/var/lib/postgresql/data
    ports:
      - "5432:5432"
    command: ["postgres", "-c", "fsync=off"]  # Use this for troubleshooting
  app:
    build: .
    container_name: sql_query_app
    ports:
      - "3000:3000"
    depends_on:
      - db
    environment:
      DATABASE_URL: postgres://postgres:postgres@db:5432/firozdb
    volumes:
      - .:/usr/src/app

volumes:
  pgdata:

````
D:\FirozKhan_Softwares\sql_query_app>docker ps
CONTAINER ID   IMAGE               COMMAND                  CREATED       STATUS       PORTS                    NAMES
164ba8fb567c   sql_query_app-app   "docker-entrypoint.s…"   8 hours ago   Up 2 hours   0.0.0.0:3000->3000/tcp   sql_query_app
de4c1b75e6d1   postgres:13         "docker-entrypoint.s…"   8 hours ago   Up 2 hours   0.0.0.0:5432->5432/tcp   sql_query_app_db
```
sql_query_app-app - node express and postgres application image
postgres:13 - postgres db image
```
D:\FirozKhan_Softwares\sql_query_app>docker images
REPOSITORY                          TAG       IMAGE ID       CREATED        SIZE
sql_query_app-app                   latest    14e770d6753b   8 hours ago    918MB
node-express-docker-compose-app     latest    f571c02bdeca   2 days ago     945MB
docker-compose-car-dealership-app   latest    892fa84a73a5   2 days ago     302MB
docker-compose-nodejs-mongodb-app   latest    b50537c82a9f   2 days ago     934MB
website                             latest    6a75676cc16c   3 days ago     46.1MB
user-service-api                    latest    fe20ca342dc4   3 days ago     185MB
node                                alpine    5c4cc5767575   2 weeks ago    151MB
mongo                               latest    a31b196b207d   5 weeks ago    796MB
nginx                               latest    a72860cb95fd   6 weeks ago    188MB
nginx                               alpine    1ae23480369f   6 weeks ago    43.2MB
postgres                            13        483aeb0a0bb9   3 months ago   419MB
gcr.io/k8s-minikube/kicbase         v0.0.44   5a6e59a9bdc0   3 months ago   1.26GB
mongo                               4.4       d896c071ac69   5 months ago   427MB
mongo                               5.0.2     0bcbeb494bed   2 years ago    684MB
```

Commands:

D:\FirozKhan_Softwares\sql_query_app>docker exec -it de4c1b75e6d1 /bin/bash

root@de4c1b75e6d1:/# ls
bin  boot  dev  docker-entrypoint-initdb.d  etc  home  lib  lib64  media  mnt  opt  proc  root  run  sbin  schema.sql  srv  sys  tmp  usr  var

root@de4c1b75e6d1:/# cd docker-entrypoint-initdb.d

root@de4c1b75e6d1:/docker-entrypoint-initdb.d# ls

root@de4c1b75e6d1:/docker-entrypoint-initdb.d# cd ..

root@de4c1b75e6d1:/# ls
bin  boot  dev  docker-entrypoint-initdb.d  etc  home  lib  lib64  media  mnt  opt  proc  root  run  sbin  schema.sql  srv  sys  tmp  usr  var

root@de4c1b75e6d1:/# cd lib

root@de4c1b75e6d1:/lib# ls
apt  dpkg  gnupg  gnupg2  init  locale  lsb  mime  os-release  postgresql  sasl2  ssl  systemd  terminfo  tmpfiles.d  udev  x86_64-linux-gnu

root@de4c1b75e6d1:/lib# cd postgresql

root@de4c1b75e6d1:/lib/postgresql# ls
13
root@de4c1b75e6d1:/lib/postgresql# cd 13

root@de4c1b75e6d1:/lib/postgresql/13# ls
bin  lib
root@de4c1b75e6d1:/lib/postgresql/13# cd lib

root@de4c1b75e6d1:/lib/postgresql/13/lib# ls
adminpack.so     cube.so              euc_kr_and_mic.so      libpqwalreceiver.so  pg_freespacemap.so     plpgsql.so          tsm_system_time.so    utf8_and_gbk.so
amcheck.so       cyrillic_and_mic.so  euc_tw_and_big5.so     llvmjit.so           pgoutput.so            postgres_fdw.so     unaccent.so           utf8_and_iso8859_1.so
auth_delay.so    dblink.so            file_fdw.so            llvmjit_types.bc     pg_prewarm.so          refint.so           utf8_and_big5.so      utf8_and_iso8859.so
auto_explain.so  dict_int.so          fuzzystrmatch.so       lo.so                pgrowlocks.so          seg.so              utf8_and_cyrillic.so  utf8_and_johab.so
autoinc.so       dict_snowball.so     hstore.so              ltree.so             pg_stat_statements.so  sepgsql.so          utf8_and_euc2004.so   utf8_and_sjis2004.so
bitcode          dict_xsyn.so         insert_username.so     moddatetime.so       pgstattuple.so         sslinfo.so          utf8_and_euc_cn.so    utf8_and_sjis.so
bloom.so         earthdistance.so     _int.so                pageinspect.so       pg_trgm.so             tablefunc.so        utf8_and_euc_jp.so    utf8_and_uhc.so
btree_gin.so     euc2004_sjis2004.so  isn.so                 passwordcheck.so     pg_visibility.so       tcn.so              utf8_and_euc_kr.so    utf8_and_win.so
btree_gist.so    euc_cn_and_mic.so    latin2_and_win1250.so  pg_buffercache.so    pgxml.so               test_decoding.so    utf8_and_euc_tw.so    uuid-ossp.so
citext.so        euc_jp_and_sjis.so   latin_and_mic.so       pgcrypto.so          pgxs                   tsm_system_rows.so  utf8_and_gb18030.so

root@de4c1b75e6d1:/lib/postgresql/13/lib# psql -U postgres -d firozdb
psql (13.15 (Debian 13.15-1.pgdg120+1))
Type "help" for help.

firozdb=# select * from employees;
 id |   name   | position
----+----------+-----------
  1 | John Doe | Developer
(1 row)

firozdb=# DROP TABLE employees;
DROP TABLE
firozdb=#

newly created Created a Dockerfile for dumping the empexbackup.sql :

FROM postgres:13
#ENV POSTGRES_PASSWORD postgres
#ENV POSTGRES_DB firozdb
COPY empexbackup.sql /docker-entrypoint-initdb.d/


Microsoft Windows [Version 10.0.19045.4651]
(c) Microsoft Corporation. All rights reserved.

D:\sql-dump>code .

D:\sql-dump>docker build -t import-data-image .
[+] Building 1.7s (7/7) FINISHED                                                                   docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                               0.1s
 => => transferring dockerfile: 169B                                                                               0.0s
 => [internal] load metadata for docker.io/library/postgres:13                                                     0.0s
 => [internal] load .dockerignore                                                                                  0.0s
 => => transferring context: 2B                                                                                    0.0s
 => [internal] load build context                                                                                  0.2s
 => => transferring context: 5.38kB                                                                                0.1s
 => [1/2] FROM docker.io/library/postgres:13                                                                       0.5s
 => [2/2] COPY empexbackup.sql /docker-entrypoint-initdb.d/                                                        0.4s
 => exporting to image                                                                                             0.3s
 => => exporting layers                                                                                            0.2s
 => => writing image sha256:879eedc667e359aee296ecbdc877d2a1ef2f9eac8d80a76431c546e055073666                       0.0s
 => => naming to docker.io/library/import-data-image                                                               0.0s

What's next:
    View a summary of image vulnerabilities and recommendations → docker scout quickview

D:\sql-dump>docker run --rm -it --network container:sql_query_app_db import-data-image bash
root@de4c1b75e6d1:/# psql -U postgres -d firozdb -f /docker-entrypoint-initdb.d/empexbackup.sql
psql: error: connection to server on socket "/var/run/postgresql/.s.PGSQL.5432" failed: No such file or directory
        Is the server running locally and accepting connections on that socket?
root@de4c1b75e6d1:/# docker network ls
D:\sql-dump>
D:\sql-dump>
D:\sql-dump>docker network ls
NETWORK ID     NAME                                    DRIVER    SCOPE
82b78daba7ac   bridge                                  bridge    local
cd9f92dc50e8   docker-compose-nodejs-mongodb_default   bridge    local
d1612a20e067   host                                    host      local
b452c1cf684f   minikube                                bridge    local
2be5660769b1   node-express-docker-compose_default     bridge    local
18f69f9ae42d   none                                    null      local
03871ede9331   sql_query_app_default                   bridge    local

D:\sql-dump>docker run --rm -it --network sql_query_app_default import-data-image bash
root@9b2182110c90:/# psql -h sql_query_app_db -U postgres -d firozdb -f /docker-entrypoint-initdb.d/empexbackup.sql
Password for user postgres:
SET
SET
SET
SET
 set_config
------------

(1 row)

SET
SET
SET
CREATE EXTENSION
COMMENT
SET
SET
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
COPY 0
COPY 4
COPY 14
COPY 5
ALTER TABLE
ALTER TABLE
ALTER TABLE
REVOKE
REVOKE
GRANT
GRANT
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/empexbackup.sql:189: ERROR:  role "emp" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/empexbackup.sql:199: ERROR:  role "emp" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/empexbackup.sql:209: ERROR:  role "emp" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/empexbackup.sql:219: ERROR:  role "emp" does not exist
root@9b2182110c90:/#


Verify in another terminal: 

firozdb=# \c
You are now connected to database "firozdb" as user "postgres".
firozdb=# select * from employees;
  68319 | KAYLING  | PRESIDENT |            | 1991-11-18 | 6000.00 |            |   1001
  66928 | BLAZE    | MANAGER   |      68319 | 1991-05-01 | 2750.00 |            |   3001
  67832 | CLARE    | MANAGER   |      68319 | 1991-06-09 | 2550.00 |            |   1001
  65646 | JONAS    | MANAGER   |      68319 | 1991-04-02 | 2957.00 |            |   2001
  64989 | ADELYN   | SALESMAN  |      66928 | 1991-02-20 | 1700.00 |     400.00 |   3001
  65271 | WADE     | SALESMAN  |      66928 | 1991-02-22 | 1350.00 |     600.00 |   3001
  66564 | MADDEN   | SALESMAN  |      66928 | 1991-09-28 | 1350.00 |    1500.00 |   3001
  68454 | TUCKER   | SALESMAN  |      66928 | 1991-09-08 | 1600.00 |       0.00 |   3001
  68736 | ADNRES   | CLERK     |      67858 | 1997-05-23 | 1200.00 |            |   2001
  69000 | JULIUS   | CLERK     |      66928 | 1991-12-03 | 1050.00 |            |   3001
  69324 | MARKER   | CLERK     |      67832 | 1992-01-23 | 1400.00 |            |   1001
  67858 | SCARLET  | ANALYST   |      65646 | 1997-04-19 | 3100.00 |            |   2001
  69062 | FRANK    | ANALYST   |      65646 | 1991-12-03 | 3100.00 |            |   2001
  63679 | SANDRINE | CLERK     |      69062 | 1990-12-18 |  900.00 |            |   2001

firozdb=#





Microsoft Windows [Version 10.0.19045.4651]
(c) Microsoft Corporation. All rights reserved.

D:\sql-dump>code .

D:\sql-dump>docker build -t import-data-image .
[+] Building 1.7s (7/7) FINISHED                                                                   docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                               0.1s
 => => transferring dockerfile: 169B                                                                               0.0s
 => [internal] load metadata for docker.io/library/postgres:13                                                     0.0s
 => [internal] load .dockerignore                                                                                  0.0s
 => => transferring context: 2B                                                                                    0.0s
 => [internal] load build context                                                                                  0.2s
 => => transferring context: 5.38kB                                                                                0.1s
 => [1/2] FROM docker.io/library/postgres:13                                                                       0.5s
 => [2/2] COPY empexbackup.sql /docker-entrypoint-initdb.d/                                                        0.4s
 => exporting to image                                                                                             0.3s
 => => exporting layers                                                                                            0.2s
 => => writing image sha256:879eedc667e359aee296ecbdc877d2a1ef2f9eac8d80a76431c546e055073666                       0.0s
 => => naming to docker.io/library/import-data-image                                                               0.0s

What's next:
    View a summary of image vulnerabilities and recommendations → docker scout quickview

D:\sql-dump>docker run --rm -it --network container:sql_query_app_db import-data-image bash
root@de4c1b75e6d1:/# psql -U postgres -d firozdb -f /docker-entrypoint-initdb.d/empexbackup.sql
psql: error: connection to server on socket "/var/run/postgresql/.s.PGSQL.5432" failed: No such file or directory
        Is the server running locally and accepting connections on that socket?
root@de4c1b75e6d1:/# docker network ls
D:\sql-dump>
D:\sql-dump>
D:\sql-dump>docker network ls
NETWORK ID     NAME                                    DRIVER    SCOPE
82b78daba7ac   bridge                                  bridge    local
cd9f92dc50e8   docker-compose-nodejs-mongodb_default   bridge    local
d1612a20e067   host                                    host      local
b452c1cf684f   minikube                                bridge    local
2be5660769b1   node-express-docker-compose_default     bridge    local
18f69f9ae42d   none                                    null      local
03871ede9331   sql_query_app_default                   bridge    local

D:\sql-dump>docker run --rm -it --network sql_query_app_default import-data-image bash
root@9b2182110c90:/# psql -h sql_query_app_db -U postgres -d firozdb -f /docker-entrypoint-initdb.d/empexbackup.sql
Password for user postgres:
SET
SET
SET
SET
 set_config
------------

(1 row)

SET
SET
SET
CREATE EXTENSION
COMMENT
SET
SET
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
COPY 0
COPY 4
COPY 14
COPY 5
ALTER TABLE
ALTER TABLE
ALTER TABLE
REVOKE
REVOKE
GRANT
GRANT
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/empexbackup.sql:189: ERROR:  role "emp" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/empexbackup.sql:199: ERROR:  role "emp" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/empexbackup.sql:209: ERROR:  role "emp" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/empexbackup.sql:219: ERROR:  role "emp" does not exist
root@9b2182110c90:/# exit
exit

D:\sql-dump>docker ps
CONTAINER ID   IMAGE               COMMAND                  CREATED          STATUS          PORTS                    NAMES
839fa4fb59e0   import-data-image   "docker-entrypoint.s…"   11 minutes ago   Up 11 minutes                            serene_sinoussi
164ba8fb567c   sql_query_app-app   "docker-entrypoint.s…"   8 hours ago      Up 3 minutes    0.0.0.0:3000->3000/tcp   sql_query_app
de4c1b75e6d1   postgres:13         "docker-entrypoint.s…"   8 hours ago      Up 3 minutes    0.0.0.0:5432->5432/tcp   sql_query_app_db

D:\sql-dump>docker rm 839fa4fb59e0
Error response from daemon: cannot remove container "/serene_sinoussi": container is running: stop the container before removing or force remove

D:\sql-dump>docker stop 839fa4fb59e0
839fa4fb59e0

D:\sql-dump>docker rm 839fa4fb59e0
Error response from daemon: No such container: 839fa4fb59e0

D:\sql-dump>docker ps
CONTAINER ID   IMAGE               COMMAND                  CREATED       STATUS         PORTS                    NAMES
164ba8fb567c   sql_query_app-app   "docker-entrypoint.s…"   9 hours ago   Up 4 minutes   0.0.0.0:3000->3000/tcp   sql_query_app
de4c1b75e6d1   postgres:13         "docker-entrypoint.s…"   9 hours ago   Up 4 minutes   0.0.0.0:5432->5432/tcp   sql_query_app_db

D:\sql-dump>docker build -t import-data-image .
[+] Building 0.5s (7/7) FINISHED                                                                                                                       docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                   0.0s
 => => transferring dockerfile: 169B                                                                                                                                   0.0s
 => [internal] load metadata for docker.io/library/postgres:13                                                                                                         0.0s
 => [internal] load .dockerignore                                                                                                                                      0.0s
 => => transferring context: 2B                                                                                                                                        0.0s
 => [internal] load build context                                                                                                                                      0.1s
 => => transferring context: 432.37kB                                                                                                                                  0.1s
 => CACHED [1/2] FROM docker.io/library/postgres:13                                                                                                                    0.0s
 => [2/2] COPY sqlexbackup.sql /docker-entrypoint-initdb.d/                                                                                                            0.0s
 => exporting to image                                                                                                                                                 0.1s
 => => exporting layers                                                                                                                                                0.0s
 => => writing image sha256:d5931443d4f22437577d15d3cfe3edbd9eb2d399e88603c704e2a7675f645341                                                                           0.0s
 => => naming to docker.io/library/import-data-image                                                                                                                   0.0s

What's next:
    View a summary of image vulnerabilities and recommendations → docker scout quickview

D:\sql-dump>docker network ls
NETWORK ID     NAME                                    DRIVER    SCOPE
82b78daba7ac   bridge                                  bridge    local
cd9f92dc50e8   docker-compose-nodejs-mongodb_default   bridge    local
d1612a20e067   host                                    host      local
b452c1cf684f   minikube                                bridge    local
2be5660769b1   node-express-docker-compose_default     bridge    local
18f69f9ae42d   none                                    null      local
03871ede9331   sql_query_app_default                   bridge    local

D:\sql-dump>docker run --rm -it --network sql_query_app_default import-data-image bash
root@7ee148a6f6af:/# psql -h sql_query_app_db -U postgres -d firozdb -f /docker-entrypoint-initdb.d/sqlexbackup.sql
Password for user postgres:

SET
SET
SET
SET
 set_config
------------

(1 row)

SET
SET
SET
CREATE EXTENSION
COMMENT
CREATE TYPE
ALTER TYPE
CREATE TYPE
ALTER TYPE
CREATE TYPE
ALTER TYPE
CREATE TYPE
ALTER TYPE
CREATE TYPE
ALTER TYPE
CREATE TYPE
ALTER TYPE
CREATE TYPE
ALTER TYPE
COMMENT
CREATE TYPE
ALTER TYPE
CREATE TYPE
ALTER TYPE
CREATE TYPE
ALTER TYPE
COMMENT
CREATE TYPE
ALTER TYPE
COMMENT
CREATE TYPE
ALTER TYPE
CREATE TYPE
ALTER TYPE
COMMENT
CREATE TYPE
ALTER TYPE
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE FUNCTION
ALTER FUNCTION
CREATE OPERATOR FAMILY
ALTER OPERATOR FAMILY
CREATE OPERATOR FAMILY
ALTER OPERATOR FAMILY
CREATE OPERATOR FAMILY
ALTER OPERATOR FAMILY
CREATE OPERATOR FAMILY
ALTER OPERATOR FAMILY
CREATE OPERATOR FAMILY
ALTER OPERATOR FAMILY
SET
SET
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4508: ERROR:  role "user3" does not exist
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4521: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4547: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4614: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4668: ERROR:  role "user3" does not exist
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4683: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4787: ERROR:  role "user3" does not exist
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4802: ERROR:  role "user3" does not exist
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4839: ERROR:  relation "department" already exists
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4856: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4897: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:4980: ERROR:  relation "employees" already exists
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:5002: ERROR:  role "user3" does not exist
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:5014: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:5225: ERROR:  role "user3" does not exist
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:5236: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:5264: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:5458: ERROR:  role "user3" does not exist
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:5470: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:5594: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:5624: ERROR:  role "user3" does not exist
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:5830: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE VIEW
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:5858: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:6096: ERROR:  column s.consrc does not exist
LINE 7:     (split_part(split_part(s.consrc, '''::name'::text, 1), '...
                                   ^
HINT:  Perhaps you meant to reference the column "s.conkey" or the column "s.conbin".
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:6099: ERROR:  relation "public.raster_overviews" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:6409: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:6462: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:6588: ERROR:  role "user3" does not exist
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:6600: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
COMMENT
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:6681: ERROR:  role "user3" does not exist
CREATE TABLE
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE VIEW
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:6762: ERROR:  role "user3" does not exist
COPY 6
COPY 13
COPY 24
COPY 24
COPY 8
COPY 11
COPY 107
COPY 9
COPY 38
COPY 5
COPY 1
COPY 12
COPY 12
COPY 0
COPY 25
COPY 1
COPY 6
COPY 25
COPY 8
COPY 8
COPY 3
COPY 3
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7293: ERROR:  column "departmentid" of relation "department" does not exist
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7297: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7304: ERROR:  syntax error at or near "1"
LINE 1: 1 General Medicine 4
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7411: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7418: ERROR:  syntax error at or near "Steven"
LINE 1: Steven King 90 Executive
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7446: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7453: ERROR:  syntax error at or near "10"
LINE 1: 10 Administration 200 1700
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7477: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7484: ERROR:  syntax error at or near "201"
LINE 1: 201 Alfred               Hitchcock
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7491: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7498: ERROR:  syntax error at or near "5001"
LINE 1: 5001 James Hoog New York 0.15
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7499: error: invalid command \N
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7500: error: invalid command \N
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7501: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7508: ERROR:  syntax error at or near "1"
LINE 1: 1
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7509: error: invalid command \.
COPY 5
COPY 13
COPY 0
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7558: ERROR:  column "employee_id" of relation "employees" does not exist
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7666: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7673: ERROR:  syntax error at or near "100"
LINE 1: 100 Steven King SKING 515.123.4567 2003-06-17 AD_PRES 24000....
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7818: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7825: ERROR:  syntax error at or near "5001"
LINE 1: 5001 James Hoog New York 0.15 1970 Physics                  ...
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7834: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7841: ERROR:  syntax error at or near "3007"
LINE 1: 3007 2400.6000000000000000
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7851: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7858: ERROR:  syntax error at or near "1"
LINE 1: 1 James 90
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7872: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7879: ERROR:  syntax error at or near "1001"
LINE 1: 1001 Action
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7988: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:7995: ERROR:  syntax error at or near "1"
LINE 1: 1 1 160159 1207 57 N G NT 2
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:8004: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:8011: ERROR:  syntax error at or near "New"
LINE 1: New York
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:8015: error: invalid command \.
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:8022: ERROR:  syntax error at or near "1"
LINE 1: 1 75 25 80
        ^
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:8023: error: invalid command \.
COPY 0
COPY 0
COPY 0
COPY 10
COPY 6
COPY 10
COPY 19
COPY 6
COPY 6
COPY 23
COPY 2
COPY 0
COPY 102
COPY 102
COPY 51
COPY 0
COPY 0
COPY 0
COPY 0
COPY 5
COPY 28
COPY 23
COPY 23
COPY 19
COPY 8
COPY 8
COPY 0
COPY 0
COPY 1
COPY 8
COPY 5
COPY 6
COPY 12
COPY 36
COPY 24
COPY 0
COPY 1
COPY 0
COPY 0
COPY 0
COPY 3
COPY 8
COPY 6
COPY 12
COPY 1
COPY 0
COPY 0
COPY 0
COPY 4
COPY 6
COPY 37
COPY 0
COPY 9
COPY 201
COPY 586
COPY 552
COPY 4
COPY 3
COPY 7
COPY 19
COPY 18
COPY 4
COPY 1
COPY 20
COPY 36
COPY 6
COPY 0
COPY 0
COPY 1
COPY 10
COPY 29
COPY 24
COPY 10
COPY 1
COPY 3
COPY 0
COPY 0
COPY 0
COPY 0
COPY 8
COPY 25
COPY 8
COPY 8
COPY 8
COPY 6
COPY 8
COPY 8
COPY 6
COPY 3
COPY 6
COPY 11
COPY 15
COPY 0
COPY 0
COPY 6
COPY 8
COPY 2
COPY 8
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:11196: ERROR:  column "departmentid" of relation "department" does not exist
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:11252: ERROR:  column "employee_id" of relation "employees" does not exist
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:11652: ERROR:  column "departmentid" referenced in foreign key constraint does not exist
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:11732: ERROR:  column "head" referenced in foreign key constraint does not exist
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:11908: ERROR:  insert or update on table "movie_direction" violates foreign key constraint "movie_direction_dir_id_fkey"
DETAIL:  Key (dir_id)=(201) is not present in table "director".
ALTER TABLE
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:11924: ERROR:  insert or update on table "movie_genres" violates foreign key constraint "movie_genres_gen_id_fkey"
DETAIL:  Key (gen_id)=(1001) is not present in table "genres".
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
REVOKE
REVOKE
GRANT
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12143: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12153: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12163: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12173: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12183: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12193: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12203: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12213: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12223: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12233: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12243: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12253: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12263: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
GRANT
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12283: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12293: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12303: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12313: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12323: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12333: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12343: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12353: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12363: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
GRANT
REVOKE
REVOKE
GRANT
GRANT
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12393: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12403: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12413: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12423: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12433: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12443: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12453: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12463: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12473: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12483: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12493: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12503: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12513: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
GRANT
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12533: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12543: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12553: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12563: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12573: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12583: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12593: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12603: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12613: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12623: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12633: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12643: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12653: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12663: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12673: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12683: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12693: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12703: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12713: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12723: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12733: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12743: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12753: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12763: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12773: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12783: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12793: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12803: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12813: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
GRANT
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12833: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12843: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12853: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12863: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12873: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12883: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12893: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12903: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12913: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12923: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12933: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12943: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12953: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12963: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12973: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12983: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:12993: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13003: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13013: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13023: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13033: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13043: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13053: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13063: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13073: ERROR:  role "user3" does not exist
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13080: ERROR:  relation "public.raster_overviews" does not exist
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13081: ERROR:  relation "public.raster_overviews" does not exist
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13082: ERROR:  relation "public.raster_overviews" does not exist
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13083: ERROR:  relation "public.raster_overviews" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13093: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13103: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13113: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13123: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13133: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13143: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13153: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13163: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13173: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13183: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13193: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13203: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13213: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13223: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13233: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13243: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13253: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13263: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13273: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13283: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13293: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13303: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13313: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13323: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13333: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13343: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13353: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13363: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13373: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13383: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13393: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13403: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13413: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13423: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13433: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13443: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13453: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13463: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13473: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13483: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13493: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13503: ERROR:  role "user3" does not exist
REVOKE
REVOKE
GRANT
psql:/docker-entrypoint-initdb.d/sqlexbackup.sql:13513: ERROR:  role "user3" does not exist
root@7ee148a6f6af:/#
```
### Conclusion
By following these steps, you will run fundamental procedures in Docker. Having access to backup and restore functions will allow you to develop using Docker. This functionality gives you the tool’s full flexibility.
