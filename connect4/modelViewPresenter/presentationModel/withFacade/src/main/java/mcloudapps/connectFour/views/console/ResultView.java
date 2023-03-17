package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.Logic;
import mcloudapps.connectFour.views.Message;
import mcloudapps.connectFour.views.WithLogicView;

public class ResultView extends WithLogicView {
   
    public ResultView(Logic logic) {
        super(logic);
    }
    
    public void interact() {
        if (this.logic.getResult() == null) {
            new MessageView().writeln(Message.RESULT_DRAW);
        } else {
            new MessageView().writeWinner(this.logic.getResult().toString());
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
    
}

