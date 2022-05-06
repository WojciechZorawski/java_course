package demo_insurance_calculator.motor_insurance;

public enum MotorInsuranceVariant {

  ONLY_OC ("Samo OC"),
  OC_NNW ("OC + NNW (suma ubezpieczenia 15 000 PLN/osoba"),
  OC_NNW_ASSISTANCE ("OC + NNW (suma ubezpieczenia 15 000 PLN/osoba) + Assistance");

  private final String variantDescription;

  public String getVariantDescription() {
    return variantDescription;
  }

  MotorInsuranceVariant(String variantDescription) {
    this.variantDescription = variantDescription;
  }
}
