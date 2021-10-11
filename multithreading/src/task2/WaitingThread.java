package task2;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class WaitingThread implements Runnable {

  @Override
  public void run() {
    while (true) {
      try {
        System.out.println("Waiting for end program");
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
