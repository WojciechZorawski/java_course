package demo_insurance_calculator;

import demo_insurance_calculator.motor_insurance.MotorInsurance;
import demo_insurance_calculator.property_insurance.PropertyInsurance;
import java.util.Scanner;

public class InsuranceCalculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Dzień dobry! Podaj swoję imię, abym wiedział z kim rozmawiam: ");
    String userName = scanner.nextLine();

    System.out.println(userName + ", miło mi Cię poznać! Dziękuję za zainteresowanie ofertą naszego towarzystwa ubezpieczeniowego. ");

    boolean exit = true;
    while (exit) {
      System.out.println("Wybierz produkt, który Cię interesuje, wpisując literę odpowiadającą temu produktowi:");
      System.out.println("A - Ubezpieczenie OC pojazdu");
      System.out.println("B - Ubezpieczenie nieruchomości");
      String productAnswer = scanner.nextLine();

      switch (productAnswer) {
        case "a":
        case "A": {
          MotorInsurance motorInsurance = new MotorInsurance();
          motorInsurance.getInformationMotorInsurance(userName);
          exit = false;
          break;
        }
        case "b":
        case "B": {
          PropertyInsurance propertyInsurance = new PropertyInsurance();
          propertyInsurance.getInformationPropertyInsurance(userName);
          exit = false;
          break;
        }
        default:
          System.out.println("Podano złą odpowiedź.");
          break;
      }
    }
  }
}

