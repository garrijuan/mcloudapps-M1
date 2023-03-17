package mcloudapps.connectFour;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.View;

public class ConnectFour 
{
    private Game game;
    private View view;

    public ConnectFour() {
        this.game = new Game();
        this.view = new View(this.game);
    }

    public void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }

    public static void main( String[] args )
    {
        new ConnectFour().play();
    }
}