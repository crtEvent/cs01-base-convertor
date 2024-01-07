package cs01;

import java.util.function.Function;

public class CommandProcessor {

    private final Convertor convertor;
    private final Calculator calculator;

    private static final Function<String, String> COMMAND_ERROR_MESSAGE = (String command)
        -> String.format("'%s'는 잘못된 명령어 입니다.", command);

    private static final String HELP_MESSAGE = "[도움말]" + System.lineSeparator()
        + " - dec2bin <decimal>: 10진수 정수를 2진수로 변환" + System.lineSeparator()
        + " - bin2dec <binary>: 2진수를 10진수로 변환" + System.lineSeparator()
        + " - sumBinary <binary> <binary>: 두 이진수를 더함" + System.lineSeparator()
        + " - exit: 프로그램 종료" + System.lineSeparator()
        + " * 이진수는 prefix로 0b를 붙여 사용합니다 (e.g. 0b11100)";

    public CommandProcessor(Convertor convertor, Calculator calculator) {
        this.convertor = convertor;
        this.calculator = calculator;
    }

    public String generateResult(String command) {
        var commandComponents = command.split(" ");

        if (commandComponents.length < 1) {
            throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE.apply(command));
        }

        switch (commandComponents[0]) {
            case Commands.DEC_2_BIN:
                if (commandComponents.length != 2) {
                    throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE.apply(command));
                }
                boolean[] binary = convertor.dec2bin(convertor.string2int(commandComponents[1]));
                return convertor.bin2String(binary);
            case Commands.BIN_2_DEC:
                if (commandComponents.length != 2) {
                    throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE.apply(command));
                }
                int decimal = convertor.bin2dec(convertor.string2bin(commandComponents[1]));
                return String.valueOf(decimal);
            case Commands.SUM_BINARY:
                if (commandComponents.length != 3) {
                    throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE.apply(command));
                }
                boolean[] sumResult = calculator.sumBinary(
                    convertor.string2bin(commandComponents[1]),
                    convertor.string2bin(commandComponents[2]));
                return convertor.bin2String(sumResult);
            case Commands.HELP:
                return HELP_MESSAGE;
            case Commands.EXIT:
                return Commands.EXIT;
            default:
                throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE.apply(command));
        }
    }
}
