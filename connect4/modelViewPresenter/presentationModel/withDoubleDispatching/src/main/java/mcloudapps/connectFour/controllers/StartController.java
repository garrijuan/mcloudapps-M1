package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.models.State;

public class StartController extends Controller{
    
    public StartController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
       
    
}
