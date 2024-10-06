package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.tdd.MoodAnalyser;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SomeServiceTest {
    // 3.1. Метод возвращает Fizz для чисел кратных 3, Buzz для кратных 5, и FizzBuzz для кратных 3 и 5 одновременно
    private SomeService someService;

    @BeforeEach
    void setUp() {someService = new SomeService();}
    // метод setUp(), где инициализируется основной класс и перед каждым тестом он создается заново

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 33})
    void multipleThreeNotFiveReturnsFizz(int n) {
        assertEquals("Fizz", someService.fizzBuzz(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 55})
    void multipleFiveNotThreeReturnsBuzz(int n) {
        assertEquals("Buzz", someService.fizzBuzz(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 225, 3375})
    void multipleThreeAndFiveReturnsFizzBuzz(int n) {
        assertEquals("FizzBuzz", someService.fizzBuzz(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 41, 43})
    void notMultipleOfThreeOfFiveReturnsNumber(int n) {
        assertEquals(Integer.toString(n), someService.fizzBuzz(n));
    }

    // 3.2. Метод возвращает true для массивов, которые начинаются или заканчиваются 6, и false - если 6 нет ни в начале ни в конце массива

    @Test
    void first6arrayShouldReturnTrue(){
        assertTrue(someService.firstLast6(new int[]{6, 3, 5, 3}), "Array starts with 6, should return true");
    }

    @Test
    void last6arrayShouldReturnTrue(){
        assertTrue(someService.firstLast6(new int[]{2, 345, 6}), "Array ends with 6, should return true");
    }

    @Test
    void noLast6arrayShouldReturnFalse(){
        assertFalse(someService.firstLast6(new int[]{2, 3, 5, 3}), "Array doesn't contain 6 at the start or end, should return false");
    }

    @Test
    void calculatingCorrectDiscount(){
        // Тесты на корректность результата
        assertThat(someService.calculatingDiscount(1000, 25)).isEqualTo(750);
        assertThat(someService.calculatingDiscount(1000, 100)).isEqualTo(0);
        assertThat(someService.calculatingDiscount(1000, 0)).isEqualTo(1000);
    }

    @Test
    void negativePurchaseAmountReturnException(){
        //Отрицательные числа. Сумма покупки.
        assertThatThrownBy(()-> someService.calculatingDiscount(-1000, 50))
                .isInstanceOf(ArithmeticException.class).hasMessage("Сумма покупки не может быть отрицательной");
    }

    @Test
    void negativePurchaseDiscountReturnException(){
        //Отрицательные числа. Процент скидки.
        assertThatThrownBy(()-> someService.calculatingDiscount(1000, -10))
                .isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть от 0 до 100%");
    }

    @Test
    void discountMore100ReturnException(){
        //Процент скидки > 100
        assertThatThrownBy(()-> someService.calculatingDiscount(1000, 101))
                .isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть от 0 до 100%");
    }

    @Test
    void luckySumReturnSumWithout13(){
        assertThat(someService.luckySum(2,3,13)).isEqualTo(5);
        assertThat(someService.luckySum(2,13,9)).isEqualTo(11);
        assertThat(someService.luckySum(13,9,9)).isEqualTo(18);
        assertThat(someService.luckySum(9,9,9)).isEqualTo(27);
        assertThat(someService.luckySum(13,13,13)).isEqualTo(0);
    }

}



