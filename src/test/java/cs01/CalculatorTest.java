package cs01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import cs01.model.Calculator;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("두 이진수를 더할 수 있다. (덧셈 결과의 자리수가 그대로인 경우)")
    void sumBinary_success() {
        var binary1 = new boolean[]{true, false, true};
        var binary2 = new boolean[]{true, false};
        var expectedResult = new boolean[]{false, true, true};

        var actualResult = calculator.sumBinary(binary1, binary2);
        System.out.println(Arrays.toString(actualResult));

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("두 이진수를 더할 수 있다. (덧셈 결과의 자리수가 변경되는 경우)")
    void sumBinary_success_carry() {
        var binary1 = new boolean[]{true, true, true};
        var binary2 = new boolean[]{true, false, true};
        var expectedResult = new boolean[]{false, false, true, true};

        var actualResult = calculator.sumBinary(binary1, binary2);

        assertArrayEquals(expectedResult, actualResult);
    }
}