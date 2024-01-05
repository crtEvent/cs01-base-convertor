package cs01;

public class Convertor {

    public boolean[] dec2bin(int decimal) {
        if (decimal < 0 || decimal > 255) {
            throw new IllegalArgumentException("0~255까지의 정수만 입력할 수 있습니다.");
        }

        var tempBinary = new boolean[8];
        int binarySize = 0;
        int quotient = decimal; // 몫

        for (int i = 0; quotient != 0; i++) {
            tempBinary[i] = (quotient % 2) == 1;
            quotient = quotient / 2;
            binarySize = i + 1;
        }
        var binary = new boolean[binarySize];
        System.arraycopy(tempBinary, 0, binary, 0, binarySize);

        return binary;
    }

    public int bin2dec(boolean[] binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length; i++) {
            decimal += (binary[i] ? 1 : 0) * (int) Math.pow(2, i);
        }

        return decimal;
    }

    public boolean[] string2bin(String binaryStr) {
        if (!binaryStr.startsWith("0b")) {
            throw new IllegalArgumentException(binaryStr + "는 이진수가 아닙니다.");
        }

        var binary = new boolean[binaryStr.length() - 2];
        for (var i = 0; i < binary.length; i++) {
            var charAt = binaryStr.charAt(binaryStr.length() - 1 - i);
            if (charAt == '1') {
                binary[i] = true;
            } else if (charAt == '0') {
                binary[i] = false;
            } else {
                throw new IllegalArgumentException(binaryStr + "는 이진수가 아닙니다.");
            }
        }

        return binary;
    }

}
