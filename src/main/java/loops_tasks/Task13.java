package loops_tasks;

import java.util.Scanner;

public class Task13 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj wyraz:");
    String word = scanner.nextLine();
    System.out.println("Ilość małych liter w podanym wyrazie to " + readSmallLetters(word));
  }

  public static int readSmallLetters(String word) {
    int numberOfSmallLetters = 0;
    for (int i = 0; i <= word.length() - 1; i++) {
      if (Character.isLowerCase(word.charAt(i))) {
        numberOfSmallLetters++;
      }
    }
    return numberOfSmallLetters;
  }
}
