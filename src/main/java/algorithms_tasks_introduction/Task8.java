package algorithms_tasks_introduction;

import java.util.Arrays;

public class Task8 {

  public static void main(String[] args) {
    int[] array = { 2, 1, 5, 9, 3 };
    System.out.println("Podana tablica to: " + Arrays.toString(array));
    System.out.println("Posortowana tablica to: " + Arrays.toString(sortArray(array)));

  }

  public static int[] sortArray(int[] array) {
    int exit;
    do {
      exit = 0;
      for (int i = 1; i < array.length; i++) {
        if (array[ i ] < array[ i - 1 ]) {
          int tmp = array[ i - 1 ];
          array[ i - 1 ] = array[ i ];
          array[ i ] = tmp;
          exit++;
        }
      }
    }
    while (exit > 0);
    return array;
  }
}