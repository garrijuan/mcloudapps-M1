package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Session;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;

public class ActionController extends Controller{
    
    public ActionController(Session session) {
        super(session);
    }

    public void next() {
        this.session.next();
    }

    public void nextState() {
        this.session.nextState();
    }

    public void putToken(int column) {
        this.session.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.session.getPutTokenError(column);
    }

    public Color getResult(){
        return this.session.getResult();
    }

    public Color getActivePlayerColor(){
        return this.session.getActivePlayerColor();
    }

    public boolean isGameOver() {
        return this.session.isGameOver();
    }

}
