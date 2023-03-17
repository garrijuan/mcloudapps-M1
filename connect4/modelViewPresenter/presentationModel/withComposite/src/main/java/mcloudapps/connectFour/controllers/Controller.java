package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Session;
import mcloudapps.connectFour.types.Color;
import mcloudapps.utils.models.Coordinate;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session= session;
    }
    
    public Color getColor(Coordinate coordinate){
        return this.session.getColor(coordinate);
    }

    public int getNumberOfRows() {
        return this.session.getNumberOfRows();
    }

    public int getNumberOfColumns() {
        return this.session.getNumberOfColumns();
    }  

    public boolean isEmpty(Coordinate coordinate){
        return this.session.isEmpty(coordinate);
    }
}
