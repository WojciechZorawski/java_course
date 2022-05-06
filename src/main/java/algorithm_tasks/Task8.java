package algorithm_tasks;

import java.util.Scanner;

public class Task8 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę napisać dowolne zdanie: ");
    String userInput = scanner.nextLine();
    String userWords = userInput.replaceAll("[ ,\\.]", "");
    System.out.println("Ilość liter w zdaniu to: " + userWords.length());
  }
}
