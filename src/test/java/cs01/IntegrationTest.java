package cs01;

import cs01.model.Calculator;
import cs01.model.Convertor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegrationTest {

    Convertor convertor = new Convertor();
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("통합 테스트: 두 정수를 이진수로 변환한 후 더하는 과정")
    void integrationSumTest() {
        var decimal1 = 12;
        var decimal2 = 24;
        var expectedSumResult = decimal1 + decimal2;

        var binary1 = convertor.dec2bin(decimal1);
        var binary2 = convertor.dec2bin(decimal2);

        var sumResultBinary = calculator.sumBinary(binary1, binary2);
        var sumResultDecimal = convertor.bin2dec(sumResultBinary);

        Assertions.assertEquals(expectedSumResult, sumResultDecimal);
    }

}
