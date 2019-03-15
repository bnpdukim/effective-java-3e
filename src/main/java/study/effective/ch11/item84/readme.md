## 프로그램의 동작을 스레드 스케줄러에 기대지 말라
* 여러 스레드가 실행 중이면 운영체제의 스레드 스케줄러가 어떤 스레드를 얼마나 오래 실행할지 정함
* 스케줄링 정책은 운영체제마다 다름
* 정확성이나 성능 스레드 스케줄러에 따라 달라지는 프로그램이라면 다른 플랫폼에이식하기 어려움
* 이식성 좋은 프로그램을 작성하는 가장 좋은 방법
  - 실행 가능한 스레드의 평균적인 수를 프로세서 수보다 지나치게 많아지지 않도록 하는 것
* 실행 가능한 스레드 수를 적게 유지하는 주요 기법
  - 각 스레드가 무언가 유용한 작업을 완료한 후에는 다음 일거리가 생길때까지 대기
  - 스레드가 당장 처리해야 할 작업이 없다면 실행되서는 안된다.
  - 실행자 프레임워크에서는 스레드 풀 크기를 적절히 설정하고 작업을 짧게 유지
  - 스레드는 Busy waiting 상태가 되면 안된다.
  ```
  public class SlowCountDownLatch {
    private int count;
    public SlowCountDownLatch(int count) {
      if(count < 0) throw new IllegalArgumentException(count+" < 0 ");
      this.count = count;
    }
    
    public void await() {
      while(true) {
        synchronized(this) {
          if(count==0) return;
        }
      }
    } 
    public synchronized void countDown() {
      if(count!=0) count--;
    }
  }
  ```