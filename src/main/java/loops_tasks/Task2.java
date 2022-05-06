package loops_tasks;

import java.util.Scanner;

public class Task2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj liczbę");
    int n = scanner.nextInt();
    System.out.println(summarizeNumbers(n));
  }

  public static int summarizeNumbers(int n) {
    int sum = 0;
    for (int a = 1; a <= n; a++) {
      sum = sum + a;
    }
    return sum;
  }

}
