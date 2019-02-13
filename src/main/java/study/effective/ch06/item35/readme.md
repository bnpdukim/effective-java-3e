## ordinal 메서드 대신 인스턴스 필드를 사용하라
* ordinal 메소드 
  * 열거 타입에서 몇 번째 위치인지를 반환하는 메서드
  ```
      public enum Ensemble {
          SOLO, DUET, TRIO, OUARTET, QUINTET, 
          SEXTET, SEPTET, OCTET, NONET, DECTET;
          
          public int numberOfMusicians() {
              return ordinal() + 1;
          } 
      }
  ```  
  * 문제점
    * 상수 선언 순서를 바꾸는 순간 오동작
    * 사용 중인 정수와 값이 같은 상수 추가 불가
    * 값을 중간에 비워둘 수 없음
  * 해결책
    * 인스턴스 필드에 저장
    ```
          public enum Ensemble {
              SOLO(1), DUET(2), TRIO(3), OUARTET(4), QUINTET(5), 
              SEXTET(6), SEPTET(7), OCTET(8), NONET(9), DECTET(10), 
              TRIPLE_QUARTET(12);
              
              private final int numberOfMusicians;
              Ensemble(int size) {
                this.numberOfMusicians = size;
              }
              
              public int numberOfMusicians() {
                  return numberOfMusicians;
              } 
          }
      ```  
  * ordinal 메소드는 EnumSet과 EnumMap 같은 열거 타입 기반의 범용 자료구조에 쓸 목적으로 설계
  