package mcloudapps.connectFour;

import mcloudapps.connectFour.views.console.ConsoleViewFactory;

public class ConsoleConnectFour extends ConnectFour 
{
    @Override
    protected ConsoleViewFactory createViewFactory() {
        return new ConsoleViewFactory();
    }

    public static void main( String[] args )
    {
        new ConsoleConnectFour().play();
    }
}