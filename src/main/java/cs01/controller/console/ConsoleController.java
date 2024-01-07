package cs01.controller.console;

import cs01.model.BaseJobProcessor;
import cs01.view.console.ConsoleView;
import java.util.Objects;
import java.util.function.Function;

public class ConsoleController {

    private final BaseJobProcessor baseJobProcessor;
    private final ConsoleView view;

    private static final Function<String, String> COMMAND_ERROR_MESSAGE = (String command)
        -> String.format("'%s'는 잘못된 명령어 입니다.", command);

    public ConsoleController() {
        this.baseJobProcessor = new BaseJobProcessor();
        this.view = new ConsoleView();
    }

    public void execute() {
        while (true) {
            try {
                String command = view.inputCommand();
                String result = generateResult(command);
                if (Objects.equals(Commands.EXIT, result)) break;
                view.printResult(result);
            } catch (Exception e) {
                view.printErrorMessage(e);
            }
        }
    }

    private String generateResult(String command) {
        var commandComponents = command.split(" ");

        if (commandComponents.length < 1) {
            throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE.apply(command));
        }

        return switch (commandComponents[0]) {
            case Commands.DEC_2_BIN -> {
                if (commandComponents.length != 2) {
                    throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE.apply(command));
                }
                yield baseJobProcessor.callDec2bin(commandComponents[1]);
            }
            case Commands.BIN_2_DEC -> {
                if (commandComponents.length != 2) {
                    throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE.apply(command));
                }
                yield baseJobProcessor.callBin2dec(commandComponents[1]);
            }
            case Commands.SUM_BINARY -> {
                if (commandComponents.length != 3) {
                    throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE.apply(command));
                }
                yield baseJobProcessor.callSumBinary(commandComponents[1], commandComponents[2]);
            }
            case Commands.HELP -> baseJobProcessor.callHelp();
            case Commands.EXIT -> Commands.EXIT;
            default -> throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE.apply(command));
        };
    }
}
