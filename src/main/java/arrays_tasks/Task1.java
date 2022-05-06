package arrays_tasks;

import java.util.Scanner;

public class Task1 {

  public static void main(String[] args) {
    boolean exit;
    do {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Podaj kilka liczb całkowitych oddzielonych przecinkami:");
      try {
        System.out.println("Pierwszy element z tablicy to " + parseStringToArray(scanner.next()));
        exit = false;
      } catch (NumberFormatException e) {
        System.out.println("Podano błędne dane. Proszę podać liczby całkowite.");
        exit = true;
      }
    }
    while (exit);
  }

  /**
   * This method gets userInput and split it by comma to String array and parse first element to int if possible and returns it. If first element of split array
   * is not parseable to int the method throws NumberFormatException. If first element is parseable and the other ones aren't, method will ignore them.
   *
   * @param userInput User input to be parsed.
   * @return First element of user input split by comma parsed to int.
   */
  public static int parseStringToArray(String userInput) {
    String[] split = userInput.split(",");
    return Integer.parseInt(split[ 0 ]);
  }
}
