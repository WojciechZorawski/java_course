package loops_tasks;

import java.util.Scanner;

public class Task11 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj liczbę:");
    int userNumber = scanner.nextInt();
    if (isNumberPrimeNumber(userNumber)) {
      System.out.println("Podana liczba jest liczbą pierwszą");
    } else {
      System.out.println("Podana liczba nie jest liczbą pierwszą");
    }
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
