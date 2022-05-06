package loops_tasks;

import java.util.Scanner;

public class Task6 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj dowolną liczbę");
    int n = scanner.nextInt();
    System.out.println("Silnia z liczby " + n + " to " + count(n));
  }

  public static int count(int n) {
    int factorial = 1;
    for (int i = 1; i <= n; i++) {
      factorial *= i;
    }
    return factorial;
  }
}
