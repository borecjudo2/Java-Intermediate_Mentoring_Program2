package task1;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

  public static final int ARRAY_SIZE = 100_000_000;

  public static void main(String[] args) {
    int[] array = initArray(ARRAY_SIZE);

    sortByMergeSort(array);

    sortByAsyncMergeSort(array);
  }

  private static int[] initArray(int length) {
    int[] array = new int[length];
    for (int i = 0; i < array.length; i++) {
      array[i] = new Random().nextInt();
    }
    return array;
  }

  private static void sortByMergeSort(int[] array) {
    System.out.println(new Date());

    MergeSort mergeSort = new MergeSort(array);
    mergeSort.mergeSort();

    System.out.println(new Date());
  }

  private static void sortByAsyncMergeSort(int[] array) {
    System.out.println(new Date());

    ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
    forkJoinPool.invoke(new AsyncMergeSort(array));

    System.out.println(new Date());
  }
}
