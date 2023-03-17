package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.Logic;
import mcloudapps.connectFour.views.View;

public class ConsoleView extends View {
    
    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView(Logic logic) {
        super(logic);
        this.startView = new StartView(logic);
        this.playView = new PlayView(logic);
        this.resumeView = new ResumeView(logic);
    }

    @Override
    public void start() {
        this.startView.interact();
    }

    @Override
    public void play() {
        this.playView.interact();
    }

    @Override
    public boolean resume() {
        return this.resumeView.interact();
    }    
}
