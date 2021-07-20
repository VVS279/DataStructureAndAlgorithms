package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

  private static int iterativeSearch(int[] array, int searchElement) {
    if (array == null || array.length == 0) {
      return -1;
    }
    int start = 0;
    int end = array.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (searchElement == array[mid]) {
        return mid;
      } else if (searchElement < array[mid]) {
        end = mid -1; 
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }
  
  private static int recursiveSearch(int[] array, int start, int end, int searchElement) {
    if (start > end) {
      return -1;
    }
    int mid = (start + end) / 2;
    if (searchElement == array[mid]) {
      return mid;
    } else if (searchElement < array[mid]) {
      return recursiveSearch(array, start, mid -1, searchElement);
    } else {
      return recursiveSearch(array, mid + 1, end, searchElement);
    }
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNext()) {
      int[] array = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
      int searchElement = scanner.nextInt();
      System.out.println(iterativeSearch(array, searchElement));
      System.out.println(recursiveSearch(array, 0, array.length, searchElement));
    }
    scanner.close();
  }
}
