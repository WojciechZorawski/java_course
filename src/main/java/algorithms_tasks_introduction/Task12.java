package algorithms_tasks_introduction;

public class Task12 {

  public static void main(String[] args) {
    String[] array = { "BARTEK", "ASIA", "MOTORÓWKA", "HELIKOPTER", "KOT" };
    System.out.println("Ilość liter w najdłuższym wyrazie to: " + getTheLongestWord(array));

  }

  public static int getTheLongestWord(String[] array) {
    int numberOfLetters = 0;
    for (String word : array) {
      if (word.length() > numberOfLetters) {
        numberOfLetters = word.length();
      }
    }
    return numberOfLetters;
  }

}
