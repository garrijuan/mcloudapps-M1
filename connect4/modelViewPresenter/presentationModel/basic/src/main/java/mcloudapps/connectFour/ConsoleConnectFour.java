package mcloudapps.connectFour;

import mcloudapps.connectFour.views.console.ConsoleView;

public class ConsoleConnectFour extends ConnectFour 
{
    @Override
    protected ConsoleView createView() {
        return new ConsoleView(this.startController, this.playController, this.resumeController);
    }

    public static void main( String[] args )
    {
        new ConsoleConnectFour().play();
    }
}