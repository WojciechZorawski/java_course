package string_tasks;

import java.util.Scanner;

public class Task2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj wyraz");
    String word = scanner.nextLine();
    System.out.println(isWordContainPies(word));
  }

  public static boolean isWordContainPies(String word) {
    return word.toLowerCase().contains("pies");
  }
}
