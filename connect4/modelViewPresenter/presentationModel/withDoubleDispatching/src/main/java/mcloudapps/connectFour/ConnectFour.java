package mcloudapps.connectFour;

import mcloudapps.connectFour.controllers.Controller;
import mcloudapps.connectFour.views.View;
import mcloudapps.connectFour.controllers.Logic;

public abstract class ConnectFour 
{
    private Logic logic;
    private View view;
      

    public ConnectFour() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null)
                controller.accept(this.view);
        } while (controller != null);
    }
}