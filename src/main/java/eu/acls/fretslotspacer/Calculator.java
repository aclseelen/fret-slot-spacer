package eu.acls.fretslotspacer;

import eu.acls.fretslotspacer.entities.*;
import eu.acls.fretslotspacer.util.Util;

public class Calculator {

  private ScaleLength scaleLength;
  private Temperament temperament;

  public Calculator(ScaleLength scaleLength, Temperament temperament) {
    this.scaleLength = scaleLength;
    this.temperament = temperament;
  }

  public Result calculate() {

    Result result = null;

    if (temperament.getTemperamentType() == TemperamentType.EQUAL_TEMPERAMENT) {
      result = calculateTET();
    } else if (temperament.getTemperamentType() == TemperamentType.TWO_DIMENSIONAL) {
      result = calculate2D();
    }

    return result;
  }

  private Result calculate2D() {

    Result result = new Result();
    Temperament2D temperament2D = (Temperament2D) temperament;

    double scaleLengthMm = scaleLength.toMillimeters();
    double semitoneRatio = temperament2D.getSemitoneRatio();
    double referenceInterval = temperament.getReferenceIntervalFrequencyRelation();

    for (TsDistance tsDistance : temperament2D.getTsFretsDefined()) {
      double currentFretPos = Util.truncateDecimal(
        scaleLengthMm - scaleLengthMm / Math.pow(referenceInterval, (tsDistance.getTones() + tsDistance.getSemitones() * semitoneRatio) / (5 + 2 * semitoneRatio)), 8
      );
      result.getFretPositions().add(currentFretPos);
    }

    return result;
  }

  private Result calculateTET() {

    Result result = new Result();
    TemperamentTET temperamentTET = (TemperamentTET) temperament;

    int numberOfSteps = temperamentTET.getNumberOfStepsWithinReferenceInterval();
    double referenceInterval = temperament.getReferenceIntervalFrequencyRelation();

    double scaleLengthMm = scaleLength.toMillimeters();

    int nFrets = temperamentTET.getTotalNumberOfFrets();
    for (int i = 0; i < nFrets; i++) {
      double currentFretPos = Util.truncateDecimal(
        scaleLengthMm - scaleLengthMm / Math.pow(referenceInterval, (i + 1.0) / numberOfSteps), 8
      );
      result.getFretPositions().add(currentFretPos);
    }
    return result;
  }
}
