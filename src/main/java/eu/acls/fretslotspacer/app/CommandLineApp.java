package eu.acls.fretslotspacer.app;

import eu.acls.fretslotspacer.Calculator;
import eu.acls.fretslotspacer.entities.*;
import eu.acls.fretslotspacer.util.DefaultTsDistanceCollections;

import java.io.Console;

public class CommandLineApp {

  public static final String INVALID_INPUT_IS_NOT_A_DOUBLE = "Invalid input: '%s' not a Double\n";
  private static final String INVALID_INPUT_IS_NOT_AN_INTEGER = "Invalid input: '%s' not an Integer\n";

  public static void main(String[] args) {

    Console console = System.console();

    LengthUnit lengthUnit;
    String lengthUnitInput = console.readLine("Enter the length unit for the scale length:\n" +
      "\"in\" for INCHES, \"mm\" for MILLIMETERS [default: in] ");
    switch (lengthUnitInput.trim()) {
      case "mm" -> {
        lengthUnit = LengthUnit.MILLIMETERS;
        console.printf("Selecting MILLIMETERS\n");
      }
      case "", "in" -> {
        lengthUnit = LengthUnit.INCHES;
        console.printf("Selecting INCHES\n");
      }
      default -> {
        console.printf("No valid input \"%s\". Selecting INCHES\n", lengthUnitInput);
        lengthUnit = LengthUnit.INCHES;
      }
    }

    String defaultScaleLength;
    if (lengthUnit == LengthUnit.INCHES) {
      defaultScaleLength = "25.0";
    } else {
      defaultScaleLength = "635.0";
    }

    String scaleLengthInput = console.readLine(
      "Enter scale length (" + lengthUnit + "): [default: " + defaultScaleLength + "] ");
    if (scaleLengthInput.isBlank()) {
      scaleLengthInput = defaultScaleLength;
    }

    double scaleLengthDouble;

    try {
      scaleLengthDouble = Double.parseDouble(scaleLengthInput);
    } catch (NumberFormatException numberFormatException) {
      console.printf(INVALID_INPUT_IS_NOT_A_DOUBLE, scaleLengthInput);
      return;
    }

    console.printf("Selecting %.2f %s\n", scaleLengthDouble, lengthUnit);

    TemperamentType temperamentType = TemperamentType.EQUAL_TEMPERAMENT;
    String temperamentInput = console.readLine("Enter the temperament type:\n" +
      "\"e\" for EQUAL_TEMPERAMENT, \"2\" for TWO_DIMENSIONAL [default: e] ");
    switch (temperamentInput) {
      case "2" -> {
        temperamentType = TemperamentType.TWO_DIMENSIONAL;
        console.printf("Selecting TWO_DIMENSIONAL\n");
      }
      case "", "e" -> console.printf("Selecting EQUAL_TEMPERAMENT\n");
      default -> console.printf("No valid input \"%s\". Selecting EQUAL_TEMPERAMENT\n", temperamentInput);

    }

    String referenceIntervalStr = console.readLine("Enter reference interval frequency ratio: [default: 2.0] ");
    if (referenceIntervalStr.isBlank()) {
      referenceIntervalStr = "2.0";
    }

    double referenceInterval;

    try {
      referenceInterval = Double.parseDouble(referenceIntervalStr);
    } catch (NumberFormatException nfe) {
      console.printf(INVALID_INPUT_IS_NOT_A_DOUBLE, referenceIntervalStr);
      return;
    }

    ScaleLength scaleLength = new ScaleLength(scaleLengthDouble, lengthUnit);
    Temperament temperament = getTemperament(temperamentType, referenceInterval, console);

    if (temperament == null) {
      return;
    }

    Calculator calculator = new Calculator(scaleLength, temperament);
    Result result = calculator.calculate();

    console.printf("\nNow printing your fret slot distances..\n\n");

    for (ResultEntry resultEntry : result.getResultEntries()) {
      console.printf("%.3f\t\t\t%.3f\t\t\t%s\n", resultEntry.fretPosMm, resultEntry.fretPosInch, resultEntry.sourceInfo.infoList());
    }
  }

  private static Temperament getTemperament(TemperamentType temperamentType, double referenceInterval, Console console) {
    return switch (temperamentType) {
      case EQUAL_TEMPERAMENT -> prepareTETCalculation(referenceInterval, console);
      case TWO_DIMENSIONAL -> prepare2DCalculation(referenceInterval, console);
    };
  }

  private static Temperament prepare2DCalculation(double referenceInterval, Console console) {

    String semitoneRatioStr = console.readLine("Enter the semitone ratio: [default: 0.60628]\n");
    if (semitoneRatioStr.isBlank()) {
      semitoneRatioStr = "0.60628";
    }

    double semitoneRatio;
    try {
      semitoneRatio = Double.parseDouble(semitoneRatioStr);
    } catch (NumberFormatException numberFormatException) {
      console.printf(INVALID_INPUT_IS_NOT_A_DOUBLE , semitoneRatioStr);
      return null;
    }

    return new Temperament2D(referenceInterval, semitoneRatio,
      DefaultTsDistanceCollections.getStandardVersionSingleOptionAboveOctave21());
  }

  private static Temperament prepareTETCalculation(double referenceInterval, Console console) {

    String nStepsStr = console.readLine(
      "Enter number of equal steps within reference interval (frequency ratio = %f): [default: 12] ", referenceInterval);
    if (nStepsStr.isBlank()) {
      nStepsStr = "12";
    }

    int nSteps;
    try {
      nSteps = Integer.parseInt(nStepsStr);
    } catch (NumberFormatException numberFormatException) {
      console.printf(INVALID_INPUT_IS_NOT_AN_INTEGER, nStepsStr);
      return null;
    }

    String nFretsStr = console.readLine("Enter the total number of frets: [default: 22]");
    if (nFretsStr.isBlank()) {
      nFretsStr = "22";
    }

    int nFrets;
    try {
      nFrets = Integer.parseInt(nFretsStr);
    } catch (NumberFormatException numberFormatException) {
      console.printf(INVALID_INPUT_IS_NOT_AN_INTEGER, nStepsStr);
      return null;
    }

    return new TemperamentTET(referenceInterval, nSteps, nFrets);
  }
}
