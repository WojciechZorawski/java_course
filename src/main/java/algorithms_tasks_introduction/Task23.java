package algorithms_tasks_introduction;

import java.util.Scanner;

public class Task23 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać liczbę:");
    int number = scanner.nextInt();
    if (isNumberCubeOtherNumber(number)) {
      System.out.println("Liczba jest sześcianem innej liczby.");
    } else {
      System.out.println("Liczba nie jest sześcianem innej liczby.");
    }
  }

  public static boolean isNumberCubeOtherNumber(int number) {
    int i = 0;
    while (i < number) {
      if (i * i * i == number) {
        return true;
      }
      i++;
    }
    return false;
  }

}
