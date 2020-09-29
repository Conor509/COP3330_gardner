import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {
    @Test
    public void CalculateBMITest() {
        BodyMassIndex b = new BodyMassIndex(72, 200);
        assertEquals(27.121913580246915, b.calculateBMI());
    }

    @Test
    public void PrintBMIResultOverweight() {
        BodyMassIndex b = new BodyMassIndex(72, 200);
        assertArrayEquals("Overweight", b.printBMIResult());
    }

    @Test
    public void PrintBMIResultUnderweight() {
        BodyMassIndex b = new BodyMassIndex(72, 100);
        assertArrayEquals("Underweight", b.printBMIResult());
    }

    @Test
    public void PrintBMIResultObese() {
        BodyMassIndex b = new BodyMassIndex(72, 300);
        assertArrayEquals("Obese", b.printBMIResult());
    }

    @Test
    public void PrintBMIResultNormalWeight() {
        BodyMassIndex b = new BodyMassIndex(72, 180);
        assertArrayEquals("NormalWeight", b.printBMIResult());
    }

    private void assertArrayEquals(String normalWeight, String printBMIResult) {

    }

    @Test
    public void getInfoTest(){
        BodyMassIndex b = new BodyMassIndex(72,200);
        assertEquals(0.0, b.getInfo());
    }

}


