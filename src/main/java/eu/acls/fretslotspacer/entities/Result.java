package eu.acls.fretslotspacer.entities;

import java.util.ArrayList;
import java.util.List;

public class Result {

  private final List<Double> fretPositions = new ArrayList<>();

  public List<Double> getFretPositions() {
    return fretPositions;
  }
}
