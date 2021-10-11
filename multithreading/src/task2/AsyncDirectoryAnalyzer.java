package task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class AsyncDirectoryAnalyzer extends RecursiveTask<DirectoryProperties> {

  private final List<Path> paths;
  private final Integer availableProcessors;
  private final Integer TASKS_COUNTER = 2;

  private final DirectoryProperties directoryProperties = new DirectoryProperties();
  private final Integer arrayForSortLength;
  private final Integer middleArrayLength;
  private final Integer afterMiddleArrayLength;

  public AsyncDirectoryAnalyzer(List<Path> paths, Integer availableProcessors) {
    this.paths = paths;
    this.availableProcessors = availableProcessors;

    this.arrayForSortLength = paths.size();
    this.middleArrayLength = arrayForSortLength / 2;
    this.afterMiddleArrayLength = arrayForSortLength - middleArrayLength;
  }

  @Override
  protected DirectoryProperties compute() {
    if (availableProcessors > 0) {
      List<DirectoryProperties> list = ForkJoinTask.invokeAll(createSubtasks()).stream()
          .map(ForkJoinTask::join)
          .collect(Collectors.toList());
      directoryProperties.addAll(list);
    } else {
      paths.forEach(path -> {
        if(Files.isDirectory(path)) {
          readDirectory();
        }
        if (Files.isRegularFile(path)) {
          readFile(path);
        }
      });
    }
    return directoryProperties;
  }

  private List<AsyncDirectoryAnalyzer> createSubtasks() {
    Integer newAvailableProcessors = availableProcessors - TASKS_COUNTER;
    List<AsyncDirectoryAnalyzer> tasks = new ArrayList<>();

    tasks.add(new AsyncDirectoryAnalyzer(initFirstList(), newAvailableProcessors));
    tasks.add(new AsyncDirectoryAnalyzer(initSecondList(), newAvailableProcessors));

    return tasks;
  }

  private List<Path> initFirstList() {
    List<Path> list = new ArrayList<>(middleArrayLength);
    for (int i = 0; i < middleArrayLength; i++) {
      list.add(paths.get(i));
    }
    return list;
  }

  private  List<Path> initSecondList() {
    List<Path> list = new ArrayList<>(arrayForSortLength - middleArrayLength);
    for (int i = middleArrayLength; i < arrayForSortLength; i++) {
      list.add(paths.get(i));
    }
    return list;
  }

  private void readDirectory() {
    directoryProperties.addCountDirectories();
  }

  private void readFile(Path path) {
    directoryProperties.addCountFiles();
    try {
      directoryProperties.addSizeMainDirectory(Files.size(path));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
