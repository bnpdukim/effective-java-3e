## 옵셔널 반환은 신중히 하라
* 값을 반환할 수 없을 경우
  - 자바8 이전
    - 예외를 던짐
      - 스택 추적 전체를 캡처하므로 비용듬
    - null 던짐 
      - null 처리 코드 추가
      - null 처리를 무시할시 언젠가 NullPointException 발생
        ```
        public static <E extends Comparable<E>> E max(Collection<E> c) {
          if( c.isEmpty()) throw new IllegalArgumentException("empty");
          
          E result = null;
          for( E e : c )
            if( result == null || e.compareTo(result) >0 )
                result = Objects.requireNonNull(e);
          return result;
        }
        ```
  - 자바8 이후
    - ```Optional<T>``` 반환
        ```
        public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
          if( c.isEmpty() ) return Optional.empty();
          
          E result = null;
          for( E e : c )
            if( result == null || e.compareTo(result) >0 )
                result = Objects.requireNonNull(e);
          return Optional.of(result);
        }
        ```
    - 옵셔널을 반환하는 메서드에서는 절대 null을 반환하지 말자
    - 스트림의 종단 연산 중 상당수가 옵셔널을 반환
        ```
        public static <E extends Comparable<e>> Optional<E> max(Collection<E> c) {
            return c.stream().max(Comparator.naturalOrder());
        }
        ```
  - 클라이언트의 옵셔널 처리
    - 기본값 설정
        ```
        String lastWordInLexicon = max(words).orElse("empty");   
        ```
    - 예외 던진
        ```
        Toy myToy = max(toys).orElseThrow(TemperTantrumException::new);
        ```
        - max가 존재할 경우 예외 팩터리를 전달함으로써 예외 생성 비용을 아낄 수 있음
    - 값이 항상 있는경우
        ```
        Element lastNobleGas = max(Elements.NOBLE_GASES).get();
        ```
    - orElseGet
        - Supplier<T>를 사용해 생성
            - 초기 설정 비용 낮출 수 있음
        ```
        Toy myToy = max(toys).orElseGet(Toy::gabage);
        ```
    
    - filter,map,flatMap,ifPresent 지원
  - 켈렉션, 스트림, 배열, 옵셔널 같은 컨테이너 타입은 옵셔널로 감싸면 안됨
    - Optional<List<T>> 안됨
  - 박싱된 기본 타입 처리
    - 박싱 + Optional로 인해 기본 타입 처리할때보다 무거움
    - int, long, double 전용 옵셔널 클래스 존재
        - OptionalInt, OptionalLong, OptionalDouble
    - 박싱된 기본 타입을 담은 옵셔널은 자제
        - Optional<Integer> 안됨
  - 옵셔널을 컬렉션의 키, 값, 원소나 배열의 원소로 사용하는데 적합하지 않음
  - 옵셔널을 인스턴스 필드에 Optional을 저장
    - 필수 클래스와 이를 확장한 옵션 클래스로 따로 만들어야 함을 암시함(나쁜냄새)
    ```
    class Animal {
        Eye eye;
        ...
    }
    class Chicken extends Animal {
        Optional<Wing> wing;
    }
    ```
    - 기본타입의 경우 값이 없음을 나타낼 방법이 마땅치 않으므로 이럴땐 적절한 상황
        - ex> NutritionFacts
        ```
        public class NutritionFacts {
            //필수
            private final int servingSize;
            private final int servings;
            //옵션
            private final OptionalInt calories;
            private final OptionalInt fat;
            private final OptionaInt sodium;
            private final OptionalInt carbohydrate;
            
            // builder
        }
        ```
