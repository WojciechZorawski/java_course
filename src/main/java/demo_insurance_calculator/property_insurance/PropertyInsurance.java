package demo_insurance_calculator.property_insurance;

import static demo_insurance_calculator.CommonUtils.getValidNumericUserInput;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.DEFAULT_FLAT_INSURANCE_PREMIUM;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.DEFAULT_HOUSE_INSURANCE_PREMIUM;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.FIRST_LEVEL_FLAT_SUM_INSURED_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.FIRST_LEVEL_HOUSE_SUM_INSURED_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.FIRST_LEVEL_YEAR_OF_CONSTRUCTION_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.FLAT_GROUND_FLOOR;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.FLAT_GROUND_FLOOR_OR_LAST_FLOOR_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.FOURTH_LEVEL_FLAT_SUM_INSURED_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.FOURTH_LEVEL_HOUSE_SUM_INSURED_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.HOUSE_SKYLIGHTS_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_FLAT_SUM_INSURED_WITHOUT_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_FLAT_SUM_INSURED_WITH_FIRST_LEVEL_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_FLAT_SUM_INSURED_WITH_SECOND_LEVEL_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_FLAT_SUM_INSURED_WITH_THIRD_LEVEL_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_HOUSE_SUM_INSURED_WITHOUT_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_HOUSE_SUM_INSURED_WITH_FIRST_LEVEL_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_HOUSE_SUM_INSURED_WITH_SECOND_LEVEL_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_HOUSE_SUM_INSURED_WITH_THIRD_LEVEL_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_METRAGE_WITHOUT_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_NUMBER_OF_FLOORS_WITHOUT_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_YEAR_OF_CONSTRUCTION_WITHOUT_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_YEAR_OF_CONSTRUCTION_WITH_FIRST_LEVEL_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MAXIMUM_YEAR_OF_CONSTRUCTION_WITH_SECOND_LEVEL_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.METRAGE_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MOVABLE_FLAT_DIVIDER;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.MOVABLE_HOUSE_DIVIDER;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.NUMBER_OF_FLOORS_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.SECOND_LEVEL_FLAT_SUM_INSURED_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.SECOND_LEVEL_HOUSE_SUM_INSURED_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.SECOND_LEVEL_YEAR_OF_CONSTRUCTION_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.THIRD_LEVEL_FLAT_SUM_INSURED_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.THIRD_LEVEL_HOUSE_SUM_INSURED_INCREASE;
import static demo_insurance_calculator.property_insurance.ConstPropertyInsuranceVariant.THIRD_LEVEL_YEAR_OF_CONSTRUCTION_INCREASE;

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
    insurancePremium *= 1 + movableSumInsured / MOVABLE_FLAT_DIVIDER;
    return insurancePremium;
  }

  private Double calculateFlatInsuranceWithoutMovable() {
    insurancePremium = DEFAULT_FLAT_INSURANCE_PREMIUM;

    increaseIncurancePremiumByMetrage();
    int numberOfFloors = increaseInsurancePremiumByFloorsNumber();
    increaseInsurancePremiumByYearOfConstruction();
    increaseInsurancePremiumForGroundFloorOrLastFloor(numberOfFloors);
    increaseInsurancePremiumByFlatInsuranceSum();
    return insurancePremium;
  }

  private void increaseInsurancePremiumByHouseInsuranceSum() {
    System.out.print("9. Na jaką sumę chcesz ubezpieczyć dom (w PLN): ---> ");
    int sumInsured = getValidNumericUserInput(scanner);;
    System.out.println();

    if (sumInsured > MAXIMUM_HOUSE_SUM_INSURED_WITH_THIRD_LEVEL_INCREASE) {
      insurancePremium *= FOURTH_LEVEL_HOUSE_SUM_INSURED_INCREASE;
    } else if (sumInsured > MAXIMUM_HOUSE_SUM_INSURED_WITH_SECOND_LEVEL_INCREASE) {
      insurancePremium *= THIRD_LEVEL_HOUSE_SUM_INSURED_INCREASE;
    } else if (sumInsured > MAXIMUM_HOUSE_SUM_INSURED_WITH_FIRST_LEVEL_INCREASE) {
      insurancePremium *= SECOND_LEVEL_HOUSE_SUM_INSURED_INCREASE;
    } else if (sumInsured > MAXIMUM_HOUSE_SUM_INSURED_WITHOUT_INCREASE) {
      insurancePremium *= FIRST_LEVEL_HOUSE_SUM_INSURED_INCREASE;
    }
  }

  private void increaseInsurancePremiumByFlatInsuranceSum() {
    System.out.print("9. Na jaką sumę chcesz ubezpieczyć mieszkanie (w PLN): ---> ");
    int sumInsured = getValidNumericUserInput(scanner);;
    System.out.println();

    if (sumInsured > MAXIMUM_FLAT_SUM_INSURED_WITH_THIRD_LEVEL_INCREASE) {
      insurancePremium *= FOURTH_LEVEL_FLAT_SUM_INSURED_INCREASE;
    } else if (sumInsured > MAXIMUM_FLAT_SUM_INSURED_WITH_SECOND_LEVEL_INCREASE) {
      insurancePremium *= THIRD_LEVEL_FLAT_SUM_INSURED_INCREASE;
    } else if (sumInsured > MAXIMUM_FLAT_SUM_INSURED_WITH_FIRST_LEVEL_INCREASE) {
      insurancePremium *= SECOND_LEVEL_FLAT_SUM_INSURED_INCREASE;
    } else if (sumInsured > MAXIMUM_FLAT_SUM_INSURED_WITHOUT_INCREASE) {
      insurancePremium *= FIRST_LEVEL_FLAT_SUM_INSURED_INCREASE;
    }
  }

  private void increaseInsurancePremiumByYearOfConstruction() {
    System.out.println("7. Podaj rok budowy budynku");
    int yearOfConstruction = getValidNumericUserInput(scanner);;
    System.out.println();
    if (yearOfConstruction < MAXIMUM_YEAR_OF_CONSTRUCTION_WITH_SECOND_LEVEL_INCREASE) {
      insurancePremium *= THIRD_LEVEL_YEAR_OF_CONSTRUCTION_INCREASE;
    } else if (yearOfConstruction < MAXIMUM_YEAR_OF_CONSTRUCTION_WITH_FIRST_LEVEL_INCREASE) {
      insurancePremium *= SECOND_LEVEL_YEAR_OF_CONSTRUCTION_INCREASE;
    } else if (yearOfConstruction < MAXIMUM_YEAR_OF_CONSTRUCTION_WITHOUT_INCREASE) {
      insurancePremium *= FIRST_LEVEL_YEAR_OF_CONSTRUCTION_INCREASE;
    }
  }

  private void increaseInsurancePremiumForGroundFloorOrLastFloor(int numberOfFloors) {
    System.out.println("8. Numer piętra na którym znajduje się ubezpieczane mieszkanie. Jeśli parter - wpisz 0");
    int floorNumber = getValidNumericUserInput(scanner);;
    System.out.println();
    if (floorNumber == FLAT_GROUND_FLOOR || floorNumber == numberOfFloors) {
      insurancePremium *= FLAT_GROUND_FLOOR_OR_LAST_FLOOR_INCREASE;
    }
  }

  private int increaseInsurancePremiumByFloorsNumber() {
    System.out.println("6. Podaj ilość pięter w budynku");
    int numberOfFloors = getValidNumericUserInput(scanner);;
    System.out.println();
    if (numberOfFloors > MAXIMUM_NUMBER_OF_FLOORS_WITHOUT_INCREASE) {
      insurancePremium *= NUMBER_OF_FLOORS_INCREASE;
    }
    return numberOfFloors;
  }

  private void increaseIncurancePremiumByMetrage() {
    System.out.println("5. Podaj metraż nieruchomości w m2");
    int metrage = getValidNumericUserInput(scanner);;
    System.out.println();
    if (metrage > MAXIMUM_METRAGE_WITHOUT_INCREASE) {
      insurancePremium *= METRAGE_INCREASE;
    }
  }

  private Double calculateHouseInsuranceWithMovable() {
    System.out.print("10. Na jaką sumę chcesz ubezpieczyć ruchomości domowe (w PLN): ---> ");
    int movableSumInsured = getValidNumericUserInput(scanner);;
    insurancePremium *= 1 + movableSumInsured / MOVABLE_HOUSE_DIVIDER;
    return insurancePremium;
  }

  private Double calculateHouseInsuranceWithoutMovable() {
    insurancePremium = DEFAULT_HOUSE_INSURANCE_PREMIUM;
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
      insurancePremium *= HOUSE_SKYLIGHTS_INCREASE;
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
