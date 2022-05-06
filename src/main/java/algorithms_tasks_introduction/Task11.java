package algorithms_tasks_introduction;

import java.util.Arrays;

public class Task11 {

  public static void main(String[] args) {
    String[] array = { "BARTEK", "ASIA", "MOTORÓWKA", "HELIKOPTER" };
    System.out.println("Tablica przed zmianą: " + Arrays.toString(array));
    System.out.println("Tablica po zmianie: " + Arrays.toString(convertToSmallLetters(array)));

  }

  public static String[] convertToSmallLetters(String[] array) {
    String[] arrayWithSmallLetters = new String[ array.length ];
    for (int i = 0; i < array.length; i++) {
      arrayWithSmallLetters[ i ] = array[ i ].toLowerCase();
    }
    return arrayWithSmallLetters;
  }

}
