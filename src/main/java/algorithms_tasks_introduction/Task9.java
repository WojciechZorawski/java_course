package algorithms_tasks_introduction;

import java.util.Arrays;

public class Task9 {

  public static void main(String[] args) {
    int[] array = { 2, 5, 6, 8, 9, 9 };
    System.out.println("Podana tablica to: " + Arrays.toString(array));
    System.out.println("środkowe elementy to: " + Arrays.toString(getMiddleArray(array)));

  }

  public static int[] getMiddleArray(int[] array) {
    int[] middleArray = new int[ 2 ];
    middleArray[ 0 ] = array[ array.length / 2 - 1 ];
    middleArray[ 1 ] = array[ array.length / 2 ];
    return middleArray;
  }

}
