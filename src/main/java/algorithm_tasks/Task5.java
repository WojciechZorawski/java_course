package algorithm_tasks;

public class Task5 {

  public static void main(String[] args) {
    for (int i = 1; i < 101; i++) {
      boolean isDivisibleByThree = i % 3 == 0;
      boolean isDivisibleByFive = i % 5 == 0;
      boolean isDivisibleByFiveteen = i % 15 == 0;
      if (isDivisibleByFiveteen) {
        System.out.println("FizzBuzz");
      } else if (isDivisibleByThree) {
        System.out.println("Fizz");
      } else if (isDivisibleByFive) {
        System.out.println("Buzz");
      } else {
        System.out.println(i);
      }
    }
  }
}
