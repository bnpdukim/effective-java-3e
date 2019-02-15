## 익명 클래스보다는 람다를 사용하라
* 함수 타입을 표현할 때 추상 메서드를 하나만 담은 인터페이스를 사용
  - 함수 객체(function object)
    - 인터페이스의 인스턴스
    - 익명 클래스를 이용하여 만듬
```
Collections.sort(words, new Comparator<String>() {
  public int compare(String s1, String s2) {
    return Integer.compare(s1.length(), s2.length());
  }
});
```
* 익명클래스는 코드가 너무 길어지므로 함수형 프로그래밍에 적합하지 않음
* 함스형 인터페이스
  - 자바8에서는 추상 메서드 하나짜리 인터페이스
  - 인스턴스를 람다식(labda expression)을 사용해 만들수 있음
```
Collections.sort( words, 
  (s1,s2) -> Integer.compare( s1.length(), s2.length() ) 
);
```
* 람다
  - 컴파일러가 문맥을 살펴 타입을 추론
  - 타입을 명시해야 코드가 더 명확할 때만 제외하고는 매개변수 타입 생략
* 람다 자리에 비교자 생성 메서드를 사용하면 코드를 더 간결하게 만듬
  - <https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#sort-java.util.List-java.util.Comparator->
```
Collections.sort( words, comparingInt(String::length) );
```
* List 인터페이스에 추가된 sort 메소드를 이용하면 더욱 간결해짐
  - <https://docs.oracle.com/javase/8/docs/api/java/util/List.html#sort-java.util.Comparator->
```
words.sort( comparingInt(String::length) );
```

* 상수별 클래스 몸체를 구현하는 방식보다는 열거 타입에 인스턴스를 두는 편이 나음(item 34) (code)

* 상수별 클래스 몸체의 활용처
  - 람다는 이름이 없고 문서화를 못함
    - 코드 자체로 동작이 명확히 설명되지 않거나 코드 줄 수가 많아지면 람다는 자제
      - 람다는 3줄 이내로 작성
  - 열거 타입 생성자 안의 람다는 열거 타입의 인스턴스 멤버에 접근 못 함
    - 열거타입 생성자에 넘겨지는 인수들의 타입은 컴파일 타임에 추론되는 반면 인스턴스는 런타임에 만들어지기 때문

* 익명 클래스의 활용처
  - 추상 클래스의 인스턴스를 만들 때 활용
  - 추상 메소드가 여러 개인 인터페이스의 인스턴스를 만들 때 활용
  
* 람다 주의점
  - 람다에서의 this 키워드는 바깥 인스턴스를 가리킴
  - 익명 클래스에서의 this는 익명 클래스의 인스턴스 자신을 가리킴
  - 직렬화 하는 일은 자제해야 함