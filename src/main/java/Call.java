public class Call {
    private final int numberCall;

    public Call(int numberCall) {
        this.numberCall = numberCall;
    }

    @Override
    public String toString() {
        return "Hello i'm a Call number " + numberCall;
    }
}
