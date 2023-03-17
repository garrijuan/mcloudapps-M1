package mcloudapps.connectFour;

import mcloudapps.connectFour.controllers.PlayController;
import mcloudapps.connectFour.controllers.ResumeController;
import mcloudapps.connectFour.controllers.StartController;
import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.ViewFactory;

public abstract class ConnectFour 
{
    private Game game;
    private ViewFactory viewFactory;
    protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;    

    public ConnectFour() {
        this.game = new Game();
        this.viewFactory = this.createViewFactory();
        this.startController = new StartController(this.game, this.viewFactory);
        this.playController = new PlayController(this.game, this.viewFactory);
        this.resumeController = new ResumeController(this.game, this.viewFactory);
    }

    protected abstract ViewFactory createViewFactory();

    protected void play() {
        do {
            this.startController.control();
            this.playController.control();
        } while (this.resumeController.control());
    }
}