package algorithm_tasks;

import java.util.Scanner;

public class Task12 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać kilka liczb oddzielonych przecinkami");
    int[] array = parseStringToArray(scanner.next());
    System.out.println("Największa różnica pomiędzy elementami podanej tablicy to: " + findTheBiggestDiff(array));
  }

  public static int findTheBiggestDiff(int[] array) {
    int[] sortedArray = sortArray(array);
    int theBiggestDiff = sortedArray[ array.length - 1 ] - sortedArray[ 0 ];
    return theBiggestDiff;
  }

  public static int[] sortArray(int[] array) {
    int exit;
    do {
      exit = 0;
      for (int i = 1; i < array.length; i++) {
        if (array[ i ] < array[ i - 1 ]) {
          int tmp = array[ i - 1 ];
          array[ i - 1 ] = array[ i ];
          array[ i ] = tmp;
          exit++;
        }
      }
    }
    while (exit > 0);
    return array;
  }

  public static int[] parseStringToArray(String userInput) {
    String[] tmp = userInput.split(",");
    int[] userNumbers = new int[ tmp.length ];
    for (int i = 0; i < tmp.length; i++) {
      userNumbers[ i ] = Integer.parseInt(tmp[ i ]);

    }
    return userNumbers;
  }
}
