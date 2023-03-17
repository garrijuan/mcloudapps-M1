package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.views.Message;

public class StartView implements mcloudapps.connectFour.views.StartView {
    
    @Override
    public void write() {
        new MessageView().writeln(Message.TITLE);
    }
}

