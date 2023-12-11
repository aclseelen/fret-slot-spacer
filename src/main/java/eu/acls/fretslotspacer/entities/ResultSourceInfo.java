package eu.acls.fretslotspacer.entities;

import java.util.List;

public record ResultSourceInfo(List<Integer> infoList,
                               TemperamentType temperamentType) {

  public List<Integer> getInfoList() {
    return infoList;
  }

  public TemperamentType getTemperamentType() {
    return temperamentType;
  }
}
