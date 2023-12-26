package eu.acls.fretslotspacer;

import eu.acls.fretslotspacer.entities.*;
import eu.acls.fretslotspacer.util.DefaultTsDistanceCollections;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void calculate_25_12Tet() {
    ScaleLength scaleLength = new ScaleLength(25.0, LengthUnit.INCHES);
    TemperamentTET temperament = new TemperamentTET(2.0, 12, 21);
    Calculator calculator = new Calculator(scaleLength, temperament);

    Result result = calculator.calculate();

    List<ResultEntry> resultEntries = result.getResultEntries();

    assertEquals(21, resultEntries.size());
    assertEquals(35.64, resultEntries.get(0).getFretPosMm());
    assertEquals(69.279, resultEntries.get(1).getFretPosMm());
    assertEquals(101.031, resultEntries.get(2).getFretPosMm());
    assertEquals(317.5, resultEntries.get(11).getFretPosMm());
  }

  @Test
  void calculate_25_5_12Tet() {
    ScaleLength scaleLength = new ScaleLength(25.5, LengthUnit.INCHES);
    TemperamentTET temperament = new TemperamentTET(2.0, 12, 22);
    Calculator calculator = new Calculator(scaleLength, temperament);

    Result result = calculator.calculate();

    List<ResultEntry> resultEntries = result.getResultEntries();

    assertEquals(22, resultEntries.size());
    assertEquals(36.353, resultEntries.get(0).getFretPosMm());
    assertEquals(70.665, resultEntries.get(1).getFretPosMm());
    assertEquals(103.051, resultEntries.get(2).getFretPosMm());
    assertEquals(323.85, resultEntries.get(11).getFretPosMm());
  }

  @Test
  void calculate_25_Meantone() {
    ScaleLength scaleLength = new ScaleLength(25.0, LengthUnit.INCHES);

    List<TsDistance> tsFretsDefined = DefaultTsDistanceCollections.getStandardVersionSingleOptionAboveOctave21();

    Temperament2D temperament = new Temperament2D(2.0, 0.60628, tsFretsDefined);
    Calculator calculator = new Calculator(scaleLength, temperament);

    Result result = calculator.calculate();

    List<ResultEntry> resultEntries = result.getResultEntries();

    // 21 frets corresponding to 12-TET of which 7 are doubled:
    assertEquals(28, resultEntries.size());

    assertEquals(27.291, resultEntries.get(0).getFretPosMm());
    assertEquals(41.533, resultEntries.get(1).getFretPosMm());

    assertEquals(67.039, resultEntries.get(2).getFretPosMm());

    assertEquals(91.448, resultEntries.get(3).getFretPosMm());
    assertEquals(104.187, resultEntries.get(4).getFretPosMm());

    assertEquals(317.5, resultEntries.get(18).getFretPosMm());
  }
}
