package eu.acls.fretslotspacer;

import eu.acls.fretslotspacer.entities.*;
import eu.acls.fretslotspacer.util.Util;

import java.util.List;

public class Calculator {

  private final ScaleLength scaleLength;
  private final Temperament temperament;

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
      double currentFretPosMm = scaleLengthMm - scaleLengthMm / Math.pow(referenceInterval, (tsDistance.getTones() + tsDistance.getSemitones() * semitoneRatio) / (5 + 2 * semitoneRatio));

      double currentFretPosMmTrunc3 = Util.truncateDecimal(currentFretPosMm, 3);
      double currentFretPosInchTrunc3 = Util.truncateDecimal(Util.millimetersToInches(currentFretPosMm), 3);

      List<Integer> infoList = List.of(
        tsDistance.getTones(),
        tsDistance.getSemitones()
      );

      ResultSourceInfo sourceInfo = new ResultSourceInfo(infoList, TemperamentType.TWO_DIMENSIONAL);
      ResultEntry entry = new ResultEntry(currentFretPosMmTrunc3, currentFretPosInchTrunc3, sourceInfo);
      result.getResultEntries().add(entry);
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

      double currentFretPosMm = scaleLengthMm - scaleLengthMm / Math.pow(referenceInterval, (i + 1.0) / numberOfSteps);

      double currentFretPosMmTrunc8 = Util.truncateDecimal(currentFretPosMm, 3);
      double currentFretPosInchTrunc3 = Util.truncateDecimal(Util.millimetersToInches(currentFretPosMm), 3);

      List<Integer> infoList = List.of(
        i + 1 // fret number
      );
      ResultSourceInfo sourceInfo = new ResultSourceInfo(infoList, TemperamentType.TWO_DIMENSIONAL);
      ResultEntry entry = new ResultEntry(currentFretPosMmTrunc8, currentFretPosInchTrunc3, sourceInfo);
      result.getResultEntries().add(entry);
    }
    return result;
  }
}
