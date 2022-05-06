package methods_tasks;

import java.util.Scanner;

public class Task2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj piewszą liczbę:");
    double dividend = scanner.nextDouble();
    System.out.println("Podaj drugą liczbę:");
    double divider = scanner.nextDouble();
    while (divider == 0) {
      System.out.println("Błędna liczba. Podaj drugą liczbę:");
      divider = scanner.nextDouble();
    }
    System.out.println("Wynik dzielenia to: " + divideNumbers(dividend, divider));
  }

  public static double divideNumbers(double dividend, double divider) {
    double total = dividend / divider;
    return total;
  }
}
