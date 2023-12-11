package eu.acls.fretslotspacer;

import java.util.List;

public class Temperament2D extends Temperament {

  private final double semitoneRatio;
  private final List<TsDistance> tsFretsDefined;

  public Temperament2D(double referenceIntervalFrequencyRelation, double semitoneRatio, List<TsDistance> tsFretsDefined) {
    super(TemperamentType.TWO_DIMENSIONAL, referenceIntervalFrequencyRelation);
    this.semitoneRatio = semitoneRatio;
    this.tsFretsDefined = tsFretsDefined;
  }

  public double getSemitoneRatio() {
    return semitoneRatio;
  }

  public List<TsDistance> getTsFretsDefined() {
    return tsFretsDefined;
  }
}
