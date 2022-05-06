package algorithm_tasks;

import java.util.Scanner;

public class Task11 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać dowolną liczbę dodatnią: ");
    int number = scanner.nextInt();
    System.out.println("Podana liczba w zapisie binarnym to: ");
    convertToBinarySystem(number);

  }

  public static void convertToBinarySystem(int number) {
    int tmp;
    if (number <= 1) {
      System.out.print(number);
      return;
    }
    tmp = number % 2;
    convertToBinarySystem(number >> 1);
    System.out.print(tmp);
  }
}
