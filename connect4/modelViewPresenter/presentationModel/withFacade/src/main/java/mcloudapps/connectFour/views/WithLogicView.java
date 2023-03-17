package mcloudapps.connectFour.views;

import mcloudapps.connectFour.controllers.Logic;

public abstract class WithLogicView {
    protected Logic logic;

    public WithLogicView(Logic logic) {
        assert logic != null;
        this.logic = logic;
    }

}
