package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.ViewFactory;

public class StartController extends Controller{
    
    public StartController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }
    
    public void control() {
        this.viewFactory.createStartView().write();
        this.writeBoard();
    }   
    
}
