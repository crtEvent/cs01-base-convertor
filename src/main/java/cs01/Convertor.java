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

}
