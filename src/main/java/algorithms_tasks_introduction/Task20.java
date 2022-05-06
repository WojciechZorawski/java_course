package algorithms_tasks_introduction;

import java.util.Scanner;

public class Task20 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać pierwszy wyraz:");
    String firstWord = scanner.nextLine();
    System.out.println("Proszę podać drugi wyraz:");
    String secondWord = scanner.nextLine();
    System.out.println("Oba wyrazy razem to: " + addWord(firstWord, secondWord));
  }

  public static String addWord(String firstWord, String secondWord) {
    String total = firstWord + secondWord;
    return total;
  }
}
