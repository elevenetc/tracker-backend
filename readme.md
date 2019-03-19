## Test
```bash
./gradlew test
```
## Build Service 
```bash
./gradlew build
```
## Build Docker Image
```bash
docker build -t tracker .
```
## Run
```bash
docker run \
-e TRACKER_DB_URL='localhost' \
-e TRACKER_DB_PORT='3306' \
-e TRACKER_DB_NAME='tracker' \
-e TRACKER_DB_USER_NAME='root' \
-e TRACKER_DB_PASSWORD='password' \
-e TRACKER_ACTIVE_PROFILES='production' \
tracker:latest 
```