package eu.acls.fretslotspacer.util;

import eu.acls.fretslotspacer.entities.TsDistance;

import java.util.ArrayList;
import java.util.List;

public class DefaultTsDistanceCollections {

  private DefaultTsDistanceCollections() {
  }

  public static List<TsDistance> getStandardVersionSingleOptionAboveOctave21() {

    List<TsDistance> tsDistances = new ArrayList<>();

    // 1 --> (2)
    tsDistances.add(new TsDistance(1, -1)); // e#  a#  d#  g#  b#  e#
    tsDistances.add(new TsDistance(0, 1));  // f   bb  eb  ab  c   f

    // 2 --> (3)
    tsDistances.add(new TsDistance(1, 0));  // f#  b   e   a   c#  f#

    // 3 --> (5)
    tsDistances.add(new TsDistance(2, -1)); // fx  b#  e#  a#  cx  fx
    tsDistances.add(new TsDistance(1, 1));  // g   c   f   bb  d   g

    // 4 --> (7)
    tsDistances.add(new TsDistance(2, 0));  // g#  c#  f#  b   d#  g#
    tsDistances.add(new TsDistance(1, 2));  // ab  db  gb  cb  eb  ab

    // 5 --> (8)
    tsDistances.add(new TsDistance(2, 1));  //    d   g   c   e   a

    // 6 --> (10)
    tsDistances.add(new TsDistance(3, 0));  // a#  d#  g#  c#  e#  a#
    tsDistances.add(new TsDistance(2, 2));  // bb  eb  ab  db  f   bb

    // 7 --> (11)
    tsDistances.add(new TsDistance(3, 1));  // b   e   a   d   f#  b

    // 8 --> (13)
    tsDistances.add(new TsDistance(4, 0));  // b#  e#  a#  d#  fx  b#
    tsDistances.add(new TsDistance(3, 2));  // c   f   bb  eb  g   c

    // 9 --> (15)
    tsDistances.add(new TsDistance(4, 1));  // c#  f#  b   e   g#  c#
    tsDistances.add(new TsDistance(3, 3));  // db  gb  cb  fb  ab  db

    // 10 --> (16)
    tsDistances.add(new TsDistance(4, 2));  // d   g   c   f   a   d

    // 11 --> (18)
    tsDistances.add(new TsDistance(5, 1));  // d#  g#  c#  f#  a#  d#
    tsDistances.add(new TsDistance(4, 3));  // eb  ab  db  gb  bb  eb

    // 12 --> (19)
    tsDistances.add(new TsDistance(5, 2));  // e   a   d   g   b   e

    // 13 --> (20)
    tsDistances.add(new TsDistance(5, 3));  // f   bb  eb  ab  c   f

    // 14 --> (21)
    tsDistances.add(new TsDistance(6, 2));  // f#  b   e   a   c#  f#

    // 15 --> (22)
    tsDistances.add(new TsDistance(6, 3));  // g   c   f   bb  d   g

    // 16 --> (23)
    tsDistances.add(new TsDistance(7, 2));  // g#  c#  f#  b   d#  g#

    // 17 --> (24)
    tsDistances.add(new TsDistance(7, 3));  // a   d   g   c   e   a

    // 18 --> (25)
    tsDistances.add(new TsDistance(8, 2));  // a#  d#  g#  c#  e#  a#

    // 19 --> (26)
    tsDistances.add(new TsDistance(8, 3));  // b   e   a   d   f#  b

    // 20 --> (27)
    tsDistances.add(new TsDistance(8, 4));  // c   f   bb  eb  g   c

    // 21 --> (28)
    tsDistances.add(new TsDistance(9, 3));  // c#  f#  b   e   g#  c#

    return tsDistances;
  }

  public static List<TsDistance> getStandardVersionSingleOptionAboveOctave22() {
    List<TsDistance> tsDistances = getStandardVersionSingleOptionAboveOctave21();

    // 22 --> (29)
    tsDistances.add(new TsDistance(9, 4));  // d   g   c   f   a   d

    return tsDistances;
  }
}
