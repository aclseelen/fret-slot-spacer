package eu.acls.fretslotspacer.entities;

public record TsDistance(int tones, int semitones) {

  public int getTones() {
    return tones;
  }

  public int getSemitones() {
    return semitones;
  }
}
