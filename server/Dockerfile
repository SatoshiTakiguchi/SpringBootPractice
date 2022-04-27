
FROM openjdk:15

ENV APP_ROOT /app

COPY . $APP_ROOT
WORKDIR $APP_ROOT

# ENTRYPOINT ["sh", "./gradlew", "bootRun"]
ENTRYPOINT ["sh", "./gradlew", "test","jacocoTestReport"]