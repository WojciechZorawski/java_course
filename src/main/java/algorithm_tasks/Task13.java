package algorithm_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task13 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać kilka liczb oddzielonych przecinkami: ");
    int[] array = parseStringToArray(scanner.nextLine());
    System.out.println("Pary liczb, który suma wynosi 0 to: " + Arrays.toString(findPairsOfNumbers(array)));
  }

  public static int[] findPairsOfNumbers(int[] array) {
    int[] pairsOfNumbers = new int[ 0 ];
    ArrayList numbersToVerify = new ArrayList<Integer>();
    for (int i = 0; i < array.length; i++) {
      if (numbersToVerify.contains(array[ i ])) {
        pairsOfNumbers = addToArray(pairsOfNumbers, array[ i ] * -1);
        pairsOfNumbers = addToArray(pairsOfNumbers, array[ i ]);
        numbersToVerify.remove(Integer.valueOf(array[ i ]));
      } else {
        numbersToVerify.add(array[ i ] * -1);
      }
    }
    return pairsOfNumbers;
  }

  public static int[] parseStringToArray(String userInput) {
    String[] tmp = userInput.split(",");
    int[] userNumbers = new int[ tmp.length ];
    for (int i = 0; i < tmp.length; i++) {
      userNumbers[ i ] = Integer.parseInt(tmp[ i ]);
    }
    return userNumbers;
  }

  public static int[] addToArray(int[] array, int element) {
    array = Arrays.copyOf(array, array.length + 1);
    array[ array.length - 1 ] = element;
    return array;
  }

}
