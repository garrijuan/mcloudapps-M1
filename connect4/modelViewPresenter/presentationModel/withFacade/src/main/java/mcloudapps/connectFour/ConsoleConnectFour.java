package mcloudapps.connectFour;

import mcloudapps.connectFour.controllers.Logic;
import mcloudapps.connectFour.views.console.ConsoleView;

public class ConsoleConnectFour extends ConnectFour 
{
    @Override
    protected ConsoleView createView(Logic logic) {
        return new ConsoleView(logic);
    }

    public static void main( String[] args )
    {
        new ConsoleConnectFour().play();
    }
}