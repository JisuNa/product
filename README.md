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

### 빌드
```shell
./gradlew musinsa-product:product-api clean build
./gradlew musinsa-product:product-manager clean build
```

### 테스트
```shell
./gradlew musinsa-product:product-api test
./gradlew musinsa-product:product-manager test
```

### 실행
```shell
./gradlew musinsa-product:product-api bootRun
./gradlew musinsa-product:product-manager bootRun
```