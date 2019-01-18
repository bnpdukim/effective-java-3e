package study.effective.ch04.item18.self;

final class CallbackService {

    void performAsync(Callback callback) {
        callback.call();
    }
}