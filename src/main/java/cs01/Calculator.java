package cs01;

import java.util.Arrays;

public class Calculator {

    public boolean[] sumBinary(boolean[] binary1, boolean[] binary2) {
        var arrayLength = Math.max(binary1.length, binary2.length) + 1;
        var sumResult = new boolean[arrayLength];
        binary1 = Arrays.copyOf(binary1, arrayLength);
        binary2 = Arrays.copyOf(binary2, arrayLength);

        var carry = false;
        for (var i = 0; i < arrayLength; i++) {
            var sum = false;

            var carryCount = 0;
            carryCount += binary1[i] ? 1 : 0;
            carryCount += binary2[i] ? 1 : 0;
            carryCount += carry ? 1 : 0;

            sumResult[i] = binary1[i] ^ binary2[i] ^ carry;
            carry = carryCount >= 2;
        }

        // 이진수 덧셈 결과의 맨 앞자리 수가 false인 경우 맨 앞 자리를 제거한다.
        // 맨 앞자리가 0인 경우 표시할 필요가 없기 때문이다.
        if (!sumResult[sumResult.length - 1]) {
            sumResult = Arrays.copyOf(sumResult, sumResult.length - 1);
        }

        return sumResult;
    }

}
