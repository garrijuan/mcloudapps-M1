package mcloudapps.connectFour.views.console;

import mcloudapps.utils.views.Console;
import mcloudapps.connectFour.types.Error;

public class ErrorView extends mcloudapps.connectFour.views.ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }
    
}
