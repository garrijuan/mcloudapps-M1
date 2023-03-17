package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;

public class ResumeController extends Controller{

    public ResumeController(Game game) {
        super(game);
    }
    
    public void reset() {
        this.game.reset();
    }
    
}
