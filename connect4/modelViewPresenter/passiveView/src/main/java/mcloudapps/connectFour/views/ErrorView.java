package mcloudapps.connectFour.views;

import mcloudapps.connectFour.types.Error;

public abstract class ErrorView {
    public static final String[] MESSAGES = {
        "The board is full of tokens",
        "The column is not valid",
        "The column is full",
        "Run out of tokens"
    };

    public abstract void writeln(Error error);
}
