#!/bin/sh
mvn clean package && docker build -t com.fernando.apps/helpdeskng .
docker rm -f helpdeskng || true && docker run -d -p 8080:8080 -p 4848:4848 --name helpdeskng com.fernando.apps/helpdeskng