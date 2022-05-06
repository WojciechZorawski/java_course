package algorithms_tasks_introduction;

import java.util.Scanner;

public class Task22 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać liczbę");
    int number = scanner.nextInt();
    System.out.println("Ilość dzielników liczby " + number + " to " + findDivisors(number));

  }

  public static int findDivisors(int number) {
    int counter = 2;
    for (int i = 2; i <= number / 2; i++) {
      if (number % i == 0) {
        counter++;
      }
    }
    return counter;
  }
}
