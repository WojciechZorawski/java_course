package loops_tasks;

import java.util.Random;
import java.util.Scanner;

public class Task3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Zagrajmy w grę...");
    System.out.println("Odgadnij liczbę. Swój typ wpisz poniżej:");
    int userNumber = scanner.nextInt();
    game(userNumber, generateRandomNumbers());
  }

  public static int generateRandomNumbers() {
    int min = 1;
    int max = 1000;
    Random random = new Random();
    int wantedNumber = random.nextInt(max - min) + min;
    return wantedNumber;
  }

  public static void game(int userNumber, int wantedNumber) {
    Scanner scanner = new Scanner(System.in);
    while (userNumber != wantedNumber) {
      if (userNumber > wantedNumber) {
        System.out.println("Szukana liczba jest mniejsza. Próbuj dalej");
        userNumber = scanner.nextInt();
      } else {
        System.out.println("Szukana liczba jest większa. Próbuj dalej");
        userNumber = scanner.nextInt();
      }
    }
    System.out.println("Brawo! To ta liczba");
  }

}


