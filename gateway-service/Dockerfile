# 1단계: 빌드 단계
FROM gradle:8.6-jdk17 AS build

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 캐시를 활용하기 위해 Gradle Wrapper 및 소스 파일 복사
COPY ../gradlew .
COPY ../gradle gradle/
COPY ../build.gradle .
COPY ../settings.gradle .

RUN ./gradlew clean build -x test --stacktrace --no-daemon -Dspring.profiles.active=prod || return 0

# 프로젝트 소스 복사
COPY gateway-service/ gateway-service/

# 필요한 모듈 빌드
RUN ./gradlew :gateway-service:build -x test --stacktrace --no-daemon

# 2단계: 실행 단계
FROM amazoncorretto:17.0.12-alpine

# 작업 디렉토리 설정
WORKDIR /app

# 빌드 결과물 복사
COPY --from=build /app/gateway-service/build/libs/*.jar app.jar

# 컨테이너 실행 시 애플리케이션 실행
ENV SPRING_PROFILE="prod"
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILE}", "-jar", "app.jar"]