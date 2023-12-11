package eu.acls.fretslotspacer;

public abstract class Temperament {

  private final TemperamentType temperamentType;
  private final double referenceIntervalFrequencyRelation;

  protected Temperament(TemperamentType temperamentType, double referenceIntervalFrequencyRelation) {
    this.temperamentType = temperamentType;
    this.referenceIntervalFrequencyRelation = referenceIntervalFrequencyRelation;
  }

  public TemperamentType getTemperamentType() {
    return temperamentType;
  }

  public double getReferenceIntervalFrequencyRelation() {
    return referenceIntervalFrequencyRelation;
  }
}
