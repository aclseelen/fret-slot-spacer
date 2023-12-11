package eu.acls.fretslotspacer.util;

import eu.acls.fretslotspacer.entities.TsDistance;

import java.util.ArrayList;
import java.util.List;

public class DefaultTsDistanceCollections {

  private DefaultTsDistanceCollections() {
  }

  public static List<TsDistance> getStandardVersionSingleOptionAboveOctave21() {

    List<TsDistance> tsDistances = new ArrayList<>();

    // omitted Ts(-1, 2)                                      fb  bbb ebb abb cb  fb    01/31

    // 1 --> (1+2)    (left: fret number corresp. to 12-TET, right: actual fret number(s))
    tsDistances.add(new TsDistance(1, -1)); // e#  a#  d#  g#  b#  e#    02/31 (5-3)
    tsDistances.add(new TsDistance(0, 1));  // f   bb  eb  ab  c   f     03/31 (0+3)

    // omitted Ts(2, -2)                                      ex  ax  dx  gx  bx  ex    04/31 (10-6)
    // omitted Ts(-1, 3)                                      gbb cbb fbb bbbb dbb gbb  04/31 (-5+9)

    // 2 --> (3)
    tsDistances.add(new TsDistance(1, 0));  // f#  b   e   a   c#  f#    05/31 (5+0)

    // omitted Ts(0, 2)                                       gb  cb  fb  bbb db  gb    06/31 (0+6)

    // 3 --> (4+5)
    tsDistances.add(new TsDistance(2, -1)); // fx  b#  e#  a#  cx  fx    07/31 (10-3)
    tsDistances.add(new TsDistance(1, 1));  // g   c   f   bb  d   g     08/31 (5+3)

    // omitted Ts(3, -2)                                      fxx bx  ex  ax  cxx fxx    09/31 (15-6)
    // omitted Ts(0, 3)                                       abb dbb gbb cbb ebb abb    09/31 (0+9)

    // 4 --> (6+7)
    tsDistances.add(new TsDistance(2, 0));  // g#  c#  f#  b   d#  g#    10/31 (10+0)
    tsDistances.add(new TsDistance(1, 2));  // ab  db  gb  cb  eb  ab    11/31 (5+6)

    // omitted Ts(3, -1)                                      gx  cx  fx  b#  dx  gx    12/31 (15-3)

    // 5 --> (8)
    tsDistances.add(new TsDistance(2, 1));  // a   d   g   c   e   a      13/31 (10+3)

    // omitted Ts(1, 3)                                       bbb ebb abb dbb fb  bbb    14/31 (5+9)
    // omitted Ts(4, -2)                                      gxx cxx fxx bx  dxx gxx    14/31 (20-6)

    // 6 --> (9+10)
    tsDistances.add(new TsDistance(3, 0));  // a#  d#  g#  c#  e#  a#    15/31 (15+0)
    tsDistances.add(new TsDistance(2, 2));  // bb  eb  ab  db  f   bb    16/31 (10+6)

    // omitted Ts(1, 4)                                       cbb fbb bbbb ebbb gbb cbb 17/31 (5+12)
    // omitted Ts(4, -1)                                      ax  dx  gx  cx  ex  ax    17/31 (20-3)

    // 7 --> (11)
    tsDistances.add(new TsDistance(3, 1));  // b   e   a   d   f#  b     18/31 (15+3)

    // omitted Ts(2, 3)                                       cb  fb  bbb ebb gb  cb    19/31 (10+9)

    // 8 --> (12+13)
    tsDistances.add(new TsDistance(4, 0));  // b#  e#  a#  d#  fx  b#    20/31 (20+0)
    tsDistances.add(new TsDistance(3, 2));  // c   f   bb  eb  g   c     21/31 (15+6)

    // omitted Ts(5, -1)                                      bx  ex  ax  dx  fxx bx    22/31 (25-3)
    // omitted Ts(2, 4)                                       dbb gbb cbb fbb abb dbb   22/31 (10+12)

    // 9 --> (14+15)
    tsDistances.add(new TsDistance(4, 1));  // c#  f#  b   e   g#  c#    23/31 (20+3)
    tsDistances.add(new TsDistance(3, 3));  // db  gb  cb  fb  ab  db    24/31 (15+9)

    // omitted Ts(5, 0)                                       cx  fx  b#  e#  gx  cx    25/31 (25+0)

    // 10 --> (16)
    tsDistances.add(new TsDistance(4, 2));  // d   g   c   f   a   d     26/31 (20+6)

    // omitted Ts(6, -1)                                      cxx fxx bx  ex  gxx cxx   27/31 (25+0)
    // omitted Ts(3, 4)                                       ebb abb dbb gbb bbb ebb   27/31 (15+12)

    // 11 --> (17+18)
    tsDistances.add(new TsDistance(5, 1));  // d#  g#  c#  f#  a#  d#    28/31 (25+3)
    tsDistances.add(new TsDistance(4, 3));  // eb  ab  db  gb  bb  eb    29/31 (20+9)

    // omitted Ts(6, 0)                                       dx  gx  cx  fx  ax  dx    30/31 (30+0)
    // omitted Ts(3, 5)                                      fbb bbbb ebbb abbb cbb fbb 30/31 (15+15)

    // 12 --> (19)
    tsDistances.add(new TsDistance(5, 2));  // e   a   d   g   b   e     31/31 (25+6)

    // From here all omitted frets can be derived from te previous 31 (octave repetition)

    // 13 --> (20)
    tsDistances.add(new TsDistance(5, 3));  // f   bb  eb  ab  c   f     34/31 (25+9)

    // 14 --> (21)
    tsDistances.add(new TsDistance(6, 2));  // f#  b   e   a   c#  f#    36/31 (30+6)

    // 15 --> (22)
    tsDistances.add(new TsDistance(6, 3));  // g   c   f   bb  d   g     39/31 (30+9)

    // 16 --> (23)
    tsDistances.add(new TsDistance(7, 2));  // g#  c#  f#  b   d#  g#    41/31 (35+6)

    // 17 --> (24)
    tsDistances.add(new TsDistance(7, 3));  // a   d   g   c   e   a     44/31 (35+9)

    // 18 --> (25)
    tsDistances.add(new TsDistance(8, 2));  // a#  d#  g#  c#  e#  a#    46/31 (40+6)

    // 19 --> (26)
    tsDistances.add(new TsDistance(8, 3));  // b   e   a   d   f#  b     49/31 (40+9)

    // 20 --> (27)
    tsDistances.add(new TsDistance(8, 4));  // c   f   bb  eb  g   c     52/31 (40+12)

    // 21 --> (28)
    tsDistances.add(new TsDistance(9, 3));  // c#  f#  b   e   g#  c#    54/31 (45+9)

    return tsDistances;
  }

  public static List<TsDistance> getStandardVersionSingleOptionAboveOctave22() {
    List<TsDistance> tsDistances = getStandardVersionSingleOptionAboveOctave21();

    // 22 --> (29)
    tsDistances.add(new TsDistance(9, 4));  // d   g   c   f   a   d     57/31 (45+12)

    return tsDistances;
  }
}
