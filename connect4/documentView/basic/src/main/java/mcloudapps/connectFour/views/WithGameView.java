package mcloudapps.connectFour.views;

import mcloudapps.connectFour.models.Game;

abstract class WithGameView {
  
    protected Game game;
    
    public WithGameView(Game game) {
        this.game = game;
    }
    
}
