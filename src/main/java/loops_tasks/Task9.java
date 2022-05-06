package loops_tasks;

import java.util.Scanner;

public class Task9 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj proszę wyraz:");
    String word = scanner.nextLine().toLowerCase();
    if (isWordPalindrome(word)) {
      System.out.println("Ten wyraz to palindrom");
    } else {
      System.out.println("Ten wyraz to nie palindrom");
    }
  }

  public static boolean isWordPalindrome(String word) {
    for (int i = 0; i <= word.length() / 2; i++) {
      if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }
}
