package algorithms_tasks_introduction;

import java.util.Scanner;

public class Task17 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać liczbę");
    int number = scanner.nextInt();
    if (isNumberEven(number)) {
      System.out.println("Liczba jest parzysta");
    } else {
      System.out.println("Liczba nie jest parzysta");
    }
  }

  public static boolean isNumberEven(int number) {
    return number % 2 == 0;
  }
}
