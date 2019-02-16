## 스트림 병렬화는 주의해서 사용하라
* 동시성 프로그램 변천사
  - 초창기
    - 스레드, 동기화, wait/notify 지원
  - 자바 5
    - java.util.concurrent 라이브러리와 executor 프레임워크 지원
  - 자바 7
    - fork-join 패키지 지원
  - 자바 8
    - parallel 메서드 지원으로 파이프라인 병렬 실행 
```
    public static void main(String[] args) {
        primes()
                .map(p->TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(3)
                .forEach(System.out::println);
    }

    private static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
```

* 데이터 소스가 Stream.iterate거나 중간 연산으로 limit을 쓰면 파이프라인 병렬화의 성능 개선을 기대하기 힘듬
  - 스트림의 소스가 ArrayList, Hashmap, HashSet, ConcurrentHashMap, 배열, int 범위, long범위일때 병렬화 효과가 좋음
    - 일을 원하는 크기로 나누는 작업은 Sliterator 가 담당
      - sliterator 메서드에서 얻어올 수 있음
    - 참조 지역성(locality of reference)이 뛰어남
* 종단 연산에 따라 병렬 수행 효율에 영향을 줌 
  - reduction이 병렬화 수행 효율이 높음
  - anyMatch, allMatch, nonMatch와 같이 조건과 맞으면 바로 반환되는 메서드도 병렬화에 적합
  - 가변 축소(mutable reduction)를 수행하는 메서드는 병렬화에 적합하지 않음
    - 컬렉션들을 합치는 부담이 큼
* 스트림을 잘못 병렬화하면 성능이 나빠지거나 오작동 할 수 있음
  - Stream의 reduce 연산에 건네지는 accumlator와 combiner
    - 결합법칙 만족(associative)
    - 간섭받지 않아야함(non-interfering)
    - 상태를 갖지 않아야 함(stateless)
* 병렬 스트림의 출력 순서 보장
  - forEach를 forEachOrdered로 바꿔주면 됨
* 스트림 병렬화는 오직 성능 최적화 수단
  - fork-join 풀에서 수행
  - 조건이 잘 갖춰지면 parallel 메서드 호출 하나로 프로세서 코어수에 비례하는 성능 향상 만끽
  ```
  static long pi(long n) {
    return LongStream.rangeCloseD(2,n)
      .mapToObj(BigInteger::valueOf)
      .filter(i->i.isProbablePrime(50))
      .count();
  }
  
  static long pi(long n) {
      return LongStream.rangeCloseD(2,n)
        .parallel()
        .mapToObj(BigInteger::valueOf)
        .filter(i->i.isProbablePrime(50))
        .count();
    }
  ```
* 무작위 수 스트림 병렬화
  - SplittableRandom 인스턴스 이용
    - ThreadLocalRandom 성능 약화
    - Random은 동기화 이슈로 최약의 성능
     