## 매개변수가 유효한지 검사하라
* 매개변수 제약은 반드시 문서화
* 메서드 몸체가 시작되기 전에 검사해야함
  - 예외사항
    - 유효성 검사 비용이 지나치게 높을 경우
    - 실용적이지 않을 경우
    - 계산 과정에서 암묵적으로 검사가 수행될 때
      - ex> Collections.sort( List )
        -> 사전에 list안의 객체들이 비교가 가능한 객체인지 확인할 필요없음
* 매개변수 검사가 제대로 이루지지 않을시
  1. 실행중 모호한 예외를 던짐
  2. 잘못된 결과 반환
  3. 미래의 알 수 없는 시점에 메스드와 관련 없는 오류 발생

* protectd와 public은 매개변수가 유효하지 않을시 발생하는 예외를 문서화 해야함
  - @throws 자바독 태그 이용
  - IllegalArgumentException, IndexOutOfBoundsException, NullPointerException 등
  
* java.util.Objects.requireNonNull 메서드 활용
  - java7에 도입
```
    this.strategy = Objects.requireNonNull(strategy, "전략")
```

* 공개되지 않은 메서드라면 assert를 사용 (code)
  - 사용한 매개변수 유효성 검증 
  - 실패하면 AssertionError 던짐
  - 런타임에 아무런 효과, 아무런 성능 저하도 없음

* 나중에 사용되는 매개변수는 특히 더 신경써야 함
```
  static List<Integer> intArrayAsList(int[] a) {
    Objects.requireNonNull(a);  // 검사를 안하면 추후 리스트를 사용할때 null 에러 발생
    
    return new AbstractList<>() {
       @Override
       public int size() {
           return a.length;
       }

       @Override
       public Object get(int index) {
           return a[i];
       }
   };
```

* 매개변수 검사 과정중 예외가 발생했을때는 API 문서에 기재된 예외로 번역