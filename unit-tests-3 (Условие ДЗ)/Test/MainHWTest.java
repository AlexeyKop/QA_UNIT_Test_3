import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars_DZ.third.hw.MainHW;

import static org.junit.jupiter.api.Assertions.*;

public class MainHWTest {

    private MainHW mainHW;

    @BeforeEach
    public void setUp() {
        mainHW = new MainHW();
    }


    @Test
    public void testEvenNumber() {
        assertTrue(mainHW.evenOddNumber(4), "Четное число должно вернуть true");
    }


    @Test
    public void testOddNumber() {
        assertFalse(mainHW.evenOddNumber(5), "Нечетное число должно вернуть false");
    }

    @Test
    public void testZeroNumber() {
        assertTrue(mainHW.evenOddNumber(0), "0 считается четным числом");
    }


    @Test
    public void testNegativeEvenNumber() {
        assertTrue(mainHW.evenOddNumber(-6), "Отрицательное четное число должно вернуть true");
    }


    @Test
    public void testNegativeOddNumber() {
        assertFalse(mainHW.evenOddNumber(-7), "Отрицательное нечетное число должно вернуть false");
    }

    @Test
    void testNumberInInterval() {

        assertTrue(mainHW.numberInInterval(50));

        assertFalse(mainHW.numberInInterval(20));

        assertFalse(mainHW.numberInInterval(101));

        assertFalse(mainHW.numberInInterval(25));
        assertFalse(mainHW.numberInInterval(100));
    }
}
