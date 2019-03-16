## 과도한 동기화는 피하라 - 동기화 영역을 최소화 하자.
* 과도한 동기화는 성능을 떨어뜨리고, 교착상태에 빠트리고 예측할 수 없는 동작 발생
* 동기화 메서드나 동기화 블록 안에서는 제어를 클라이언트에 양도하면 안 된다.
  - 재정의할 수 있는 메서드는 호출하면 안됨
  - 클라이언트가 넘겨준 함수 객체를 호출하면 안됨
  - => 동기화를 하는 클래스입장에서는 위의 두가지 경우 모두 외계인임
  - 외계인 메서드가 잘못 동작할 시
    - 예외를 일으킴
    - 교착상태 빠짐
    - 데이터 훼손 발생
  ```
  public class ObservableSet<E> extends ForwardingSet<E> {
      public ObservableSet(Set<E> s) {
          super(s);
      }
      private final List<SetObserver<E>> observers = new ArrayList<>();
  
      public void addObserver(SetObserver<E> observer) {
          synchronized (observers) {
              observers.add(observer);
          }
      }  
      public boolean removeObserver(SetObserver<E> observer) {
          synchronized (observers) {
              return observers.remove(observer);
          }
      }  
      private void notifyElementAdded(E element) {
          synchronized (observers) {
              for(SetObserver<E> observer : observers) 
                  observer.added(this, element);
          }
      }  
      @Override
      public boolean add(E e) {
          boolean added =  super.add(e);
          if(added) notifyElementAdded(e);
          return added;
      }
  
      @Override
      public boolean addAll(Collection<? extends E> c) {
          boolean result = false;
          for(E element : c) result |= add(element);
          return result;
      }
  }
  ```
  ```
  ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
  set.addObserver((s,e) -> log.info("{}",e));
  for(int i=0;i<100;i++) set.add(i);
  ```
  ```
  ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
  set.addObserver( new SetObserver<Integer>() {
      @Override
      public void added(ObservableSet observableSet, Integer integer) {
          log.info("{}", integer);
          if(integer==23) observableSet.removeObserver(this);
      }
  });
  for(int i=0;i<100;i++) set.add(i);
  ```
  - reentrance(재진입) 락이라 removeObserver의 lock 획득
   - 순회중인 컬렉션의 원소를 제거하도록 시도할때 ConcurrentModificationException 예외 발생
  ```
  ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
  set.addObserver( new SetObserver<Integer>() {
      @Override
      public void added(ObservableSet observableSet, Integer integer) {
          log.info("{}", integer);
          if(integer==23) {
              ExecutorService exec = Executors.newSingleThreadExecutor();
              try {
                  exec.submit(()->observableSet.removeObserver(this)).get();
              } catch (ExecutionException | InterruptedException ex) {
                  throw new AssertionError(ex);
              } finally {
                  exec.shutdown();
              }
          }
      }
  });
  for(int i=0;i<100;i++) set.add(i);
  ```
  - 다른 스레드이므로 락 획득 실패로 교착 상태 발생
  ```
  private void notifyElementAdded(E element) {
    List<SetObserver<E>> snapshot = null;
    synchronized (observers) {
        snapshot = new ArrayList<>(observers);
    }
    for(SetObserver<E> observer : snapshot) {
        observer.added(this, element);
    }
  }
  ```
  - 동기화 영역 바깥에서 호출되는 외계인 메서드를 열린호출(open call)이라함
    - 실패 방지
    - 동시성 효율 크게 개선
  ```
  public void addObserver(SetObserver<E> observer) {
    observers.add(observer);
  }
  public boolean removeObserver(SetObserver<E> observer) {
    return observers.remove(observer);
  }
  private void notifyElementAdded(E element) {
    for(SetObserver<E> observer : observers) {
      observer.added(this, element);
    }
  }
  ```
  - 동시성 컬렉션 라이브러리의 CopyOnWirteArrayList가 동기화 블록을 바깥으로 옮기기 위한 목적으로 설계됨
    - 항상 복사본을 만들어 수행하도록 구현
    - 수정할 일이 드물고 순화만 빈번히 일어나는 관찰자 리스트 용도로 최적
* 기본 규칙은 동기화 영역에서는 가능한 한 일을 적게 하는 것
  - 과도한 동기화가 초래하는 진짜 비용
    => 병렬로 실행할 기회를 읽고, 모든 코어가 메모리를 일과되게 보기 위한 지연시간
* 가변 클래스 작성 요령
  1. 동기화를 전혀 하지 말고 클래스를 사용하는 외부에서 동기화
    - java.util
  2. 내부에서 동기화 수행
    - java.util.concurrnt
    - 클라이언트가 외부에서 객체 전체에 락을 거는 것보다 동시성을 월등히 개선할때만 선택
* 지침을 어긴 예
  - StringBuilder
    - 거의 단일 스레이드에서 동작하는데도 내부 동기화 수행
    - 동기화를 수행하지 않는 StringBuilder가 추후 개발
  - Random
    - ThreadLocalRandom으로 대체
* 정적 필드는 외부에서 동기화 할 방법이 없으므로 내부 동기화 적용해야함