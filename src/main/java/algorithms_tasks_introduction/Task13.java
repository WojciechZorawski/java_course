package algorithms_tasks_introduction;

import java.util.Arrays;

public class Task13 {

  public static void main(String[] args) {
    int[] numbers = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
    int counter = 0;
    int[] primeNumbers = new int[ counter ];
    for (int number : numbers) {
      if (isNumberPrimeNumber(number)) {
        counter++;
        primeNumbers = Arrays.copyOf(primeNumbers, counter);
        primeNumbers[ counter - 1 ] = number;
      }
    }
    System.out.println(Arrays.toString(primeNumbers));
  }

  public static boolean isNumberPrimeNumber(int userNumber) {
    if (userNumber != 1) {
      for (int i = 2; i <= userNumber / 2; i++) {
        if (userNumber % i == 0) {
          return false;
        }
      }
      return true;
    } else {
      System.out.println("Liczby pierwsze sprawdzamy od 2");
      return false;
    }
  }

}
