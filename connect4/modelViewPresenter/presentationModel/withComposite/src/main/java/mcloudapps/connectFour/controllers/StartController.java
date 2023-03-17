package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Session;

public class StartController extends Controller implements AcceptorController{
    
    public StartController(Session session ) {
        super(session);
    }

    public void nextState() {
        this.session.nextState();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
       
    
}
