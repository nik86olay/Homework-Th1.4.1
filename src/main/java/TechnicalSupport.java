import java.util.concurrent.ConcurrentLinkedQueue;
import static java.lang.Thread.sleep;

public class TechnicalSupport {
    private ConcurrentLinkedQueue arrayCall = new ConcurrentLinkedQueue();
    private volatile int timeCounter = 1;
    final private int workingHours = 3;

    public void getCall() {
        int timeCalling = 3000;
        while (!arrayCall.isEmpty()) {
            System.out.println(arrayCall.remove().toString() + " - accepted the challenge " + Thread.currentThread().getName());
            try {
                sleep(timeCalling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addingCalls() {
        final int timeAdding = 1000;
        while (timeCounter <= workingHours) {
            for (int i = 1; i < 61; i++) {
                arrayCall.add(new Call(i * timeCounter));
            }
            System.out.println("Adding 60 calls");
            timeCounter++;
            try {
                sleep(timeAdding);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
