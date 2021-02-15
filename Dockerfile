FROM openjdk:11
WORKDIR /code/
COPY ./build/libs/inteview-SNAPSHOT.jar .
EXPOSE 80
ENTRYPOINT ["java", "-jar", "inteview-SNAPSHOT.jar", "--server.port=80"]