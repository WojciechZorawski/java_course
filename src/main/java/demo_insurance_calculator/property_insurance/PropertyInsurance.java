package demo_insurance_calculator.property_insurance;

import static demo_insurance_calculator.CommonUtils.getValidNumericUserInput;

import demo_insurance_calculator.FileCreator;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Supplier;

public class PropertyInsurance {

  private final Scanner scanner = new Scanner(System.in);
  double insurancePremium;

  public void getInformationPropertyInsurance(String userName) {
    System.out.println(
        userName + ". Wybrałeś produkt Ubezpieczenie nieruchomości. Aby obliczyć składkę ubezpieczenia potrzebuję kilku podstawowych informacji. "
            + "Odpowiedz proszę na poniższe pytania: ");
    System.out.println("1. Podaj imię i nazwisko właściciela nieruchomości");
    String propertyOwner = scanner.nextLine();
    System.out.println();
    System.out.println("2. Podaj adres nieruchomości - ulica, nr domu/mieszkania, kod pocztowy, miejscowość.");
    String propertyAddress = scanner.nextLine();
    System.out.println();

    boolean exit = true;
    while (exit) {

      System.out.println("3. Jeśli ubezpieczana nieruchomość to mieszkanie wpisz proszę M, jeśli dom - wpisz proszę D");
      String propertyChoice = scanner.next();
      System.out.println();

      switch (propertyChoice) {
        case "m":
        case "M": {
          calculateInsurance(userName, this::calculateFlatInsuranceWithoutMovable, this::calculateFlatInsuranceWithMovable);
          exit = false;
          break;
        }
        case "d":
        case "D": {
          calculateInsurance(userName, this::calculateHouseInsuranceWithoutMovable, this::calculateHouseInsuranceWithMovable);
          exit = false;
          break;
        }
        default: {
          System.out.println("Podano złą odpowiedź.");
          break;
        }
      }
    }
    roundPropertyPrice();
    FileCreator.createPropertyInsuranceFile(propertyOwner, propertyAddress, String.format(Locale.GERMAN, "%,.2f", insurancePremium));
  }

  private void calculateInsurance(String userName, Supplier<Double> funcWithoutMovable, Supplier<Double> funcWithMovable){
    System.out.println("4. Czy chcesz ubezpieczyć ruchomości domowe (tj. wyposażenie oraz rzeczy osobiste)? Odpowiedz T jeśli TAK lub N jeśli NIE.");
    String ifInsureMovableProperty = scanner.next();
    System.out.println();

    insurancePremium = funcWithoutMovable.get();

    if (ifInsureMovableProperty.equalsIgnoreCase("T")) {
      insurancePremium = funcWithMovable.get();
    }
    System.out.println("Dziękuję za informacje " + userName);
  }

  private Double calculateFlatInsuranceWithMovable() {
    System.out.print("10. Na jaką sumę chcesz ubezpieczyć ruchomości domowe (w PLN): ---> ");
    int movableSumInsured = getValidNumericUserInput(scanner);;
    insurancePremium *= 1 + movableSumInsured / 100000;
    return insurancePremium;
  }

  private Double calculateFlatInsuranceWithoutMovable() {
    insurancePremium = 100;

    increaseIncurancePremiumByMetrage();
    int numberOfFloors = increaseInsurancePremiumByFloorsNumber();
    increaseInsurancePremiumForFirstOrLastFloor(numberOfFloors);
    increaseInsurancePremiumByYearOfConstruction();
    increaseInsurancePremiumByFlatInsuranceSum();
    return insurancePremium;
  }

  private void increaseInsurancePremiumByHouseInsuranceSum() {
    System.out.print("9. Na jaką sumę chcesz ubezpieczyć dom (w PLN): ---> ");
    int sumInsured = getValidNumericUserInput(scanner);;
    System.out.println();

    if (sumInsured > 999999) {
      insurancePremium *= 2;
    } else if (sumInsured > 799999) {
      insurancePremium *= 1.8;
    } else if (sumInsured > 499999) {
      insurancePremium *= 1.6;
    } else if (sumInsured > 299999) {
      insurancePremium *= 1.3;
    }
  }

  private void increaseInsurancePremiumByFlatInsuranceSum() {
    System.out.print("9. Na jaką sumę chcesz ubezpieczyć mieszkanie (w PLN): ---> ");
    int sumInsured = getValidNumericUserInput(scanner);;
    System.out.println();

    if (sumInsured > 999999) {
      insurancePremium *= 2;
    } else if (sumInsured > 799999) {
      insurancePremium *= 1.8;
    } else if (sumInsured > 499999) {
      insurancePremium *= 1.6;
    } else if (sumInsured > 299999) {
      insurancePremium *= 1.3;
    }
  }

  private void increaseInsurancePremiumByYearOfConstruction() {
    System.out.println("7. Podaj rok budowy budynku");
    int yearOfConstruction = getValidNumericUserInput(scanner);;
    System.out.println();
    if (yearOfConstruction < 1980) {
      insurancePremium *= 1.6;
    } else if (yearOfConstruction < 2000) {
      insurancePremium *= 1.3;
    } else if (yearOfConstruction < 2012) {
      insurancePremium *= 1.1;
    }
  }

  private void increaseInsurancePremiumForFirstOrLastFloor(int numberOfFloors) {
    System.out.println("7. Numer piętra na którym znajduje się ubezpieczane mieszkanie. Jeśli parter - wpisz 0");
    int floorNumber = getValidNumericUserInput(scanner);;
    System.out.println();
    if (floorNumber == 0 || floorNumber == numberOfFloors) {
      insurancePremium *= 1.6;
    }
  }

  private int increaseInsurancePremiumByFloorsNumber() {
    System.out.println("6. Podaj ilość pięter w budynku");
    int numberOfFloors = getValidNumericUserInput(scanner);;
    System.out.println();
    if (numberOfFloors > 3) {
      insurancePremium *= 1.15;
    }
    return numberOfFloors;
  }

  private void increaseIncurancePremiumByMetrage() {
    System.out.println("5. Podaj metraż nieruchomości w m2");
    int metrage = getValidNumericUserInput(scanner);;
    System.out.println();
    if (metrage > 40) {
      insurancePremium *= 1.5;
    }
  }

  private Double calculateHouseInsuranceWithMovable() {
    System.out.print("10. Na jaką sumę chcesz ubezpieczyć ruchomości domowe (w PLN): ---> ");
    int movableSumInsured = getValidNumericUserInput(scanner);;
    insurancePremium *= 1 + movableSumInsured / 80000;
    return insurancePremium;
  }

  private Double calculateHouseInsuranceWithoutMovable() {
    insurancePremium = 200;
    increaseIncurancePremiumByMetrage();
    increaseInsurancePremiumByFloorsNumber();
    increaseInsurancePremiumByYearOfConstruction();
    increaseInsurancePremiumBySkyLights();
    increaseInsurancePremiumByHouseInsuranceSum();

    return insurancePremium;
  }

  private void increaseInsurancePremiumBySkyLights() {
    System.out.println("8. Czy w domu znajdują się okna dachowe? Odpowiedz T jeśli TAK lub N jeśli NIE.");
    String areThereSkyLights = scanner.next();
    System.out.println();
    if (areThereSkyLights.equalsIgnoreCase("T")) {
      insurancePremium *= 1.2;
    }
  }

  private void roundPropertyPrice() {
    System.out.println();
    System.out.println("Składka ubezpieczeniowa w wybranym wariancie wynosi " + String.format(Locale.GERMAN, "%,.2f", insurancePremium) + " PLN");
    System.out.println();
    System.out.println(
        "W razie chęci zakupu polisy ubezpieczeniowej zachęcam do kontaktu z naszym agentem ubezpieczeniowym - nr tel. 696 538 317. Do widzenia!");
  }

}
