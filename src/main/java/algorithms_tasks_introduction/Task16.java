package algorithms_tasks_introduction;

import java.util.Scanner;

public class Task16 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać pierwszą liczbę całkowitą:");
    int firstNumber = scanner.nextInt();
    System.out.println("Proszę podać drugą liczbę całkowitą:");
    int secondNumber = scanner.nextInt();
    System.out.println("Proszę podać trzecią liczbę całkowitą:");
    int thirdNumber = scanner.nextInt();
    if (areNumbersPythagoras(firstNumber, secondNumber, thirdNumber)) {
      System.out.println("Podane liczby są liczbami pitagorejskimi");
    } else {
      System.out.println("Podane liczby nie są liczbami pitagorejskimi");
    }
  }

  public static boolean areNumbersPythagoras(int a, int b, int c) {
    return a * a + b * b == c * c;
  }
}
