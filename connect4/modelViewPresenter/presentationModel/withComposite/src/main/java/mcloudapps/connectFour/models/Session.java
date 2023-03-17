package mcloudapps.connectFour.models;

import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;
import mcloudapps.utils.models.Coordinate;

public class Session {

    private State state;
    private Game game;
    private Registry registry;

    public Session() {
        this.game = new Game();
        this.state = new State();
        this.registry = new Registry(this.game);
    }

    public void reset(){
        this.game.reset();
        this.state.reset();
        this.registry.reset();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void nextState() {
        this.state.next();
    }

    public boolean undoable() {
        return this.registry.isUndoable();
    }

    public boolean redoable() {
        return this.registry.isRedoable();
    }

    public void undo() {
        this.registry.undo();
    }

    public void redo() {
        this.registry.redo();
    }

    public void next() {
        this.game.next();
        this.registry.register();
    }

    public int getNumberOfRows() {
        return this.game.getNumberOfRows();
    }

    public int getNumberOfColumns() {
        return this.game.getNumberOfColumns();
    }
    
    public Color getColor(Coordinate coordinate){
        return this.game.getColor(coordinate);
    }

    public boolean isEmpty(Coordinate coordinate){
        return this.game.isEmpty(coordinate);
    }

    public boolean isGameOver() {
        return this.game.isGameOver();
    }

    public Color getActivePlayerColor(){
        return this.game.getActivePlayerColor();
    }
    
    public Error getPutTokenError(int column) {
        return this.game.getPutTokenError(column);
    }

    public void putToken(int column) {
        this.game.putToken(column, this.getActivePlayerColor());
    }

    public Color getResult() {
        return this.game.getResult();
    }

}
