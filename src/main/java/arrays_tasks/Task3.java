package arrays_tasks;

public class Task3 {

  public static void main(String[] args) {
    int[] array = { 15, 16 };
    System.out.println("Suma elementów tablicy to: " + addArrayElements(array));

  }

  public static int addArrayElements(int[] array) {
    return array[ 0 ] + array[ 1 ];
  }
}
