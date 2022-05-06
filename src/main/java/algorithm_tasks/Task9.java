package algorithm_tasks;

import java.util.Scanner;

public class Task9 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać dowolną liczbę: ");
    int userInput = scanner.nextInt();
    System.out.println("Poniżej rozwiązanie za pomocą pętli i instrukcji if else: ");
    int[] numbers = new int[ userInput ];
    for (int i = 0; i < userInput; i++) {
      if (i == 0) {
        numbers[ i ] = 0;
        System.out.println(numbers[ i ]);
      } else if (i < 3) {
        numbers[ i ] = 1;
        System.out.println(numbers[ i ]);
      } else {
        numbers[ i ] = numbers[ i - 2 ] + numbers[ i - 1 ];
        System.out.println(numbers[ i ]);
      }
    }
    System.out.println("Poniżej rozwiązanie za pomocą rekurencji: ");
    for (int i = 0; i < userInput; i++) {
      System.out.println(findFibonacci(i));
    }
  }

  public static int findFibonacci(int number) {
    if (number == 0) {
      return 0;
    } else if (number == 1) {
      return 1;
    } else {
      return findFibonacci(number - 1) + findFibonacci(number - 2);
    }
  }
}

