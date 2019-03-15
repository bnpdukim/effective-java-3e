package study.effective.ch11.item79.advanced1;

@FunctionalInterface
public interface SetObserver<E> {
    void added(ObservableSet<E> observableSet, E e);
}
