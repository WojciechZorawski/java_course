package loops_tasks;

import java.util.Scanner;

public class Task5 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj hasło:");
    String userPassword = scanner.nextLine();
    checkPassword(userPassword);
  }

  public static void checkPassword(String userPassword) {
    Scanner scanner = new Scanner(System.in);
    String truePassword = "Polska";
    while (!userPassword.equals(truePassword)) {
      System.out.println("Podaj poprawne hasło:");
      userPassword = scanner.nextLine();
    }
    System.out.println("Hasło poprawne");
  }
}

