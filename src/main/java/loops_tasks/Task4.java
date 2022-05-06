package loops_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task4 {

  public static void main(String[] args) {
    System.out.println("Wylosowane liczby w dzisiejszym losowaniu to: " + lottery());
  }

  public static List lottery() {
    Random random = new Random();
    List numbers = new ArrayList<>();
    for (int i = 1; i < 7; i++) {
      int number = random.nextInt(49) + 1;
      numbers.add(number);
    }
    return numbers;
  }
}
