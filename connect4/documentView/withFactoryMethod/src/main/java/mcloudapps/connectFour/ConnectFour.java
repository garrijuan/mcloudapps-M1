package mcloudapps.connectFour;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.View;

public abstract class ConnectFour 
{
    private Game game;
    private View view;

    public ConnectFour() {
        this.game = new Game();
        this.view = this.createView(this.game);
    }

    protected abstract View createView(Game game);

    protected void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }
}