package algorithm_tasks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Task4 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Proszę podać kilka liczb oddzielonych przecinkami");
    System.out.println("Podana lista liczb po usunięciu duplikatów to: " + parseStringToSet(scanner.nextLine()));

  }

  public static Set<Integer> parseStringToSet(String userInput) {
    Set<Integer> userNumbers = Arrays.stream(userInput.split(",")).map(Integer::parseInt).collect(Collectors.toSet());
    return userNumbers;
  }

}
