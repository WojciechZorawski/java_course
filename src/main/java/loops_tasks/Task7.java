package loops_tasks;

import java.util.Scanner;

public class Task7 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj wielkość wieżyczki:");
    int towerSize = scanner.nextInt();
    generateTower(towerSize);
    System.out.println("Podaj wielkość choinki:");
    int treeSize = scanner.nextInt();
    generateTree(treeSize);
  }

  public static void generateTower(int towerSize) {
    for (int i = 0; i < towerSize; i++) {
      for (int a = 0; a <= i; a++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void generateTree(int treeSize) {
    for (int i = 0; i <= treeSize; i++) {
      for (int a = (treeSize - 1); a >= i; a--) {
        System.out.print(" ");
      }
      for (int b = 1; b <= 2 * i - 1; b++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
