package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.views.Message;

public class ResultView implements mcloudapps.connectFour.views.ResultView {

    @Override
    public void writeWinner(Color color) {
        new MessageView().writeWinner(color);
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }

    @Override
    public void writeDraw() {
        new MessageView().writeln(Message.RESULT_DRAW);
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
}

