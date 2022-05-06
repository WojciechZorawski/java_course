package demo_insurance_calculator.motor_insurance;

import static demo_insurance_calculator.CommonUtils.getValidNumericUserInput;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.ASSISTANCE_PRICE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.DEFAULT_INSURANCE_PREMIUM;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.FIRST_LEVEL_CAR_AGE_INCREASE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.FIRST_LEVEL_ENGINE_CAPACITY_INCREASE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.MAXIMUM_CAR_AGE_WITHOUT_INCREASE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.MAXIMUM_CAR_AGE_WITH_FIRST_LEVEL_INCREASE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.MAXIMUM_ENGINE_CAPACITY_WITHOUT_INCREASE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.MAXIMUM_ENGINE_CAPACITY_WITH_FIRST_LEVEL_INCREASE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.MINIMUM_YEARS_OF_HAVING_DRIVING_LICENSE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.NNW_PRICE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.PACKAGE_WITH_NNW_AND_ASSISTANCE_DISCOUNT;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.PACKAGE_WITH_NNW_DISCOUNT;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.SECOND_LEVEL_CAR_AGE_INCREASE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.SECOND_LEVEL_ENGINE_CAPACITY_INCREASE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.UNEXPERIENCED_DRIVER_INCREASE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.YOUNG_DRIVER_AGE;
import static demo_insurance_calculator.motor_insurance.ConstMotorInsuranceValues.YOUNG_DRIVER_AGE_INCREASE;

import demo_insurance_calculator.FileCreator;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class MotorInsurance {

  private final Scanner scanner = new Scanner(System.in);
  private double insurancePremium = DEFAULT_INSURANCE_PREMIUM;

  public void getInformationMotorInsurance(String userName) {
    System.out.println(userName + ". Wybrałeś produkt Ubezpieczenie OC pojazdu. Aby obliczyć składkę ubezpieczenia potrzebuję kilku podstawowych informacji. "
                           + "Odpowiedz proszę na poniższe pytania: ");
    System.out.println("1. Podaj imię i nazwisko właściciela pojazdu.");
    String vehicleOwner = scanner.nextLine();
    System.out.println();
    increaseInsurancePremiumForYoungOwner();
    increaseInsurancePremiumForUnexperiencedDrivers();
    System.out.println("4. Podaj markę pojazdu.");
    String vehicleBrand = scanner.next();
    System.out.println();
    System.out.println("5. Podaj model pojazdu");
    String vehicleModel = scanner.next();
    System.out.println();
    increaseInsurancePremiumForOldVehicles();
    increaseInsurancePremiumForEngineCapacity();
    increaseInsurancePremiumForYoungDriver();

    System.out.println(
        "Dziękuję za informacje " + userName + ". Jeszcze chwila i poznasz składkę ubezpieczenia twojego pojazdu");

    calculateInsurancePrimeOfChosenVariant(vehicleOwner, vehicleBrand, vehicleModel);
  }

  private void calculateInsurancePrimeOfChosenVariant(String vehicleOwner, String vehicleBrand, String vehicleModel) {
    String motorVariantAnswer = "";

    boolean exit = true;
    while (exit) {
      System.out.println("Wybierz wariant ubezpieczenia wpisując literę odpowiadającą temu wariantowi: ");
      System.out.println("A - " + MotorInsuranceVariant.ONLY_OC.getVariantDescription());
      System.out.println("B - " + MotorInsuranceVariant.OC_NNW.getVariantDescription());
      System.out.println("C - " + MotorInsuranceVariant.OC_NNW_ASSISTANCE.getVariantDescription());
      motorVariantAnswer = scanner.next();

      switch (motorVariantAnswer) {
        case "a":
        case "A": {
          motorVariantAnswer = MotorInsuranceVariant.ONLY_OC.getVariantDescription();
          exit = false;
          break;
        }
        case "b":
        case "B": {
          calculateOcAndNnwVariantMotorInsurance();
          motorVariantAnswer = MotorInsuranceVariant.OC_NNW.getVariantDescription();
          exit = false;
          break;
        }
        case "c":
        case "C": {
          calculateOcNnwAndAssistanceVariantMotorInsurance();
          motorVariantAnswer = MotorInsuranceVariant.OC_NNW_ASSISTANCE.getVariantDescription();
          exit = false;
          break;
        }
        default: {
          System.out.println("Podano złą odpowiedź.");
          break;
        }
      }
    }
    roundMotorPrice();
    createMotorCalculationFile(vehicleOwner, vehicleBrand, vehicleModel, motorVariantAnswer);
  }

  private void calculateOcAndNnwVariantMotorInsurance() {
    insurancePremium += NNW_PRICE;
    insurancePremium *= PACKAGE_WITH_NNW_DISCOUNT;
  }

  private void calculateOcNnwAndAssistanceVariantMotorInsurance() {
    insurancePremium += NNW_PRICE;
    insurancePremium += ASSISTANCE_PRICE;
    insurancePremium *= PACKAGE_WITH_NNW_AND_ASSISTANCE_DISCOUNT;
  }

  private void increaseInsurancePremiumForYoungOwner() {
    System.out.println("2. Podaj wiek właściciela pojazdu");
    int age = getValidNumericUserInput(scanner);
    System.out.println();

    if (age < YOUNG_DRIVER_AGE) {
      insurancePremium *= YOUNG_DRIVER_AGE_INCREASE;
    }
  }

  private void increaseInsurancePremiumForUnexperiencedDrivers() {
    System.out.println("3. Podaj rok uzyskania prawa jazdy właściciela pojazdu");
    int yearOfGettingDrivingLicense = getValidNumericUserInput(scanner);
    System.out.println();

    if (yearOfGettingDrivingLicense >= LocalDate.now().getYear() - MINIMUM_YEARS_OF_HAVING_DRIVING_LICENSE) {
      insurancePremium *= UNEXPERIENCED_DRIVER_INCREASE;
    }
  }

  private void increaseInsurancePremiumForOldVehicles() {

    System.out.println("6. Podaj rok produkcji pojazdu");
    int yearOfProduction = getValidNumericUserInput(scanner);
    System.out.println();

    if (yearOfProduction < LocalDate.now().getYear() - MAXIMUM_CAR_AGE_WITH_FIRST_LEVEL_INCREASE) {
      insurancePremium *= SECOND_LEVEL_CAR_AGE_INCREASE;
    } else if (yearOfProduction < LocalDate.now().getYear() - MAXIMUM_CAR_AGE_WITHOUT_INCREASE) {
      insurancePremium *= FIRST_LEVEL_CAR_AGE_INCREASE;
    }
  }

  private void increaseInsurancePremiumForEngineCapacity() {

    System.out.println("7. Podaj pojemność silnika w cm3");
    int engineCapacity = getValidNumericUserInput(scanner);
    System.out.println();

    if (engineCapacity > MAXIMUM_ENGINE_CAPACITY_WITH_FIRST_LEVEL_INCREASE) {
      insurancePremium *= SECOND_LEVEL_ENGINE_CAPACITY_INCREASE;
    } else if (engineCapacity > MAXIMUM_ENGINE_CAPACITY_WITHOUT_INCREASE) {
      insurancePremium *= FIRST_LEVEL_ENGINE_CAPACITY_INCREASE;
    }
  }

  private void increaseInsurancePremiumForYoungDriver() {
    System.out.println("8. Czy pojazd będzie użytkować inna prócz właścicela osoba poniżej 24 roku życia? Odpowiedz T jeśli TAK lub N jeśli NIE.");
    String willVehicleBeUsedByPersonUnder24 = scanner.next();
    System.out.println();

    if (willVehicleBeUsedByPersonUnder24.equalsIgnoreCase("T")) {
      insurancePremium *= YOUNG_DRIVER_AGE_INCREASE;
    }
  }

  private void roundMotorPrice() {
    System.out.println();
    System.out.println("Składka ubezpieczeniowa w wybranym wariancie wynosi " + String.format(Locale.GERMAN, "%,.2f", insurancePremium) + " PLN");
    System.out.println();
  }

  private void createMotorCalculationFile(String vehicleOwner, String vehicleBrand, String vehicleModel, String motorVariantAnswer) {
    FileCreator.createMotorInsuranceFile(vehicleOwner, vehicleBrand, vehicleModel,
                                         String.format(Locale.GERMAN, "%,.2f", insurancePremium), motorVariantAnswer);
    System.out.println(
        "W razie chęci zakupu polisy ubezpieczeniowej zachęcam do kontaktu z naszym agentem ubezpieczeniowym - nr tel. 696 538 317. Do widzenia!");
  }

}

