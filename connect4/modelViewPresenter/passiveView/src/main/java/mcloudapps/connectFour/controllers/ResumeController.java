package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.ViewFactory;

public class ResumeController extends Controller{

    public ResumeController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }

    public boolean control() {
        boolean isResumed = this.viewFactory.createResumeView().read();
        if (isResumed) {
            this.game.reset();
        }
        return isResumed;
    }
}
