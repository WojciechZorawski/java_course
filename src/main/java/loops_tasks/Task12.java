package loops_tasks;

import java.util.Scanner;

public class Task12 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj wyraz:");
    String word = scanner.nextLine();
    System.out.println(readWord(word));
  }

  public static String readWord(String word) {
    String newWord = "";
    for (int i = 0; i <= word.length() - 1; i++) {
      newWord = word.charAt(i) + newWord;
    }
    return newWord;
  }
}
