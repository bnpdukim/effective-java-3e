## 배열보다는 리스트를 사용하라
* 차이점
  * 배열은 공변(convariant)
    * Sub가 Super의 하위 타입이면 Sub[]는 Super[]의 하위타입
  * 제네릭은 불공변(invariant)
    * 다른 타입 Type1과 Type2가 있을때, List<Type1>은 List<Type2>와 관계가 없음
  * 배열은 실체화(reify)
  * 제네릭은 타입 정보가 런타임에 소거(erasure)
* 배열과 제네릭은 잘 어우러지지 못함
  * 배열은 제네릭 타입, 매개변수화 타입, 타입 매개변수로 사용 못함
    * ex> new List<E>[], new List<String>[], new E[] 제네릭 배열 오류 일으킴
  * 제네릭 배열을 막은 이유
    * 타입이 안전하지 않기 때문
```
List<String>[] stringLists = new List<String>[1];  // 컴파일 에러 
// 에러가 발생 안한다고 가정하면 런타임에 에러날 수 있음(아래 코드 참고)
List<Integer> intList = List.of(42);
Object[] objects = stringLists;
object[0] = intList;
String s = stringLists[0].get(0); 
```
* 실체화 불가 타입(non-reifiable type)
  * ex> E, List<E>, List<String>
  * 런타임에는 컴파일타임보다 타입 정보를 적게 가지는 타입
  * 비한정적 와일드카드 타입만 실체화 됨
    * ex> List<?>
* 배열을 제네릭 타입으로 만들 수 없어 귀찮은 경우
  * 제네릭 컬렉션에서 자신의 원소를 담은 배열을 반환하는게 불가능
    * 해결방은은 item33에서 설면
  * 제네릭 타입과 가변인수 메서드(varargs method)를 함께 쓰면 경고 메시지 발생
    * 가변인수 매개변수를 담은 배열이 생성됨 -> 원소가 실체화 불가 타입이라는 경고
    * @SafeVarargs 대처 가능
* ex> Chooser class
  * 제네릭 적용전 (code)
    * choose 메소드를 호출할때마다 형변환 필요 (code)
  * 제네릭 적용 (code)
    * 강제 T[]로 형변환
      * 컴파일시 워닝 발생
    * 배열을 제거하고 List로 대체