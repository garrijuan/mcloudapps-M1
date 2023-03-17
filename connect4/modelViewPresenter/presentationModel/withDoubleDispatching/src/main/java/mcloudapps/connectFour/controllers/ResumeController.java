package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.models.State;

public class ResumeController extends Controller{

    public ResumeController(Game game, State state) {
        super(game, state);
    }
    
    public void reset() {
        this.game.reset();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

    
}
