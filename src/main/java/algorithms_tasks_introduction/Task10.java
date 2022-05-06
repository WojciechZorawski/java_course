package algorithms_tasks_introduction;

import java.util.Arrays;

public class Task10 {

  public static void main(String[] args) {
    String[] array = { "Jacek", "Ania", "Piotr", "Ola" };
    System.out.println("Wyrazy pięcioliterowe to " + Arrays.toString(getOnlyFiveLetterWords(array)));
  }

  public static String[] getOnlyFiveLetterWords(String[] array) {
    int counter = 0;
    String[] onlyFiveLetterWords = new String[ counter ];
    for (String s : array) {
      if (s.length() == 5) {
        counter++;
        String[] tmp = new String[ counter ];
        for (int j = 0; j < onlyFiveLetterWords.length; j++) {
          tmp[ j ] = onlyFiveLetterWords[ j ];
        }
        onlyFiveLetterWords = tmp;
        onlyFiveLetterWords[ counter - 1 ] = s;
      }
    }
    return onlyFiveLetterWords;
  }
}


