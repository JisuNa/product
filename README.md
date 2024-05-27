# product

## 개발환경
- Kotlin
- JDK 21
- Spring Boot 3
- Spring Data JPA
- H2
- Kotest

## 프로젝트 구조
### product-api
- 상품 서비스를 담당하는 API 모듈
- port: 8080

### product-manager
- 상품 관리를 담당하는 API 모듈
- port: 8090

### product-domain-rdb
- 상품 데이터베이스 연결을 담당하는 모듈
- product-api, product-manager 모듈에서 의존

## 코드 빌드, 테스트, 실행

### product-api
```shell
# 빌드
./gradlew product-api:build

# 테스트
./gradlew product-api:test

# 실행
./gradlew product-api:bootRun
```

### product-manager
```shell
#빌드
./gradlew product-manager:build

# 테스트
./gradlew product-manager:test

# 실행
./gradlew product-manager:bootRun
```