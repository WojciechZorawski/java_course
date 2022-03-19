package string_tasks;

import java.util.Scanner;

class Task1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj imię");
    String name = scanner.nextLine();
    if (isFirstLetterJ(name)) {
      System.out.println("Imię zaczyna się na J");
    } else {
      System.out.println("Imię nie zaczyna się na J");
    }
  }

  public static boolean isFirstLetterJ(String name) {
    return name.toLowerCase().startsWith("j");
  }
}
