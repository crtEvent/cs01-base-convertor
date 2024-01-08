package cs01.model;

public class BaseValidator {

    public void validateStringBinary(String binaryStr) {
        if (!binaryStr.startsWith("0b")) {
            throw new IllegalArgumentException(binaryStr + "는 이진수가 아닙니다.");
        }

        for (var i = 2; i < binaryStr.length(); i++) {
            var charAt = binaryStr.charAt(i);
            if (charAt != '1' && charAt != '0') {
                throw new IllegalArgumentException(binaryStr + "는 이진수가 아닙니다.");
            }
        }
    }

}
