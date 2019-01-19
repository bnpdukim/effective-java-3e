package study.effective.ch04.item18.self;

class WrappedObject implements Callback {

    private final CallbackService callbackService;

    WrappedObject(CallbackService call) {
        this.callbackService = call;
    }

    @Override
    public void registerCallback() {
        callbackService.performAsync(this);
    }

    @Override
    public void call() {
        System.out.println("WrappedObject callback!");
    }
}
