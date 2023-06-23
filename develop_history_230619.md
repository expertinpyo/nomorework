# TIL, NMW



## 0. 개요

Project Name : No More Work

NMW



Hanwha PM 



FE : Vue.js(or React.js)

BE : Java Spring Boot



웹 복습을 위한 프로젝트로, 회사 사람들의 추정 월급 및 근무 시간을 기록하기 위해 프로젝트를 시작한다.



## 1. Backend

0. Springboot 프로젝트 생성 전



빌드 : gradle

Language : Java 17

Spring boot : 3.1.0

dependency

- Spring Web
- Spring Data JPA
- H2 Database
- Lombok



1. Project 생성

start.spring.io에서 프로젝트 위와 같이 생성 후 인텔리제이에서 실행

처음 생성된 Application.java



​	@SpringBootApplication annotation

(출처 : https://velog.io/@jwkim/spring-boot-springapplication-annotation)

- Spring Boot의 가장 기본적인 설정을 서언한다.
- 자동 설정을 해주기 위한 어노테이션이다.
- org.springframework.boot.autoconfigure 패키지에 들어있다.
- 해당 어노테이션으로 들어가서 생성자를 확인해보면 여러 어노테이션이 존재하는데, 그 중 중요한 것들은 @SpringBootConfiguration / @EnableAutoConfiguration / @ComponentScan이다.
  - @EnableAutoConfiguration
    - Spring Boot의 Application Context 설정을 자동으로 수행하는 어노테이션
    - META-INF/spring.factories에 정의된 configuration 대상 클래스들을 bean으로 등록한다.
      - 개발자가 spring.factories에 클래스를 적어 넣으면 그 클래스 역시 auto configuration 된다.
      - 이 곳에 추가된 모든 클래스들을 항상 빈으로 등록하진 않음(만약 그렇다면 리소스 낭비 발생)
      - 현재 필요한 부분만 auto configure 되게끔 진행한다.
  - @SpringBootConfiguration
    - Context의 추가 bean들을 등록하는 것 혹은 추가적인 configuration classes를 import 하는 것을 가능하게 한다. Spring의 @Configuration 어노테이션을 대체한다.
  - @ComponentScan
    - application이 위치한 패키지에서 @Component 어노테이션 스캔을 가능하게 한다.



Convention : Google Java Intellij Convention



application.yml 설정 파일로 Spring Boot의 설정을 구성한다.

.env 환경변수를 사용해 민감한 변수들을 처리한다.



프로젝트 패키지 구조 23.06.18

- web
  - controller
  - service
- db
  - domain(entity)
  - repository

- dto

- security

  





### Controller

@RestController 어노테이션을 사용한다.

- @Controller vs @RestController

  - @Controller
    - 전통적인 MVC 패턴에서 사용함
    - 메서드 반환 시 ModelAndView 객체를 사용하거나 String 값을 반환
    - Json 형태의 반환을 위해선 @Mapping의 인자인 produces = 'application/json' 선언을 해줘야 함
  - @RestController
    - RESTfulAPI 개발할 때 주로 많이 사용. JSON, XML 형태로 데이터 반환이 쉬움
    - 단순 데이터 반환시에도 빠름. API 문서화 작업 시에도 @RestController 사용하는 것이 유리함
  - @Controller는 전통적인 웹 어플리케이션이나 뷰를 반환하는 경우에 좀 더 적합함. 서버에서 랜더링된 HTML 페이지를 반환하거나 Model, View를 사용해 복잡한 화면을 만들 때 사용된다.




### Domain

@Entity 어노테이션을 사용해 정의한다.

- 만약 @Entity로 선언한 table이 DB 안에 없다면?

  1. Application 실행 시점에서 Hibernate(or JPA 구현체)가 해당 @Entity를 감지하고 데이터베이스에 해당 table이 있는지 여부를 판단한다.
  2. 없다면, Hibernate는 테이블을 생성하기 위해 DDL(Data Define Language, Query) 스크립트를 실행하며, 이 스크립트는 @Entity의 속성과 주석을 기반으로 한다.
  3. Hibernate는 DDL 스크립트를 DB에 실행하여 Table을 생성한다. 이 때 Table 구조는 @Entity의 필드, 관계, 제약 조건 등을 기반으로 한다.
  4. Table이 성공적으로 생성되면 Hibernate는 @Entity 클래스를 매핑하여 DB와의 상호작용을 처리한다.
     - Hibernate가 자동으로 Table을 생성하는 기능은 개발 및 테스트 환경에서 주로 사용됨
     - 실제 운영 환경에서는 보안 및 관리 상 이유로 자동 테이블 생성을 하지 않을 수 있음
       - 이 때 DB 관리자가 수동으로 Table을 생성하고 필요한 인덱스, 제약 조건을 추가해야 함

  - 따라서, DB 관련 초기 작업을 진행하기 위해 크게
    1. DDL Auto
    2. import.sql
    3. Flyway || Liquibase를 사용하면 된다.

  

  - 위 세가지 방법 중 가장 권장되는 방법은 Flyway 혹은 Liquibase를 사용하는 것이다.

    - 나머지 두 방법은

      1. DDL Auto
         - 장점
           - 간단함. 개발 및 테스트 단계에서 유용함
           - application 시작 시점에서 자동으로 테이블 생성하므로 초기 설정이 쉬움
         - 단점
           - DB 스키마 변경을 자동으로 처리하므로 의도치 않은 데이터 손실 발생 가능성
           - 테이블 변경이 자동으로 되므로 DB가 의도치 않게 수정될 수 있음
      2. import.sql
         - 장점
           - 간단하고 직관적인 방법으로 DB 초기화 및 샘플 데이터 삽입에 유용함
           - Application 시작 단계에서 한번만 실행되므로 반복적인 실행 방지할 수 있음
         - 단점
           - 테이블이 이미 존재하는 경우에는 실행되지 않으므로, 초기 DB 스키마가 필요함
           - 파일에 직접 SQL 문을 작성해야 하므로 복잡한 DB 변경은 어려움

      의 장/단점이 있다.

  - Flyway or Liquibase

    - 장점
      - 마이그레이션 도구를 사용해 데이터베이스의 버전 관리와 변경 관리를 효과적으로 처리함
      - 변경 내역을 스크립트로 관리하므로 버전 간 일관성 유지할 수 있음
      - 협업, 배포 및 롤백에 용이
    - 단점
      - 초기 설정과 관리에 일정한 추가 작업 필요
      - 복잡한 DB 변경의 경우 스크립트 작성 및 관리에 시간 소모

    - 사용법
      1. 의존성 추가
         - 빌드 도구에 의존성 추가
      2. 마이그레이션 스크립트 작성
         - 변경 내역을 관리하기 위해 스크립트 사용함
         - DB에 수행할 변경 작업을 정의함
         - 일반적으로 SQL 형식이며 Table Create / Update / Delete / Data Insert 등을 포함함
         - ex) v1__Create_Table.sql 이런 식으로 정의함
      3. 마이그레이션 위치 설정
         - 마이그레이션 스크립트가 위치한 디렉토리를 알려줘야 함
      4. DB 연결 설정
         - application.yml 등에 DB 연결 설정을 구성해야 함
      5. 마이그레이션 실행
    - Flyway와 Liquibase 차이점
      - Flyway
        - 스크립트 기반 마이그레이션 도구
        - 간단하고 직관적인 사용 방법
        - 스크립트 파일 이름에 따라 버전 관리 수행함
        - 변경 내역  추적을 위해 메타데이터 테이블 사용함
        - SQL 스크립트 뿐만 아니라 자바 기반 마이그레이션 지원
        - Liquibase 대비 더 적은 구성
      - Liquibase
        - XML or YAML 포맷으로 변경 내역 정의하는 마이그레이션 도구
        - 스크립트 파일의 순차적인 실행 순서를 지정할 수 있음
        - 변경 내역 추적을 위해 메타데이터 테이블을 사용
        - 다양한 DB 시스템과의 호환성 가짐
        - 변경 내역의 롤백 지원함
        - 복잡한 스키마 변경 및 데이터 변환 작업에 유용함
  
    
  
  - 프로젝트에 Flyway 적용하기
  
    - 2023.06.22 현재 지속적으로 문제가 발생하고 있다. 프로젝트 진행을 위해 우선은 ddl-auto = update를 사용하고, flyway는 추후 적용하도록 한다.



- id는 @Id를 사용해 Primary Key임을 나타냄과 동시에 자동 증가를 하게 도와주는 @GeneratedValue(strategy = GenerationType.IDENTITY) 어노테이션을 사용해 정의한다.
- 





### Security - Login



로그인은 Google과 Naver OAuth2를 이용한다.

- 왜 OAuth2를 사용하는가?
  1. 안전한 인증
     - OAuth2는 사용자의 비밀번호를 직접 DB에 저장하지 않고, Provider(google, naver 등)로부터 발급된 토큰을 사용해 인증을 처리한다.
  2. 사용자 편의성
     - OAuth2를 사용하면 사용자는 자체 계정을 만들 필요가 없다.
  3. 타사 API 접근 용이
     - ex, google OAuth2를 사용하면 해당 계정의 Google Calendar에 접근 가능함



Spring Boot에서는 OAuth2 구현을 위해 하기의 의존성 주입을 실시한다.

- spring-boot-starter-security
  - 인증/인가를 도와주는 역할
- spring-boot-starter-oauth2-client
  - OAuth2 / OpenID 연결을 도와주는 역할





