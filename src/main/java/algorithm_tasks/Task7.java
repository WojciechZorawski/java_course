package algorithm_tasks;

import java.util.Scanner;

public class Task7 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę napisać dowolne zdanie: ");
    String userInput = scanner.nextLine();
    String[] userWords = userInput.split(" ");
    System.out.println("Najdłuższy wyraz z podanego zdania to: " + findTheLongestWord(userWords));

  }

  public static String findTheLongestWord(String[] userWords) {
    String theLongestWord = " ";
    for (String word : userWords) {
      if (word.length() > theLongestWord.length()) {
        theLongestWord = word;
      }
    }
    return theLongestWord;
  }
}
