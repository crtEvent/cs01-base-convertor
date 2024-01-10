package cs01;

import cs01.controller.console.ConsoleController;
import cs01.model.BaseJobProcessor;
import cs01.model.BaseValidator;
import cs01.model.Calculator;
import cs01.model.Convertor;
import cs01.view.console.ConsoleView;

public class ConsoleApplication {

    public static void run() {
        var controller = new ConsoleController(
            new BaseJobProcessor(
                new Convertor(),
                new Calculator(),
                new BaseValidator()
            ),
            new ConsoleView()
        );
        controller.execute();
    }

    public static void main(String[] args) {
        run();
    }
}
