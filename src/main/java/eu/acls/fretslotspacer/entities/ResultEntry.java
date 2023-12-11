package eu.acls.fretslotspacer.entities;

public class ResultEntry {

  public final double fretPosMm;
  public final double fretPosInch;
  public final ResultSourceInfo sourceInfo;

  public ResultEntry(double fretPosMm, double fretPosInch, ResultSourceInfo sourceInfo) {
    this.fretPosMm = fretPosMm;
    this.fretPosInch = fretPosInch;
    this.sourceInfo = sourceInfo;
  }

  public double getFretPosMm() {
    return fretPosMm;
  }

  public double getFretPosInch() {
    return fretPosInch;
  }

  public ResultSourceInfo getSourceInfo() {
    return sourceInfo;
  }
}
