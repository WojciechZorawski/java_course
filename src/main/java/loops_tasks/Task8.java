package loops_tasks;

import java.util.Scanner;

public class Task8 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj wyraz:");
    String word = scanner.nextLine();
    readLetters(word);
  }

  public static void readLetters(String word) {
    for (int i = 0; i < word.length(); i++) {
      System.out.println(word.charAt(i));
    }
  }
}
