package algorithms_tasks_introduction;

import java.util.Scanner;

public class Task21 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać pierwszy wyraz:");
    String firstWord = scanner.nextLine();
    System.out.println("Proszę podać drugi wyraz:");
    String secondWord = scanner.nextLine();
    System.out.println("Ilość liter w najdłuższym wyrazie to: " + getMaximumLength(firstWord, secondWord));

  }

  public static int getMaximumLength(String firstWord, String secondWord) {
    if (firstWord.length() > secondWord.length()) {
      return firstWord.length();
    } else {
      return secondWord.length();
    }
  }
}
