package methods_tasks;

import java.util.Scanner;

public class Task1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj pierwszą liczbę:");
    int elementOne = scanner.nextInt();
    System.out.println("Podaj drugą liczbę:");
    int elementTwo = scanner.nextInt();
    System.out.println("Wynik mnożenia to " + multiply(elementOne, elementTwo));
  }

  public static int multiply(int elementOne, int elementTwo) {
    int total = elementOne * elementTwo;
    return total;
  }
}
