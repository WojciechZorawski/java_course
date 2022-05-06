package algorithms_tasks_introduction;

import java.util.Scanner;

public class Task19 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać liczbę:");
    int number = scanner.nextInt();
    if (isNumberSquareOtherNumber(number)) {
      System.out.println("Liczba jest kwadratem innej liczby.");
    } else {
      System.out.println("Liczba nie jest kwadratem innej liczby.");
    }
  }

  public static boolean isNumberSquareOtherNumber(int number) {
    int i = 0;
    while (i < number) {
      if (i * i == number) {
        return true;
      }
      i++;
    }
    return false;
  }
}
