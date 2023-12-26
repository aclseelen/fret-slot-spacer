package eu.acls.fretslotspacer.entities;

import eu.acls.fretslotspacer.util.Util;

public record ScaleLength(double length, LengthUnit lengthUnit) {

  public double toMillimeters() {
    return switch (lengthUnit) {
      case MILLIMETERS -> length;
      case INCHES -> Util.inchesToMillimeters(length);
    };
  }
}
