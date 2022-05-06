package algorithms_tasks_introduction;

import java.util.Arrays;

public class Task14 {

  public static void main(String[] args) {
    boolean[] array = { false, true, true };
    System.out.println("Podana tablica to: " + Arrays.toString(array));
    System.out.println("Nowa tablica to: " + Arrays.toString(getOnlyTrueElements(array)));

  }

  public static boolean[] getOnlyTrueElements(boolean[] array) {
    int counter = 0;
    boolean[] onlyTrueElements = new boolean[ counter ];
    for (boolean element : array) {
      if (element) {
        counter++;
        onlyTrueElements = Arrays.copyOf(onlyTrueElements, counter);
        onlyTrueElements[ counter - 1 ] = element;
      }
    }
    return onlyTrueElements;
  }
}


