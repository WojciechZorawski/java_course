package algorithm_tasks;

import java.util.Scanner;

public class Task1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać kilka liczb oddzielonych przecinkami");
    int[] array = parseStringToArray(scanner.next());
    System.out.println("Największy element z podanego ciągu liczb to: " + findTheBiggestElement(array));
  }

  public static int findTheBiggestElement(int[] array) {
    int theBiggestNumber = 0;
    for (int number : array) {
      if (number > theBiggestNumber) {
        theBiggestNumber = number;
      }
    }
    return theBiggestNumber;
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
