@echo off
call mvn clean package
call docker build -t com.fernando.apps/helpdeskng .
call docker rm -f helpdeskng
call docker run -d -p 8080:8080 -p 4848:4848 --name helpdeskng com.fernando.apps/helpdeskng