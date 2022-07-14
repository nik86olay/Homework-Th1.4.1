import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        TechnicalSupport technicalSupport = new TechnicalSupport();
        final int countThread = 4;
        ExecutorService threadPull = Executors.newFixedThreadPool(countThread);

        new Thread(null, technicalSupport::addingCalls, "ATS").start();
        for (int i = 0; i < countThread; i++) {
            threadPull.submit(technicalSupport::getCall);
        }
        threadPull.shutdown();
    }
}
