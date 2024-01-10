package cs01.model;

public class BaseJobProcessor {

    private final Convertor convertor;
    private final Calculator calculator;
    private final BaseValidator baseValidator;

    private static final String HELP_MESSAGE = "[도움말]" + System.lineSeparator()
        + " - dec2bin <decimal>: 10진수 정수를 2진수로 변환" + System.lineSeparator()
        + " - bin2dec <binary>: 2진수를 10진수로 변환" + System.lineSeparator()
        + " - sumBinary <binary> <binary>: 두 이진수를 더함" + System.lineSeparator()
        + " - exit: 프로그램 종료" + System.lineSeparator()
        + " * 이진수는 prefix로 0b를 붙여 사용합니다 (e.g. 0b11100)";

    public BaseJobProcessor(Convertor convertor, Calculator calculator,
        BaseValidator baseValidator) {
        this.convertor = convertor;
        this.calculator = calculator;
        this.baseValidator = baseValidator;
    }

    public String callBin2dec(String strBinary) {
        int decimal = convertor.bin2dec(convertor.string2bin(strBinary));
        return String.valueOf(decimal);
    }

    public String callDec2bin(String strDecimal) {
        boolean[] binary = convertor.dec2bin(convertor.string2int(strDecimal));
        return convertor.bin2String(binary);
    }

    public String callSumBinary(String strBinary1, String strBinary2) {
        boolean[] sumResult = calculator.sumBinary(
            convertor.string2bin(strBinary1),
            convertor.string2bin(strBinary2));
        return convertor.bin2String(sumResult);
    }

    public void callValidateStringBinary(String binaryStr) {
        baseValidator.validateStringBinary(binaryStr);
    }

    public String callHelp() {
        return HELP_MESSAGE;
    }
}
