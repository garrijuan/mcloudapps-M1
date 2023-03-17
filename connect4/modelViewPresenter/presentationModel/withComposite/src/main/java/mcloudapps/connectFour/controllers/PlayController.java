package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Session;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;

public class PlayController extends Controller implements AcceptorController{

    private ActionController actionController;
    private UndoController undoController;
    private RedoController redoController;
    
    public PlayController(Session session) {
        super(session);
        this.actionController = new ActionController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);        
    }

    public void undo(){
        this.undoController.undo();
    }

    public boolean undoable(){
        return this.undoController.undoable();
    }

    public void redo(){
        this.redoController.redo();
    }

    public boolean redoable(){
        return this.redoController.redoable();
    }

    public void nextState() {
        this.actionController.nextState();
    }

    public void next() {
        this.actionController.next();
    }

    public Color getResult(){
        return this.actionController.getResult();
    }

    public void putToken(int column) {
        this.actionController.putToken(column);
    }

    public Color getActivePlayerColor(){
        return this.actionController.getActivePlayerColor();
    }

    public Error getPutTokenError(int column) {
        return this.actionController.getPutTokenError(column);
    }

    public boolean isGameOver() {
        return this.actionController.isGameOver();
    }
    
    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
