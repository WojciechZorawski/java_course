package loops_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task15 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj pierwszą liczbę:");
    int firstNumber = scanner.nextInt();
    System.out.println("Podaj drugą liczbę:");
    int secondNumber = scanner.nextInt();
    List<Integer> elementsOfFirstNumber = findPrimeFactors(firstNumber, new ArrayList<>());
    List<Integer> elementsOfSecondNumber = findPrimeFactors(secondNumber, new ArrayList<>());
    System.out.println("Czynniki pierwsze liczby " + firstNumber + " to " + elementsOfFirstNumber);
    System.out.println("Czynniki pierwsze liczby " + secondNumber + " to " + elementsOfSecondNumber);
    List<Integer> commonElements;
    if (elementsOfFirstNumber.size() < elementsOfSecondNumber.size()) {
      commonElements = findCommonElements(elementsOfFirstNumber, elementsOfSecondNumber);
    } else {
      commonElements = findCommonElements(elementsOfSecondNumber, elementsOfFirstNumber);
    }
    System.out.println("Wspólne czynniki pierwsze obu liczb to " + commonElements);
    System.out.println("Największy wspólny dzielnik liczby " + firstNumber + " i " + secondNumber + " to: " + calculateNWD(commonElements));
  }

  public static List<Integer> findPrimeFactors(int number, List<Integer> elements) {
    int i = 2;
    while (number % i != 0) {
      i++;
    }
    elements.add(i);
    number /= i;
    if (number > 1) {
      findPrimeFactors(number, elements);
    }
    return elements;
  }

  public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
    List<Integer> commonElements = new ArrayList<>();
    for (Integer element : list1) {
      if (list2.contains(element)) {
        commonElements.add(element);
        list2.remove(element);
      }
    }
    return commonElements;
  }

  public static int calculateNWD(List<Integer> commonElements) {
    int NWD = 1;
    for (Integer element : commonElements) {
      NWD *= element;
    }
    return NWD;
  }
}
