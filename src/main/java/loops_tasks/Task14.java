package loops_tasks;

import java.util.Scanner;

public class Task14 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj imię:");
    String name = scanner.nextLine();
    System.out.println(printEverySecondLetter(name));
  }

  public static String printEverySecondLetter(String name) {
    String everySecondLetter = "";
    for (int i = 0; i <= name.length() - 1; i += 2) {
      everySecondLetter += String.valueOf(name.charAt(i));
    }
    return everySecondLetter;
  }
}
