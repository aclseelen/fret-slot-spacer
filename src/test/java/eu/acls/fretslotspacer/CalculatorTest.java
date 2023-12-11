package eu.acls.fretslotspacer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    List<Double> fretPositions = result.getFretPositions();

    assertEquals(21, fretPositions.size());
    assertEquals(35.63981145, fretPositions.get(0));
    assertEquals(69.27931398, fretPositions.get(1));
    assertEquals(101.03077631, fretPositions.get(2));
    assertEquals(317.5, fretPositions.get(11));
  }

  @Test
  void calculate_25_5_12Tet() {
    ScaleLength scaleLength = new ScaleLength(25.5, LengthUnit.INCHES);
    TemperamentTET temperament = new TemperamentTET(2.0, 12, 22);
    Calculator calculator = new Calculator(scaleLength, temperament);

    Result result = calculator.calculate();

    List<Double> fretPositions = result.getFretPositions();

    assertEquals(22, fretPositions.size());
    assertEquals(36.35260768, fretPositions.get(0));
    assertEquals(70.66490026, fretPositions.get(1));
    assertEquals(103.05139184, fretPositions.get(2));
    assertEquals(323.85, fretPositions.get(11));
  }

  @Test
  void calculate_25_Meantone() {
    ScaleLength scaleLength = new ScaleLength(25.0, LengthUnit.INCHES);

    List<TsDistance> tsFretsDefined = defineFrets();

    Temperament2D temperament = new Temperament2D(2.0, 0.60628, tsFretsDefined);
    Calculator calculator = new Calculator(scaleLength, temperament);

    Result result = calculator.calculate();

    List<Double> fretPositions = result.getFretPositions();

    assertEquals(6, fretPositions.size());

    assertEquals(27.29053947, fretPositions.get(0));
    assertEquals(41.53325424, fretPositions.get(1));

    assertEquals(67.03880959, fretPositions.get(2));

    assertEquals(91.44820689, fretPositions.get(3));
    assertEquals(104.18727655, fretPositions.get(4));

    assertEquals(317.5, fretPositions.get(5));
  }

  private List<TsDistance> defineFrets() {

    List<TsDistance> tsFretsDefined = new ArrayList<>();

    tsFretsDefined.add(new TsDistance(1, -1));
    tsFretsDefined.add(new TsDistance(0, 1));

    tsFretsDefined.add(new TsDistance(1, 0));

    tsFretsDefined.add(new TsDistance(2, -1));
    tsFretsDefined.add(new TsDistance(1, 1));

    //---//

    tsFretsDefined.add(new TsDistance(5, 2));

     return tsFretsDefined;
  }

}
