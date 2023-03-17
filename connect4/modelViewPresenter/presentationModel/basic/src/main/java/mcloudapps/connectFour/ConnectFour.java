package mcloudapps.connectFour;

import mcloudapps.connectFour.controllers.PlayController;
import mcloudapps.connectFour.controllers.ResumeController;
import mcloudapps.connectFour.controllers.StartController;
import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.View;

public abstract class ConnectFour 
{
    private Game game;
    private View view;
    protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;    

    public ConnectFour() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }
}