package study.effective.ch11.item79.basic;

@FunctionalInterface
public interface SetObserver<E> {
    void added(ObservableSet<E> observableSet, E e);
}
