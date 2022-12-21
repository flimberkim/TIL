# Spring/SpringBoot 키워드 정리
## DAO, DTO, VO
### DAO(Data Access Object)
- DB의 데이터에 접근하기 위한 객체로, 직접 DB에 접근하여 데이터를 삽입, 삭제, 조회 등 조작할 수 있는 기능을 수행
- DB와 연결할 Connection까지 설정되어 있는 경우가 많다.
- 최근에는 DAO를 별도로 만드는 경우는 드물다.
### DTO(Data Transfer Object)
- 계층간(Controller, View, Business Layer(Model)) 데이터 교환을 위한 자바 빈즈
- 로직을 가지는 것은 아니고, getter/setter만 가진 클래스
- 주로 비동기 처리를 할 때 사용
### VO(Value Object)
- DTO와 달리 Read-Only 속석을 가지는 객체
- 주로 getter만 가지고 있음

## 결론
- 보통 Mapper - Repository - Service - Controller로 구성하여 작업하기 때문에 위에 언급한 것들 중 **DTO만 자주 사용하게 됨**
- DAO, VO는 필요한 상황일 때 만들어서 사용하면 될 것 같다!