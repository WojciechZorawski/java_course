package demo_insurance_calculator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class FileCreator {

  public static void createMotorInsuranceFile(String vehicleOwner, String vehicleBrand, String vehicleModel, String price, String motorVariant) {
    try {
      UUID calculationNumber = UUID.randomUUID();
      String fileName = "motor_insurance_calculation_" + calculationNumber + ".txt";
      File insurance_calculation = new File("C:\\Users\\Wojciech Żórawski\\Desktop\\" + fileName);
      PrintWriter printWriter = new PrintWriter(insurance_calculation);
      printWriter.println("Kalkulacja ubezpieczenia nr " + calculationNumber);
      printWriter.println("Właściciel pojazdu: " + vehicleOwner);
      printWriter.println("Samochód: " + vehicleBrand + " " + vehicleModel);
      printWriter.println("Składka ubezpieczenia w pakiecie "+ motorVariant + " wynosi: " + price + " PLN.");
      printWriter.close();
      System.out.println("Plik został zapisany na pulpicie: " + insurance_calculation.getName());
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void createPropertyInsuranceFile(String propertyOwner, String propertyAdress, String price) {
    try {
      UUID calculationNumber = UUID.randomUUID();
      String fileName = "property_insurance_calculation_" + calculationNumber + ".txt";
      File insurance_calculation = new File("C:\\Users\\Wojciech Żórawski\\Desktop\\" + fileName);
      PrintWriter printWriter = new PrintWriter(insurance_calculation);
      printWriter.println("Kalkulacja ubezpieczenia nr " + calculationNumber);
      printWriter.println("Właściciel nieruchomości: " + propertyOwner);
      printWriter.println("Adres nieruchomości: " + propertyAdress);
      printWriter.println("Składka ubezpieczenia w wybranym pakiecie: " + price + " PLN.");
      printWriter.close();
      System.out.println("Plik został zapisany na pulpicie: " + insurance_calculation.getName());
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

}


