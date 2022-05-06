package algorithms_tasks_introduction;

import java.util.Scanner;

public class Task27 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać pesel:");
    String personalNumber = scanner.nextLine();
    if (isNumberAPersonalNumber(personalNumber)) {
      System.out.println("Podany wyraz jest peselem");
    } else {
      System.out.println("Podany wyraz jest błędny");
    }
  }

  public static boolean isNumberAPersonalNumber(String personalNumber) {
    return personalNumber.matches("[0-9]{11}");
  }
}


