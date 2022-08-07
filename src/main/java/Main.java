import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static final int COUNT_THREAD = 4;

    public static void main(String[] args) {
        TechnicalSupport technicalSupport = new TechnicalSupport();
        ExecutorService threadPull = Executors.newFixedThreadPool(COUNT_THREAD);

        new Thread(null, technicalSupport::addingCalls, "ATS").start();
        for (int i = 0; i < COUNT_THREAD; i++) {
            threadPull.submit(technicalSupport::getCall);
        }
        threadPull.shutdown();
    }
}
