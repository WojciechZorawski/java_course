package algorithm_tasks;

import java.util.Scanner;

public class Task10 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać dowolną liczbę: ");
    int number = scanner.nextInt();
    System.out.println("Suma liczb od 0 do " + number + " to " + countNumbers(number));

  }

  public static int countNumbers(int number) {
    int counter = 0;
    for (int i = 0; i < number + 1; i++) {
      counter += i;
    }
    return counter;
  }

}
