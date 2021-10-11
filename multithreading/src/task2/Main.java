package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  // TODO: 10/11/2021 Add your path
  private static final String PATH = "C:/work/epam";

  public static void main(String[] args) throws IOException {
    asyncAnalysePath();
    listenKeyForEndProgram();
  }

  private static void asyncAnalysePath() {
    Thread thread = new Thread(new PropertiesThread(PATH));
    thread.setDaemon(true);
    thread.start();
  }

  private static void listenKeyForEndProgram() throws IOException {
    startWaitingThreadAnimation();

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      System.out.println("For exit press (q and Enter)...");
      String line = in.readLine();
      if (line.equalsIgnoreCase("q")) {
        break;
      }
    }

    in.close();
  }

  private static void startWaitingThreadAnimation() {
    Thread thread = new Thread(new WaitingThread());
    thread.setDaemon(true);
    thread.start();
  }
}
