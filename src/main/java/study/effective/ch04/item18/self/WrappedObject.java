package study.effective.ch04.item18.self;

class WrappedObject implements Callback {

    private final CallbackService service;

    WrappedObject(CallbackService service) {
        this.service = service;
    }

    @Override
    public void registerCallback() {
        service.performAsync(this);
    }

    @Override
    public void call() {
        System.out.println("WrappedObject callback!");
    }
}
