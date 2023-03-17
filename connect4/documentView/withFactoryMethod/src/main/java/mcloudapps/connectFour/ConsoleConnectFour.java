package mcloudapps.connectFour;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.console.ConsoleView;

public class ConsoleConnectFour extends ConnectFour 
{
    @Override
    protected ConsoleView createView(Game game) {
        return new ConsoleView(game);
    }

    public static void main( String[] args )
    {
        new ConsoleConnectFour().play();
    }
}