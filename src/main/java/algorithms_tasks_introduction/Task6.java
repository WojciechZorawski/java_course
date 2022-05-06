package algorithms_tasks_introduction;

import java.util.Arrays;

public class Task6 {

  public static void main(String[] args) {
    int[] array = { 1, 5, 67, 2, 6 };
    System.out.println("Podana tablica to: " + Arrays.toString(array));
    System.out.println("Odwrócona tablica to: " + Arrays.toString(reverseArray(array)));

  }

  public static int[] reverseArray(int[] array) {
    int[] reversedArray = new int[ array.length ];
    for (int i = 0; i < array.length; i++) {
      reversedArray[ i ] = array[ array.length - 1 - i ];
    }
    return reversedArray;
  }

}
