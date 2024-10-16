
### Contents

* [MERN stack Application with Docker Overview](#)
* [Setup Nodejs App](#)
* [Create Dockerfile for Nodejs App](#)
* [Setup React App](#)
* [Create Dockerfile for React App](#)
* [Write Docker Compose for MERN application](#)
* [Docker Compose Environment variables](#)
* [Run MERN stack with Docker Compose](#)
* [Stop the Application](#)
* [Conclusion](#)
* [Source Code](#)

### MERN stack Application with Docker Overview
Assume that we have a fullstack React + Nodejs Express + MongoDB Application (MERN stack).
The problem is to containerize a system that requires more than one Docker container:

- React for UI
- Node.js Express for API
- MongoDB for database
- Docker Compose helps us setup the system more easily and efficiently than with only Docker. We’re gonna following these steps:

### Setup Nodejs App working with MongoDB database.
- Create Dockerfile for Nodejs App.
- Setup React  App.
- Create Dockerfile for  React App.
- Write  Docker Compose configurations in YAML file.
- Set Environment variables for  Docker Compose
- Run the system.
  
### Directory Structure:

docker-mern-nginx-example-structure
### Setup Nodejs App
You can read and get Github source code from one of following tutorials:

- Node.js, Express & MongoDb: Build a CRUD Rest Api example
- Node.js + MongoDB: User Authentication & Authorization with JWT


Using the code base above, we put the  Nodejs project in bezkoder-api folder and modify some files to work with environment variables.

Firstly, let’s add dotenv module into package.json.
```
{
  ...
  "dependencies": {
    "dotenv": "^10.0.0",
    ...
  }
}
```
Next we import dotenv in server.js and use process.env for setting up CORS and port.
```
require("dotenv").config();
...
var corsOptions = {
  origin: process.env.CLIENT_ORIGIN || "http://localhost:8081"
};

app.use(cors(corsOptions));
..
// set port, listen for requests
const PORT = process.env.NODE_DOCKER_PORT || 8080;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}.`);
});
```
Then we change modify database configuration and initialization.

### app/config/db.config.js
```
const {
  DB_USER,
  DB_PASSWORD,
  DB_HOST,
  DB_PORT,
  DB_NAME,
} = process.env;

module.exports = {
  url: `mongodb://${DB_USER}:${DB_PASSWORD}@${DB_HOST}:${DB_PORT}/${DB_NAME}?authSource=admin`
};
```
We also need to make a .env sample file that shows all necessary arguments.

### bezkoder-api/.env.sample
```
DB_HOST=localhost
DB_USER=root
DB_PASSWORD=123456
DB_NAME=bezkoder_db
DB_PORT=27017

NODE_DOCKER_PORT=8080

CLIENT_ORIGIN=http://127.0.0.1:8081
```
### Create Dockerfile for Nodejs App
Dockerfile defines a list of commands that  Docker uses for setting up the  Node.js  application environment. So we put the file in bezkoder-api folder.

Because we will use Docker Compose, we won’t define all the configuration commands in this Dockerfile.

### bezkoder-api/Dockerfile
```yaml
FROM node:14

WORKDIR /bezkoder-api
COPY package.json .
RUN npm install
COPY . .
CMD npm start
```
Let me explain some points:

- FROM: install the image of the  Node.js version.
- WORKDIR: path of the working directory.
- COPY: copy package.json file to the container, then the second one copies all the files inside the project directory.
- RUN: execute a command-line inside the container: npm install to install the dependencies in package.json.
- CMD: run script npm start after the image is built.
### Setup React App
You can read and get Github source code from one of following tutorials:
- React CRUD example to consume Web API
- React Typescript CRUD example to consume Web API
- React Redux CRUD App example with Rest API
- React Hooks CRUD example to consume Web API
- React Table example: CRUD App with react-table v7
- React Material UI examples with a CRUD Application
- React JWT Authentication & Authorization example
- React + Redux: JWT Authentication & Authorization example

Using the code base above, we put the  React project in bezkoder-ui folder and do some work.

Firstly, let’s remove .env file because we’re gonna work with environment variable from  Docker.

Then we open http-common.js for updating baseURL of axios instance with process.env.REACT_APP_API_BASE_URL.
```
import axios from "axios";

export default axios.create({
  baseURL: process.env.REACT_APP_API_BASE_URL || 'http://localhost:8080/api',
  headers: {
    "Content-type": "application/json"
  }
});
```
### Create Dockerfile for React App
We’re gonna deploy the  React app behind an Nginx server.

Same as  Nodejs, we put Dockerfile inside bezkoder-ui folder.

### bezkoder-upi/Dockerfile

# Stage 1
```
FROM node:14 as build-stage

WORKDIR /bezkoder-ui
COPY package.json .
RUN npm install
COPY . .

ARG REACT_APP_API_BASE_URL
ENV REACT_APP_API_BASE_URL=$REACT_APP_API_BASE_URL
```
### RUN npm run build

# Stage 2
```
FROM nginx:1.17.0-alpine

COPY --from=build-stage /bezkoder-ui/build /usr/share/nginx/html
EXPOSE $REACT_DOCKER_PORT

CMD nginx -g 'daemon off;'
```
### There are two stage:
Stage 1: Build the  React  application

- FROM: install the image of the Node.js version.
- WORKDIR: path of the working directory.
- COPY: copy package.json file to the container, then the second one copies all the files inside the project directory.
- RUN: execute a command-line inside the container: npm install to install the dependencies in package.json.
- ARG and ENV: get argument and set environment variable (prefix REACT_APP_ is required).
- run script npm run build after the image is built, the product will be stored in build folder.

Stage 2: Serve the  React  application with Nginx

- install the image of the nginx alpine version.
- copy the  react build from Stage 1 into /usr/share/nginx/html folder.
- expose port (should be 80) to the  Docker host.
- daemon off; directive tells Nginx to stay in the foreground.
  
### Write Docker Compose for MERN application
On the root of the project directory, we’re gonna create the docker-compose.yml file for the  MERN stack. Follow version 3 syntax defined by Docker:

```yaml
version: '3.8'

services: 
    mongodb:
    bezkoder-api:
    bezkoder-ui:

volumes:
```
### networks:
- version: Docker Compose file format version will be used.
- services: individual services in isolated containers. Our application has three services: bezkoder-ui (React), bezkoder-api (Nodejs) and mongodb (MongoDB database).
- volumes: named volumes that keeps our data alive after restart.
- networks: facilitate communication between containers

Let’s implement the details.

### docker-compose.yml
```yaml
version: '3.8'

services:
  mongodb:
    image: mongo:5.0.2
    restart: unless-stopped
    env_file: ./.env
    environment:
      - MONGO_INITDB_ROOT_USERNAME=$MONGODB_USER
      - MONGO_INITDB_ROOT_PASSWORD=$MONGODB_PASSWORD
    ports:
      - $MONGODB_LOCAL_PORT:$MONGODB_DOCKER_PORT
    volumes:
      - db:/data/db
    networks:
      - backend
  
  bezkoder-api:
    depends_on:
      - mongodb
    build: ./bezkoder-api
    restart: unless-stopped
    env_file: ./.env
    ports:
      - $NODE_LOCAL_PORT:$NODE_DOCKER_PORT
    environment:
      - DB_HOST=mongodb
      - DB_USER=$MONGODB_USER
      - DB_PASSWORD=$MONGODB_PASSWORD
      - DB_NAME=$MONGODB_DATABASE
      - DB_PORT=$MONGODB_DOCKER_PORT
      - CLIENT_ORIGIN=$CLIENT_ORIGIN
    networks:
      - backend
      - frontend

  bezkoder-ui:
    depends_on:
      - bezkoder-api
    build:
      context: ./bezkoder-ui
      args:
        - REACT_APP_API_BASE_URL=$CLIENT_API_BASE_URL
    ports:
      - $REACT_LOCAL_PORT:$REACT_DOCKER_PORT
    networks:
      - frontend  

volumes: 
  db:

networks:
  backend:
  frontend:
–  mongodb:
```
- image: official  Docker image
- restart: configure the restart policy
- env_file: specify our .env path that we will create later
- environment: provide setting using environment variables
- ports: specify ports will be used
- volumes: map volume folders
- networks: join backend network

### – bezkoder-api:

depends_on: dependency order,  mongodb service is started before bezkoder-api
build: configuration options that are applied at build time that we defined in the Dockerfile with relative path
environment: environmental variables that  Node  application uses
networks: join both backend and frontent networks

### – bezkoder-ui:

- depends_on: start after bezkoder-api
- build-args: add build arguments – environment variables accessible only during the build process
- networks: join only frontent network
You should note that the host port (LOCAL_PORT) and the container port (DOCKER_PORT) is different. Networked service-to-service communication uses the container port, and the outside uses the host port.

### Docker Compose Environment variables
In the service configuration, we used environmental variables defined inside the .env file. Now we start writing it.

### .env
```
MONGODB_USER=root
MONGODB_PASSWORD=123456
MONGODB_DATABASE=bezkoder_db
MONGODB_LOCAL_PORT=7017
MONGODB_DOCKER_PORT=27017

NODE_LOCAL_PORT=6868
NODE_DOCKER_PORT=8080

CLIENT_ORIGIN=http://127.0.0.1:8888
CLIENT_API_BASE_URL=http://127.0.0.1:6868/api

REACT_LOCAL_PORT=8888
REACT_DOCKER_PORT=80
```
### Run MERN stack with Docker Compose
We can easily run the whole with only a single command:
```
docker compose up
```
Docker will pull the  MongoDB and  Node.js images (if our machine does not have it before).

The services can be run on the background with command:
```
docker compose up -d
```
```
$ docker compose up -d
Creating network "react-node-mongodb_backend" with the default driver
Creating network "react-node-mongodb_frontend" with the default driver
Creating volume "react-node-mongodb_db" with default driver
Pulling mongodb (mongo:5.0.2)...
5.0.2: Pulling from library/mongo
16ec32c2132b: Pull complete
6335cf672677: Pull complete
cbc70ccc8ebe: Pull complete
0d1a3c6bd417: Pull complete
960f3b9b27d3: Pull complete
aff995a136b4: Pull complete
4249be7550a8: Pull complete
cc105ff5aa3c: Pull complete
82819807d07a: Pull complete
81447d2c233f: Pull complete
Digest: sha256:93ea50c5f15f9814870b3509449d327c5bc4d38f2b17c20acec528472811a723
Status: Downloaded newer image for mongo:5.0.2
Building bezkoder-api
Sending build context to Docker daemon  20.48kB
Step 1/6 : FROM node:14
 ---> 256d6360f157
Step 2/6 : WORKDIR /bezkoder-api
 ---> Running in 630b36161cfc
Removing intermediate container 630b36161cfc
 ---> cce099c5509c
Step 3/6 : COPY package.json .
 ---> 966883cd8e24
Step 4/6 : RUN npm install
 ---> Running in 246256e84187
npm notice created a lockfile as package-lock.json. You should commit this file.
npm WARN node-express-mongodb@1.0.0 No repository field.

added 82 packages from 128 contributors and audited 82 packages in 8.017s

2 packages are looking for funding
  run `npm fund` for details

found 0 vulnerabilities

Removing intermediate container 246256e84187
 ---> bdab72a5d37b
Step 5/6 : COPY . .
 ---> e9069d0ee44a
Step 6/6 : CMD npm start
 ---> Running in 6f63286cae18
Removing intermediate container 6f63286cae18
 ---> 65452914f005
Successfully built 65452914f005
Successfully tagged react-node-mongodb_bezkoder-api:latest
WARNING: Image for service bezkoder-api was built because it did not already exist. To rebuild this image you must use `docker compose build` or `docker compose up --build`.
Building bezkoder-ui
Sending build context to Docker daemon  67.07kB
Step 1/12 : FROM node:14 as build-stage
 ---> 256d6360f157
Step 2/12 : WORKDIR /bezkoder-ui
 ---> Running in e135a434b996
Removing intermediate container e135a434b996
 ---> 80292facc18b
Step 3/12 : COPY package.json .
 ---> 595fbe352edd
Step 4/12 : RUN npm install
 ---> Running in 9d8ef80ff165
 
added 1661 packages from 793 contributors and audited 1666 packages in 115.944s

94 packages are looking for funding
  run `npm fund` for details

found 10 vulnerabilities (1 low, 5 moderate, 4 high)
  run `npm audit fix` to fix them, or `npm audit` for details
Removing intermediate container 9d8ef80ff165
 ---> 18a4f1382bc7
Step 5/12 : COPY . .
 ---> f99e2a8ef053
Step 6/12 : ARG REACT_APP_API_BASE_URL
 ---> Running in 47dca1457fb2
Removing intermediate container 47dca1457fb2
 ---> 8986f1482c8d
Step 7/12 : ENV REACT_APP_API_BASE_URL=$REACT_APP_API_BASE_URL
 ---> Running in 95687ba2d936
Removing intermediate container 95687ba2d936
 ---> 7a20778bca2b
Step 8/12 : RUN npm run build
 ---> Running in d0074ed04394

> react-crud@0.1.0 build /bezkoder-ui
> react-scripts build

Creating an optimized production build...
Compiled successfully.

File sizes after gzip:

  52.78 KB  build/static/js/2.c9e8967b.chunk.js
  22.71 KB  build/static/css/2.fa6c921b.chunk.css
  2.39 KB   build/static/js/main.aae2fe51.chunk.js
  776 B     build/static/js/runtime-main.99b514f4.js
  144 B     build/static/css/main.9c6cdb86.chunk.css

The project was built assuming it is hosted at /.
You can control this with the homepage field in your package.json.

The build folder is ready to be deployed.
You may serve it with a static server:

  npm install -g serve
  serve -s build

Find out more about deployment here:

  bit.ly/CRA-deploy

Removing intermediate container d0074ed04394
 ---> 9cd424a1901b
Step 9/12 : FROM nginx:1.17.0-alpine
 ---> bfba26ca350c
Step 10/12 : COPY --from=build-stage /bezkoder-ui/build /usr/share/nginx/html
 ---> 2b4cbdbd908e
Step 11/12 : EXPOSE $REACT_DOCKER_PORT
 ---> Running in ced23b1795d6
Removing intermediate container ced23b1795d6
 ---> 2850341d70f0
Step 12/12 : CMD nginx -g 'daemon off;'
 ---> Running in d596e17eec46
Removing intermediate container d596e17eec46
 ---> fef41917c48b
Successfully built fef41917c48b
Successfully tagged react-node-mongodb_bezkoder-ui:latest
WARNING: Image for service bezkoder-ui was built because it did not already exist. To rebuild this image you must use `docker compose build` or `docker compose up --build`.
Creating react-node-mongodb_mongodb_1 ... done
Creating react-node-mongodb_bezkoder-api_1 ... done
Creating react-node-mongodb_bezkoder-ui_1  ... done
```
Now you can check the current working containers:
```
$ docker ps
CONTAINER ID   IMAGE                             COMMAND                  CREATED        STATUS         PORTS                                         NAMES
c9ee5ce3c370   react-node-mongodb_bezkoder-ui    "/bin/sh -c 'nginx -…"   Up 2 minutes   Up 2 minutes   0.0.0.0:8888->80/tcp, :::8888->80/tcp         react-node-mongodb_bezkoder-ui_1
f0c7d4174bdb   react-node-mongodb_bezkoder-api   "docker-entrypoint.s…"   Up 2 minutes   Up 2 minutes   0.0.0.0:6868->8080/tcp, :::6868->8080/tcp     react-node-mongodb_bezkoder-api_1
2f8390fc81dd   mongo:5.0.2                       "docker-entrypoint.s…"   Up 2 minutes   Up 2 minutes   0.0.0.0:7017->27017/tcp, :::7017->27017/tcp   react-node-mongodb_mongodb_1
```
And  Docker images:
```
$ docker images
REPOSITORY                        TAG      IMAGE ID       CREATED         SIZE
react-node-mongodb_bezkoder-ui    latest   fef41917c48b   3 minutes ago   22MB
react-node-mongodb_bezkoder-api   latest   65452914f005   6 minutes ago   961MB
mongo                             5.0.2    269b735e72cb   7 minutes ago   682MB
```
### Test the  React UI:

docker-mern-nginx-example-test-ui
 MongoDB Database:

docker-mern-nginx-example-test-database
And  Node.js Express API:

docker-mern-nginx-example-test-api
### Stop the Application
Stopping all the running containers is also simple with a single command:
> docker compose down
```
$ docker compose down
Stopping react-node-mongodb_bezkoder-ui_1  ... done
Stopping react-node-mongodb_bezkoder-api_1 ... done
Stopping react-node-mongodb_mongodb_1      ... done
Removing react-node-mongodb_bezkoder-ui_1  ... done
Removing react-node-mongodb_bezkoder-api_1 ... done
Removing react-node-mongodb_mongodb_1      ... done
Removing network react-node-mongodb_backend
Removing network react-node-mongodb_frontend
```
If you need to stop and remove all containers, networks, and all images used by any service in docker-compose.yml file, use the command:
> docker compose down --rmi all

C:\Users\HP>docker ps
CONTAINER ID   IMAGE                               COMMAND                  CREATED       STATUS       PORTS                     NAMES
ea084dbf20ef   docker-compose-nodejs-mongodb-app   "docker-entrypoint.s…"   3 hours ago   Up 3 hours   0.0.0.0:6868->8080/tcp    docker-compose-nodejs-mongodb-app-1
60849adde661   mongo:5.0.2                         "docker-entrypoint.s…"   3 hours ago   Up 3 hours   0.0.0.0:7017->27017/tcp   docker-compose-nodejs-mongodb-mongodb-1

The error message `‘mongo’ is not recognized as an internal or external command` indicates that the MongoDB shell (`mongo`) is not installed or not included in your system's PATH.

Here’s how you can address this issue and perform the necessary checks to ensure MongoDB is properly running and accessible:

### 1. **Install MongoDB Shell**

If the MongoDB shell (`mongo`) is not installed, you need to install it. Here’s how to install it depending on your operating system:

#### **For Windows:**

1. **Download MongoDB Shell:**

   Download the MongoDB Shell from the [MongoDB Download Center](https://www.mongodb.com/try/download/shell). Choose the appropriate version for Windows.

2. **Install MongoDB Shell:**

   Follow the installation instructions provided on the download page.

3. **Add MongoDB Shell to PATH:**

   To run `mongo` from any command prompt, you need to add its installation directory to your system’s PATH variable.

   - Open **Control Panel** > **System and Security** > **System**.
   - Click **Advanced system settings**.
   - Click the **Environment Variables** button.
   - Find the **Path** variable in the **System variables** section, and click **Edit**.
   - Click **New**, and add the path to the MongoDB bin directory (e.g., `C:\Program Files\MongoDB\Server\<version>\bin`).
   - Click **OK** to close all dialogs.

4. **Verify Installation:**

   Open a new command prompt and run:

   ```sh
   mongo --version
   ```

   This should display the version of the MongoDB shell.

#### **For macOS/Linux:**

If you’re using macOS or Linux, you can usually install MongoDB tools via package managers:

- **macOS:**

  ```sh
  brew tap mongodb/brew
  brew install mongodb-community-shell
  ```

- **Linux:**

  Follow the installation instructions for your specific distribution from the [MongoDB Documentation](https://docs.mongodb.com/manual/administration/install-on-linux/).

### 2. **Check MongoDB Connectivity Without the Shell**

If you want to test connectivity without installing the shell, you can use a tool like `telnet` or `nc` (netcat) to check if the port is open:

**Using `telnet`:**

```sh
telnet localhost 7017
```

If the port is open, you should see a connection message. If not, the command will fail.

**Using `nc` (netcat):**

```sh
nc -zv localhost 7017
```

This command will check if the port is open and listening.

### 3. **Verify MongoDB Compass Connection**

Since `mongo` is not available, you can use MongoDB Compass to verify connectivity:

1. **Open MongoDB Compass.**
2. **Enter Connection Details:**
   - **URI:** `mongodb://localhost:7017` (Here, **Hostname:** `localhost` and **Port:** `7017`)
   - **Authentication Method:** `Username / Password`
   - **Username:** `root`
   - **Password:** `123456`
   - **Authentication Database:** `admin`
   - **Default Database:** `bezkoder_db` (optional)

    `mongodb://root:123456@localhost:7017/bezkoder_db`

4. **Click Connect** and check if Compass can connect.
5. **Verify In Postman**
- **POST URL:** `http://localhost:6868/api/tutorials`
- **Request Body:** 
```json
{
    "title":"firozkhan",
    "description":"example"
}
```
### 4. **Troubleshoot Docker Port Mapping**

Ensure the Docker container is correctly mapping the port:

```sh
docker port mongodb
```

Verify it shows `27017/tcp -> 0.0.0.0:7017`.

### 5. **Restart Docker Container**

Restart the container to ensure it’s up and running:

```sh
docker restart mongodb
```

### Conclusion
Today we’ve successfully created  MERN application with Docker and Nginx. Now we can deploy MERN stack: React + Nodejs Express and MongoDB on a very simple way: docker-compose.yml.

You can apply this way to one of following project:

- – React + Node.js + Express + MongoDB example: CRUD App
- – React + Node.js Express + MongoDB: User Authentication with JWT example

Happy Learning! See you again.

### Source Code
The source code for this tutorial can be found at Github

### External

# `mongo` + `docker`

`mongo >= 6`: `init-mongo.js` + `MONGO_INITDB_DATABASE` in `.env-mongo` \
`mongo < 6`: `init-mongo.sh` + no `MONGO_INITDB_DATABASE` in `.env-mongo`

`.env`:

```sh
MONGO_USER=user
MONGO_PASSWORD=userpasswd
MONGO_DB=foo
```

`.env-mongo`:

```sh
MONGO_INITDB_ROOT_USERNAME=root
MONGO_INITDB_ROOT_PASSWORD=rootpasswd
MONGO_INITDB_DATABASE=foo
```

`docker-compose.yml`:

```yaml
services:
  app:
    build: .
    command: sh -euc '
        wait4ports tcp://mongo:27017
        ; carton exec perl a.pl'
    init: yes
    env_file: .env
    volumes:
      - .:/app

  mongo:
    # image: mongo:3.0-wheezy
    # image: mongo:3.2-jessie
    # image: mongo:3.4-jessie
    # image: mongo:3.6-jessie
    # image: mongo:4.0-bionic
    # image: mongo:4.2-bionic
    # image: mongo:4.4-focal
    # image: mongo:5-focal
    image: mongo:6-jammy
    env_file: [.env-mongo, .env]
    volumes:
      - mongo:/data/db
      # - ./init-mongo.sh:/docker-entrypoint-initdb.d/init-mongo.sh
      - ./init-mongo.js:/docker-entrypoint-initdb.d/init-mongo.js

volumes:
  mongo:
```

`Dockerfile`:

```dockerfile
FROM alpine:3.17
RUN apk add perl-app-cpanminus build-base perl-dev wait4ports \
    && cpanm Carton
WORKDIR /app
```

`cpanfile`:

```pl
requires 'MongoDB', '2.2.2';
```

`a.pl`:

```pl
use strict;
use warnings;
use MongoDB;
use Data::Dumper;

my $client = MongoDB->connect('mongodb://mongo', {
    username => $ENV{'MONGO_USER'},
    password => $ENV{'MONGO_PASSWORD'},
    db_name => $ENV{'MONGO_DB'},
});
print Dumper $client->db('foo')->run_command([connectionStatus => 1]);
my $collection = $client->ns('foo.bar');
my $result = $collection->insert_one({some => 'data'});
my $data = $collection->find_one({_id => $result->inserted_id});
print Dumper $data;
```

`init-mongo.js`:

```js
db.getSiblingDB('admin').auth(
    process.env.MONGO_INITDB_ROOT_USERNAME,
    process.env.MONGO_INITDB_ROOT_PASSWORD
);
db.createUser({
    user: process.env.MONGO_USER,
    pwd: process.env.MONGO_PASSWORD,
    roles: ["readWrite"],
});
```

`init-mongo.sh`:

```sh
q_MONGO_USER=`jq --arg v "$MONGO_USER" -n '$v'`
q_MONGO_PASSWORD=`jq --arg v "$MONGO_PASSWORD" -n '$v'`
mongo -u "$MONGO_INITDB_ROOT_USERNAME" -p "$MONGO_INITDB_ROOT_PASSWORD" admin <<EOF
    use foo;
    db.createUser({
        user: $q_MONGO_USER,
        pwd: $q_MONGO_PASSWORD,
        roles: ["readWrite"],
    });
EOF

# process >= 6
# mongosh - mongo >= 5
# _getEnv() - mongo == 4.4

# _getEnv() is undocumented
# https://stackoverflow.com/a/67037065/52499
# mongo -- "$MONGO_DB" <<EOF
#     db.getSiblingDB('admin').auth(
#         _getEnv('MONGO_INITDB_ROOT_USERNAME'),
#         _getEnv('MONGO_INITDB_ROOT_PASSWORD'),
#     );
#     db.createUser({
#         user: _getEnv('MONGO_USER'),
#         pwd: _getEnv('MONGO_PASSWORD'),
#         roles: ["readWrite"],
#     });
# EOF
```

```
$ docker-compose up
```


Your setup for running MongoDB with Docker, and integrating it with a Perl application, looks quite thorough. Here’s a detailed breakdown of what you have and some adjustments or clarifications you might need:

### Explanation

1. **`.env` and `.env-mongo` Files**:
   - `.env` contains environment variables for the application.
   - `.env-mongo` contains environment variables specific to MongoDB initialization.

2. **`docker-compose.yml`**:
   - Defines two services: `app` and `mongo`.
   - `mongo` uses MongoDB version 6 with initialization scripts.

3. **`Dockerfile`**:
   - Sets up the Perl environment with necessary dependencies.

4. **`cpanfile`**:
   - Specifies the Perl modules required.

5. **`a.pl`**:
   - A Perl script that connects to MongoDB and performs basic operations.

6. **`init-mongo.js` and `init-mongo.sh`**:
   - Initialization scripts for creating a user in MongoDB.

### Adjustments and Suggestions

1. **`docker-compose.yml`**:
   - Your current configuration is mostly correct, but there are some nuances based on MongoDB versions. Since you’re using MongoDB 6, you should focus on using the JavaScript initialization script (`init-mongo.js`) for MongoDB >= 6. The `mongo-init.sh` script is useful for versions < 6.

   ```yaml
   services:
     app:
       build: .
       command: sh -euc '
           wait4ports tcp://mongo:27017
           ; carton exec perl a.pl'
       env_file: .env
       volumes:
         - .:/app

     mongo:
       image: mongo:6-jammy
       env_file: [.env-mongo, .env]
       volumes:
         - mongo:/data/db
         - ./init-mongo.js:/docker-entrypoint-initdb.d/init-mongo.js:ro
         # Uncomment the following line if you need to use the shell script for older MongoDB versions.
         # - ./init-mongo.sh:/docker-entrypoint-initdb.d/init-mongo.sh:ro

   volumes:
     mongo:
   ```

2. **Initialization Script**:
   - **For MongoDB >= 6**: `init-mongo.js` is correct. It uses JavaScript and `mongosh` to run initialization commands.
   - **For MongoDB < 6**: Use `init-mongo.sh`. Ensure that `jq` is available in the container if you need it. Also, make sure `init-mongo.sh` has executable permissions (`chmod +x init-mongo.sh`).

3. **MongoDB User Creation**:
   - **For MongoDB >= 5**: Use `mongosh` in `init-mongo.js` to interact with MongoDB. Ensure the initialization script handles authentication and user creation.
   - **For MongoDB < 5**: Use the `mongo` shell in `init-mongo.sh`. Ensure `jq` is available for JSON manipulation if used.

4. **Checking MongoDB Connection**:
   - The `wait4ports` utility is a good approach to ensure that MongoDB is up and ready before running your Perl script.

5. **Permissions and Paths**:
   - Ensure that the paths to your initialization scripts (`init-mongo.js` and `init-mongo.sh`) are correct and that the files have the right permissions. For Docker volumes, ensure the `:ro` (read-only) option is used to prevent accidental modifications.

6. **Debugging**:
   - If you encounter issues, use Docker logs to check the output of your initialization scripts. For example:
     ```sh
     docker-compose logs mongo
     docker-compose logs mongo-init
     ```

### Final Setup

Here's a concise summary for your setup:

- **Use the appropriate initialization script for MongoDB versions**:
  - MongoDB >= 6: `init-mongo.js`
  - MongoDB < 6: `init-mongo.sh`

- **Ensure the scripts are correctly mounted** and have the necessary permissions.

- **Verify connection and initialization** by checking Docker logs and using the `wait4ports` tool to ensure MongoDB is ready before running your application.

This setup should help you initialize MongoDB and connect your Perl application seamlessly.
