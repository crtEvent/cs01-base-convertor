package cs01;

import cs01.controller.console.ConsoleController;

public class ConsoleApplication {

    public static void run() {
        var controller = new ConsoleController();
        controller.execute();
    }

    public static void main(String[] args) {
        run();
    }
}
