package cs01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertorTest {

    Convertor convertor = new Convertor();

    @Test
    @DisplayName("10진수 정수를 이진수로 변활할 수 있다.")
    void dec2bin_success() {
        var decimal = 35;
        var expectedBinary = new boolean[]{true, true, false, false, false, true};

        var actualBinary = convertor.dec2bin(decimal);

        assertArrayEquals(expectedBinary, actualBinary);
    }

    @Test
    @DisplayName("0 미만 255 초과인 정수는 이진수로 변환할 수 없다.")
    void dec2bin_fail() {
        var decimal_less = -1;
        var decimal_more = 256;

        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> convertor.dec2bin(decimal_less)),
            () -> assertThrows(IllegalArgumentException.class, () -> convertor.dec2bin(decimal_more))
        );
    }
}