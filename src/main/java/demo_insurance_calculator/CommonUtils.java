package demo_insurance_calculator;

import java.util.Scanner;

public class CommonUtils {
  public static int getValidNumericUserInput(Scanner scanner){
    while (!scanner.hasNextInt()) {
      System.out.println("Podano złą odpowiedź. Proszę podać liczbę.");
      scanner.next();
    }
    int userInput = scanner.nextInt();
    return userInput;
  }
}
