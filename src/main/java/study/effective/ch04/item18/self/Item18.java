package study.effective.ch04.item18.self;

public class Item18 {
    public static void main(String[] args) {
        // https://coderanch.com/t/670687/java/wrapper-class-suitable-callback-framework
        CallbackService service       = new CallbackService();
        WrappedObject wrappedObject = new WrappedObject(service);
        Wrapper       wrapper       = new Wrapper(wrappedObject);

        wrapper.registerCallback();
    }
}
