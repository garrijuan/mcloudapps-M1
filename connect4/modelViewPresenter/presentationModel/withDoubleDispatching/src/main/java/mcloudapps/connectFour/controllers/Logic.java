package mcloudapps.connectFour.controllers;

import java.util.HashMap;
import java.util.Map;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.models.State;
import mcloudapps.connectFour.models.StateValue;

public class Logic {
    
    private Game game;
    private State state;
    private Map<StateValue, Controller> controllers;

    public Logic() {
        this.state = new State();
        this.game = new Game();
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
        this.controllers.put(StateValue.RESUME, new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.state.getValueState());
    }

}

