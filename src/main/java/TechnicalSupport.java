import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class TechnicalSupport {
    private ConcurrentLinkedQueue<Call> arrayCall = new ConcurrentLinkedQueue<>();
    private final AtomicInteger timeCounter = new AtomicInteger(1);


    public void getCall() {
        final int TIME_CALLING = 3000;
        Call n;
        while ((n = arrayCall.poll()) != null) {
            System.out.println(n + " - accepted the challenge " + Thread.currentThread().getName());
            try {
                sleep(TIME_CALLING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addingCalls() {
        final int TIME_ADDING = 1000;
        final int LIMIT_CALLS = 10;
        final int WORKING_HOURS = 2;

        while (timeCounter.get() <= WORKING_HOURS * LIMIT_CALLS) {
            for (int i = 0; i < LIMIT_CALLS; i++) {
                arrayCall.add(new Call(i + timeCounter.get()));
            }
            System.out.println("Adding " + (LIMIT_CALLS) + " calls");
            timeCounter.addAndGet(LIMIT_CALLS);
            try {
                sleep(TIME_ADDING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
