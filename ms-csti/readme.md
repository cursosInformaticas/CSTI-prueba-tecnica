# generar jar y deploy msvc-01
docker build -t msvc-01 . -f ./msvc-01/Dockerfile
docker run -p 8081:8081 --rm -d --name msvc-01 --network spring msvc01-provider

# generar jar y deploy msvc-02
docker build -t msvc-02 . -f ./msvc-02/Dockerfile
docker run -p 8082:8082 --rm -d --name msvc-02 --network spring msvc02-consumer

# generar jar y deploy msvc-03
docker build -t msvc-03 . -f ./msvc-03/Dockerfile
docker run -p 8083:8083 --rm -d --name msvc-03 --network spring msvc03-read


docker run -p 5532:5432 --name postgres14 --network spring -e POSTGRES_PASSWORD=huancho -e POSTGRES_DB=msvc_02 -d  -v data-postgres:/var/lib/postgresql/data --restart=always postgres:14-alpine



docker-compose down
