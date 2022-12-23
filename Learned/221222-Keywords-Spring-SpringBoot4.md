# Spring/SpringBoot 키워드 정리
## IoC컨테이너란?
- 제어의 역전(Inversion of Control) 컨테이너
- 인스턴스 생성부터 소멸까지의 인스턴스 생명주기 관리를 개발자가 아닌  **컨테이너**가 대신 해준다!
- 객체관리 주차게 프레임워크(Container)가 되기 때문에 개발자는 로직에 집중할 수 있다.
    - IoC 컨테이너는 객체의 생성을 책임지고, 의존성을 관리한다.
    - POJO(Plain Old Java Object)의 생성, 초기화, 서비스, 소멸에 대한 권한을 가진다.
    - 개발자들이 직접 POJO를 생성할 수 있지만, 컨테이너에 맡김
    - 개발자는 비지니스 로직에 집중
    - 객체 생성 코드가 없으므로 TDD가 용이하다.<br><br>
    **POJO란?<br>
    주로 특정 자바 모델이나 기능, 프레임워크를 따르지 않는 객체를 지칭한다. Java Bean 객체가 대표적이며, getter/setter가 있다.
    <br><br>
## 스프링 빈(Bean)이란?
- Spring IoC 컨테이너가 관리하는 자바 객체를 빈(Bean)이라고 부른다.
- 기존 자바 프로그래밍에서는 Class를 생성하고 new를 통해 원하는 객체를 생성한 후 사용했었다.
- 하지만 스프링에서는, 스프링이 자바 객체를 생성하고 관리하는데 그 객체를 자바 Bean이라고 한다.
- 주로 어노테이션을 통해 Spring Bean으로 등록한다.

## Annotation 이란?
- Annotation은 클래스와 메서드에 추가하여 다양한 기능을 부여하는 역할을 한다.
- 클래스가 어떤 역할인지 정함
- Bean을 주입함
- getter/setter를 생성함
- Annotation 기능을 사용하면 코드량이 감소하고 유지보수가 용이해짐.

## Spring의 대표적인 Annotation과 역할
1. @Component
    - 개발자가 생성한 Class를 스프링의 Bean으로 등록할 때 사용!
2. @ComponentScan
    - 빈으로 등록 될 준비를 마친 클래스들을 스캔하여, 빈으로 등록해준다!
3. @Bean
    - 개발자가 제어 불가능한 외부 라이브러리와 같은 것들을 Bean으로 만들 때 사용
4. @Controller
    - 해당 Class가 Controller의 역할을 한다고 명시하기 위해 사용
5. @RequestHeader
    - Request의 header값을 가져올 수 있으며, 해당 Annotation을 쓴 메서드의 파라미터에 사용한다.
6. @RequestMapping
    - @RequestMapping(value="")와 같은 형태로 작성하며, 요청 들어온 URI의 값과 value값이 일치하면 해당 클래스나 메서드가 실행됨. Controller 객체 안의 메서드와 클래스에 적용 가능하다.
7. @RequestParam
    - URL에 전달되는 파라미터를 메소드의 인자와 매칭시켜, 파라미터를 받아서 처리할 수 있도록 해준다. Json 형식의 Body를 MessageConverter를 통해 자바 객체로 변환시켜준다.
8. @RequestBody
    - Body에 전달되는 데이터를 메서드의 인자와 매칭시켜, 데이터를 받아서 처리할 수 있는 Annotation
9. @ModelAttribute
    - 클라이언트가 전송하는 HTTP parameter, Body 내용을 Setter 함수를 통해 1:1로 객체에 연결한다. Json을 받아 처리할 수 없다.
10. @ResponseBody
    - 메서드에서 리턴되는 값이 View로 출력되지 않고 HTTP Response Body에 직접 쓰여진다. return 시 json, xml과 같은 데이터를 반환
11. @GetMapping
    - RequestMapping(Method = RequestMethod.GET)과 똑같은 역할
12. @PostMapping
    - RequestMapping(Method = RequestMethod.POST)과 똑같은 역할
## Lombok의 대표적인 Annotation과 역할
- Lombok은 코드량을 줄여주고 가독성을 높여주는 라이브러리이다.
1. @Setter
    - Class 모든 필드의 Setter Method를 생성해준다.
2. @Getter
    - Class 모든 필드의 Getter Method를 생성해준다.
3. @AllArgsConstructor
    - Class 모든 필드 값을 파라미터로 받는 생성자를 추가한다.
4. @NoArgsConstructor
    - Class 기본 생성자를 자동으로 추가해준다.
5. @ToString
    - Class 모든 필드의 toString method를 생성한다.