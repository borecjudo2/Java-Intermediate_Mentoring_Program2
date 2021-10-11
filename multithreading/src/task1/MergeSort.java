package task1;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class MergeSort {

  private final int[] arrayForSort;

  private final int arrayForSortLength;
  private final int middleArrayLength;
  private final int afterMiddleArrayLength;

  public MergeSort(int[] arrayForSort) {
    this.arrayForSort = arrayForSort;
    this.arrayForSortLength = arrayForSort.length;
    this.middleArrayLength = arrayForSortLength / 2;
    this.afterMiddleArrayLength = arrayForSortLength - middleArrayLength;
  }

  public void mergeSort() {
    if (canBeParallel()) {
      return;
    }

    int[] leftArray = initLeftArray();
    int[] rightArray = initRightArray();

    new MergeSort(leftArray).mergeSort();
    new MergeSort(rightArray).mergeSort();

    sort(leftArray, rightArray);
  }

  private boolean canBeParallel() {
    return arrayForSortLength < 2;
  }

  private int[] initLeftArray() {
    int[] array = new int[middleArrayLength];
    System.arraycopy(arrayForSort, 0, array, 0, middleArrayLength);
    return array;
  }

  private int[] initRightArray() {
    int[] array = new int[arrayForSortLength - middleArrayLength];
    System.arraycopy(arrayForSort, middleArrayLength, array, 0, afterMiddleArrayLength);
    return array;
  }

  private void sort(int[] leftArray, int[] rightArray) {
    int i = 0, j = 0, k = 0;
    while (i < middleArrayLength && j < afterMiddleArrayLength) {
      if (leftArray[i] <= rightArray[j]) {
        arrayForSort[k++] = leftArray[i++];
      } else {
        arrayForSort[k++] = rightArray[j++];
      }
    }
    while (i < middleArrayLength) {
      arrayForSort[k++] = leftArray[i++];
    }
    while (j < afterMiddleArrayLength) {
      arrayForSort[k++] = rightArray[j++];
    }
  }

  public int[] getArrayForSort() {
    return arrayForSort;
  }
}
