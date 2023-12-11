package eu.acls.fretslotspacer.entities;

import java.util.ArrayList;
import java.util.List;

public class Result {

  private final List<ResultEntry> resultEntries = new ArrayList<>();

  public List<ResultEntry> getResultEntries() {
    return resultEntries;
  }
}
