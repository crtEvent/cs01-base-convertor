package cs01;

import java.util.Objects;

public class ConsoleApplication {

    public static void run() {
        var view = new ConsoleView();
        var convertor = new Convertor();
        var calculator = new Calculator();
        var commandProcessor = new CommandProcessor(convertor, calculator);

        while (true) {
            try {
                String command = view.inputCommand();
                String result = commandProcessor.generateResult(command);
                if (Objects.equals(Commands.EXIT, result)) break;
                view.printResult(result);
            } catch (Exception e) {
                view.printErrorMessage(e);
            }
        }
    }

    public static void main(String[] args) {
        run();
    }
}
