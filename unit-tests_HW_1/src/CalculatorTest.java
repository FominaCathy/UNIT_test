import seminars.first.model.Calculator;
import org.junit.jupiter.api.*;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {

        assertThat(Calculator.calculatingDiscount(100, 5)).isEqualTo(95);

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(0, 5))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-100, 5))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, -1))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, 0))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, 100))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, 101))
                .isInstanceOf(ArithmeticException.class);

    }
}