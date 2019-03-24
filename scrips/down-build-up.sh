#!/usr/bin/env bash
docker-compose down -v
./gradlew build
docker build -t tracker:1.0.0 .
docker-compose up