package eu.acls.fretslotspacer;

public record TsDistance(int tones, int semitones) {

  public int getTones() {
    return tones;
  }

  public int getSemitones() {
    return semitones;
  }
}
