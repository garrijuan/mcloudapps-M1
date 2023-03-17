package mcloudapps.connectFour.views;

import mcloudapps.utils.views.Console;
import mcloudapps.connectFour.types.Error;

public class ErrorView {
    static final String[] MESSAGES = {
        "The board is full of tokens",
        "The column is not valid",
        "The column is full"
    };

    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }
}
