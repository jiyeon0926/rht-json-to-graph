# 🛠️ 기술 스택
- Java 21
- Spring Boot 3.5.0 Version
- JPA
- QueryDSL
- MySQL

### QueryDSL 환경
- clean → compileJava 순서로 실행해 Q클래스 생성하기
- Build and run using : Gradle 설정
- Gradle이 아닌 IntelliJ IDEA일 경우, Q클래스 import 안 되는 이슈 발생

# 💡 기능
- 토큰 발급 (이메일 요청)
- 집계 정보 및 영상 상세 정보 조회
- 채널에 대한 영상 조회

# 🧩 설계 및 내용
각 기능에 대한 조회 API 내용을 [Notion](https://www.notion.so/JSON-API-1ffe22e7e41380ac8b35cdf7e22f74e5)에 정리

# 📁 프로젝트 구조
<details>
  <summary>프로젝트 구조</summary>
  <br>
  
```
+---java
|   \---com
|       \---example
|           \---graph
|               |   GraphApplication.java
|               |
|               +---domain
|               |   +---analytic
|               |   |   +---controller
|               |   |   |       AnalyticController.java
|               |   |   |
|               |   |   +---dto
|               |   |   |       AnalyticResDto.java
|               |   |   |       AnalyticTotalsResDto.java
|               |   |   |       AnalyticVideoDetailDto.java
|               |   |   |       AnalyticVideoDto.java
|               |   |   |
|               |   |   +---entity
|               |   |   |       Analytic.java
|               |   |   |
|               |   |   +---repository
|               |   |   |       AnalyticCustomRepository.java
|               |   |   |       AnalyticCustomRepositoryImpl.java
|               |   |   |       AnalyticRepository.java
|               |   |   |
|               |   |   \---service
|               |   |           AnalyticService.java
|               |   |
|               |   \---user
|               |       +---controller
|               |       |       AuthController.java
|               |       |
|               |       +---dto
|               |       |       TokenDto.java
|               |       |       UserEmailReqDto.java
|               |       |
|               |       +---entity
|               |       |       User.java
|               |       |
|               |       +---repository
|               |       |       UserRepository.java
|               |       |
|               |       \---service
|               |               AuthService.java
|               |
|               \---global
|                   +---auth
|                   |   |   AuthenticationScheme.java
|                   |   |   DelegatedAccessDeniedHandler.java
|                   |   |   DelegatedAuthenticationEntryPoint.java
|                   |   |
|                   |   \---jwt
|                   |           JwtAuthFilter.java
|                   |           JwtProvider.java
|                   |
|                   +---config
|                   |       QueryDslConfig.java
|                   |       WebConfig.java
|                   |
|                   \---exception
|                       \---handler
|                               GlobalExceptionHandler.java
|
\---resources
    |   application.yml
    |
    +---static
    \---templates
```
</details>
