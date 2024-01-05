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
            () -> assertThrows(IllegalArgumentException.class,
                () -> convertor.dec2bin(decimal_less)),
            () -> assertThrows(IllegalArgumentException.class,
                () -> convertor.dec2bin(decimal_more))
        );
    }

    @Test
    @DisplayName("이진수를 십진수 정수로 변환할 수 있다")
    void bin2dec_success() {
        var binary = new boolean[]{true, true, false, false, false, true};
        int expectedDecimal = 35;

        int actualDecimal = convertor.bin2dec(binary);

        assertEquals(expectedDecimal, actualDecimal);
    }

    @Test
    @DisplayName("문자열 형태의 이진수를 boolean 배열로 변환할 수 있다.")
    void string2bin_success() {
        var stringBinary = "0b1100";
        var expectedBinary = new boolean[]{false, false, true, true};

        var actualBinary = convertor.string2bin(stringBinary);

        assertArrayEquals(expectedBinary, actualBinary);
    }

    @Test
    @DisplayName("잘못된 포맷의 문자열 이진수는 boolean 배열로 변환할 수 없다.")
    void string2bin_fail() {
        var stringBinary1 = "1100";
        var stringBinary2 = "0b11abc00";

        assertAll(
            () -> assertThrows(IllegalArgumentException.class,
                () -> convertor.string2bin(stringBinary1)),
            () -> assertThrows(IllegalArgumentException.class,
                () -> convertor.string2bin(stringBinary2))
        );
    }
}