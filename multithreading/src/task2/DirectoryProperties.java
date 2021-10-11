package task2;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class DirectoryProperties {

  private Integer countFiles = 0;
  private Integer countDirectories = 0;
  private Long sizeMainDirectory = 0L;

  public DirectoryProperties() {
  }

  public Integer getCountFiles() {
    return countFiles;
  }

  public Integer getCountDirectories() {
    return countDirectories;
  }

  public Long getSizeMainDirectory() {
    return sizeMainDirectory;
  }

  public void addCountFiles() {
    countFiles++;
  }

  public void addCountDirectories() {
    countDirectories++;
  }

  public void addSizeMainDirectory(long size) {
    sizeMainDirectory += size;
  }

  public void addAll(List<DirectoryProperties> directoryProperties) {
    directoryProperties.forEach(properties -> {
      countFiles += properties.getCountFiles();
      countDirectories += properties.getCountDirectories();
      sizeMainDirectory += properties.getSizeMainDirectory();
    });
  }

  public void printStatistic() {
    System.out.println("\nDirectories - " + countDirectories);
    System.out.println("Files - " + countFiles);
    System.out.println("Size (bytes) - " + sizeMainDirectory);
    System.out.println("------------------------------------");
  }
}
