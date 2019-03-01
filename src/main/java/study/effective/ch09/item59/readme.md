## 라이브러리를 익히고 사용하라
* 직접 만든 random 메소드의 결함
```
    static Random rnd = new Random();
    private static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }
```
  - n이 크지 않은 2의 제곱수라면 같은 수열 반복됨
  - n이 2의 제곱수가 아니라면 몇몇 숫자가 평균적으로 더 자주 반환
  - 무작위로 생성된 수 중 2/3가량이 중간값보다 낮은쪽에 쏠림
```
    public static void main(String[] args) {
        int n = 2*(Integer.MAX_VALUE / 3);
        int low = 0;
        for(int i=0;i<100000;i++)
            if(random(n) < n/2)
                low++;
        log.info("{}",low);
    }
``` 
  - 지정한 범위 밖의수가 종종 튀어나올 수 있음
    - Math.abs를 이용했기때문
  - 해결책
    - Random.nextInt(int) 로 해결
      - 수학적 지식을 바탕으로 random값 생성
    - java7 이후부터는 ThreadLocalRandom으로 대체
    - fork-join 풀이나 병력 스트림에서는 SplitaableRandom 사용
* 표준 라이브러리 사용의 장점
  - 전문가의 지식과 경험 활용
  - 핵심적이지 않은일을 처리하기 위한 시간을 허비하지 않아도 됨
  - 지속적인 성능 개선
  - 기능 추가
  - 다른사람들이 보기 쉬어짐
* 라이브러리 공부
  - 최소한 java.lang, java.util, java.io와 하위 패키지들에 익숙해져라
* 개발 방법
  1. 표준 라이브러리 사용 시도
  2. 서드파티 라이브러리 사용(ex Guava)
  3. 직접 구현
