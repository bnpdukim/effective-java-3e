## 예외를 무시하지 말라
```
try { 
} catch(SomeException e) {
}
```
* catch 블록을 비워두면 예외가 존재할 이유가 없어진다.
* 예외를 무시하는 경우
  - 복구할 것도 없고 작업을 프로그램을 중단할 이유가 없을때
    - ex> FileInputStream의 close
  - 예외를 무시하기로 했다면 catch 블록안에 무시한 이유를 주석으로 남기고 변수 이름도 ignored로 바꿔 놓자.
  ```
  int numColors = 4;
  try {
    numColors = f.get(1L, TimeUnit.SECONDS);
  } catch(TimeoutException | ExecutionException ignored) {
    // 기본값을 사용한다.(색상수를 최소화하면 좋지만 필수는 아니다.)
  } 
  ```
* 위 내용들은 검사와 비검사 예외에 적용