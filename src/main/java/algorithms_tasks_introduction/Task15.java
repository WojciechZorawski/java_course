package algorithms_tasks_introduction;

import java.util.Arrays;

public class Task15 {

  public static void main(String[] args) {
    int[] array = { 4, 6, 7, 8, 3, 5, 12, 6, 4, 6 };
    int interestingNumber = 1;
    System.out.println("Podana tablica to " + Arrays.toString(array));
    System.out.println("Liczba, której ilości wystąpień w podanej tablicy będziemy szukać to: " + interestingNumber);
    System.out.println("Liczba wystąpień tej liczby w podanej tablicy to: " + getNumberOfAppearances(array, interestingNumber));

  }

  public static int getNumberOfAppearances(int[] array, int number) {
    int counter = 0;
    for (int element : array) {
      if (element == number) {
        counter++;
      }
    }
    return counter;
  }
}
