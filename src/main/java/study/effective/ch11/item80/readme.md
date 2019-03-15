## 스레드보다는 실행자, 태스크, 스크림을 애용하라
* 실행자 프레임워크(Executor Framework)
  - 실행자 생성(작업큐)
  ExecutorService exec = Executors.newSingleThreadExecutor();
  - 실행자에 실행할 task 넘기는 방법
  exec.execute(runnable);
  - 실행자를 우하하게 종료
  exec.shutdown()
  - 주요 기능
    - 특정 태스크가 완료되기를 기다린다.
    - 태스크 모음 중 하나(invokeAny 메소드) 혹은 모든 태스크(invokeAll)가 완료되기를 기다린다.
    - 실행자 서비스가 종료하기를 기다린다.(awaitTermination)
    - 완료된 태스크들의 결과를 차례대로 받는다(ExecutorCompletionService)
    - 태스크를 특정 시가에 주기적으로 실행하게 한다.(ScheduledThreadPoolExecutor)
  - java.util.concurrent.Executors의 정적 팩터리들을 이용해 생성할 수 있음
  - 작은 프로그램이라면 Executors.newCachedThreadPool 일반적으로 좋은 선택임
    - 사용 사능한 스레드가 없으면 새로 생성하기때문에 cpu100%가 될 수 있음
  - 무거운 프로그램이라면 Executors.newFixedThreadPool을 선택하고 ThreadPoolExecutor를 직접 사용
* 작업 큐를 직접 만드는 일은 삼가야 함
* 스레드를 직접 다루는 것도 삼가야 함
* 실행자 프레임워크에서는 작업 단위와 실행 매커니즘이 분리
  - 작업 단위를 나타내는 핵심 추상 개념이 태스크
    - 태스크에서는 Runnable과 Callable이 있음
  - 태스크를 수행하는 일반적인 매커니즘이 실행자 서비스
* 자바7에 포크-조인(fork-join) 태스크를 지원
  - 포크-조인 풀이라는 특별한 실행자 서비스가 실행
  - 병렬 스트림에 적용되어 있음
    