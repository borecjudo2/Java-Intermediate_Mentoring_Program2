package task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class PropertiesThread implements Runnable {

  private final String path;

  public PropertiesThread(String path) {
    this.path = path;
  }

  @Override
  public void run() {
    ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
    AsyncDirectoryAnalyzer task = createTask();
    forkJoinPool.execute(task);
    DirectoryProperties properties = task.join();
    properties.printStatistic();
    System.exit(0);
  }

  private AsyncDirectoryAnalyzer createTask() {
    try {
      List<Path> paths = Files.walk(Paths.get(path)).collect(Collectors.toList());
      int availableProcessors = Runtime.getRuntime().availableProcessors();
      return new AsyncDirectoryAnalyzer(paths, availableProcessors);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
