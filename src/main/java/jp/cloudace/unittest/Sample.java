package jp.cloudace.unittest;

public class Sample {

    private final Injected injected;

    public Sample(Injected injected) {
        this.injected = injected;
    }

    public void callInjected() {
        injected.called(10);
    }

    public int getMockedAsInteger() {
        return injected.isMocked() ? 1 : 0;
    }

}
