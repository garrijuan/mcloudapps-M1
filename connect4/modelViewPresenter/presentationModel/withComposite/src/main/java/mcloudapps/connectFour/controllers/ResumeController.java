package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Session;

public class ResumeController extends Controller implements AcceptorController{

    public ResumeController(Session session) {
        super(session);
    }

    public void reset() {
        this.session.reset();
    }

    public void nextState() {
        this.session.nextState();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

    
}
