package arrays_tasks;

import java.util.Scanner;

public class Task2 {

  public static void main(String[] args) {
    boolean exit;
    do {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Podaj kilka liczb całkowitych oddzielonych przecinkami:");
      try {
        System.out.println("Ostatni element z tablicy to " + parseStringToArray(scanner.next()));
        exit = false;
      } catch (NumberFormatException e) {
        System.out.println("Podano błędne dane. Proszę podać liczby całkowite.");
        exit = true;
      }
    }
    while (exit);
  }

  /**
   * This method gets userInput and split it by comma to String array and parse last element to int if possible and returns it. If last element of split array
   * is not parseable to int the method throws NumberFormatException. If last element is parseable and the other ones aren't, method will ignore them.
   *
   * @param userInput User input to be parsed.
   * @return Last element of user input split by comma parsed to int.
   */
  public static int parseStringToArray(String userInput) {
    String[] split = userInput.split(",");
    return Integer.parseInt(split[ split.length - 1 ]);
  }
}



