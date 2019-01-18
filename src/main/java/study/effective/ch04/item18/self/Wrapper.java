package study.effective.ch04.item18.self;

class Wrapper implements Callback {

    private final WrappedObject wrappedObject;

    Wrapper(WrappedObject wrappedObject) {
        this.wrappedObject = wrappedObject;
    }

    @Override
    public void registerCallback() {
        wrappedObject.registerCallback();
    }

    @Override
    public void call() {
        System.out.println("Wrapper callback!");
    }
}
