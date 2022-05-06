package algorithms_tasks_introduction;

public class Task25 {

  public static void main(String[] args) {
    System.out.println("Liczba od 2 do 10000, która ma największą liczbę dzielników to: " + getNumberWithTheBiggestNumberOfDivisors());
  }

  public static int getNumberWithTheBiggestNumberOfDivisors() {
    int numberOfDivisors = 0;
    int number = 0;
    for (int i = 2; i <= 10000; i++) {
      int divisors = findDivisors(i);
      if (divisors > numberOfDivisors) {
        numberOfDivisors = divisors;
        number = i;
      }
    }
    return number;
  }

  public static int findDivisors(int number) {
    int counter = 2;
    for (int i = 2; i <= number / 2; i++) {
      if (number % i == 0) {
        counter++;
      }
    }
    return counter;
  }
}
