package eu.acls.fretslotspacer.entities;

public class TemperamentTET extends Temperament {

  private final int numberOfStepsWithinReferenceInterval;
  private final int totalNumberOfFrets;

  public TemperamentTET(double referenceIntervalFrequencyRelation, int numberOfStepsWithinReferenceInterval, int totalNumberOfFrets) {
    super(TemperamentType.EQUAL_TEMPERAMENT, referenceIntervalFrequencyRelation);
    this.numberOfStepsWithinReferenceInterval = numberOfStepsWithinReferenceInterval;
    this.totalNumberOfFrets = totalNumberOfFrets;
  }

  public int getNumberOfStepsWithinReferenceInterval() {
    return numberOfStepsWithinReferenceInterval;
  }

  public int getTotalNumberOfFrets() {
    return totalNumberOfFrets;
  }
}
