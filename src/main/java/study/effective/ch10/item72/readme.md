## 표준 예외를 사용하라
* 표준 예외 사용시 다른 사람이 사용하기 쉬어짐
* 널리 사용되는 예외들
  - IllegalArgumentException
    -인수로 부적절한 값을 넘길 때 던지는 예외
  - IllegalStateException
    - 호출된 메서드를 수행하기에 적합하지 않을 때
  - NullPointerException
    - null값을 허용하지 않는 메서드에 null을 건냈을때
  - IndexOutOfBoundsException
    - 시퀀스의 허용 범위를 넘는 값을 건낼 때
  - ConcurrentModificationException
    - 단일 스레드에서 사용하려고 설계한 객체를 여러 스레드가 동시에 수정하려 할 때
    - 동시 수정을 하고있는 것을 검출할 방법이 없으므로 사용자에게 문제가 생길 가능성을 알려주는 용도로 활용 
  - UnsupportedOperationException
    - 요창한 동작을 대상 객체가 지원하지 않을 때 던짐
* 표준 예외를 확장하여 새로 만드는 작업은 자제
* 예외의 기능이 상호배타적이 아니므로 예외 선택이 어려울 수 있음
  - IllegalStateException vs IllegalArgumentException
    - 인수 값이 무엇이었든지 실패했을거라면 IllegalStateException, 그렇지 않으면 IllegalArgumentException
