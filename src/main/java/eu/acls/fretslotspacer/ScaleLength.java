package eu.acls.fretslotspacer;

public class ScaleLength {

  private double length;
  private LengthUnit lengthUnit;

  public ScaleLength(double length, LengthUnit lengthUnit) {
    this.length = length;
    this.lengthUnit = lengthUnit;
  }

  public double toMillimeters() {
    return switch (lengthUnit) {
      case MILLIMETERS -> length;
      case INCHES -> Util.inchesToMillimeters(length);
    };
  }
}
