package mcloudapps.connectFour;

import mcloudapps.connectFour.controllers.Logic;
import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.View;

public abstract class ConnectFour 
{
    private View view;
    private Logic logic;

    public ConnectFour() {
        this.logic = new Logic(new Game());
        this.view = this.createView(this.logic);
    }

    protected abstract View createView(Logic logic);

    protected void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }
}