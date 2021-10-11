package task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class DirectoryAnalyzer {

  private final Path path;

  private Integer countFiles = 0;
  private Integer countDirectories = 0;

  private Long sizeMainDirectory = 0L;

  public DirectoryAnalyzer(String pathString) {
    this.path = Paths.get(pathString);
  }

  public DirectoryAnalyzer(Path path) {
    this.path = path;
  }

  public void analyze() throws IOException {
    try (Stream<Path> paths = getStreamWithPaths()) {
      paths.forEach(localPath -> {
        if (Files.isDirectory(localPath)) {
          readDirectory();
        }
        if (Files.isRegularFile(localPath)) {
          readFile(localPath);
        }
      });
      printStatistic();
    }
  }

  private Stream<Path> getStreamWithPaths() throws IOException {
    return Files.walk(path);
  }

  private void readDirectory() {
    countDirectories++;
  }

  private void readFile(Path path) {
    countFiles++;
    try {
      sizeMainDirectory += Files.size(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void printStatistic() {
    System.out.println("Directory name - " + path.getFileName());
    System.out.println("Directories - " + countDirectories);
    System.out.println("Files - " + countFiles);
    System.out.println("Size (bytes) - " + sizeMainDirectory);
    System.out.println("------------------------------------");
  }
}
