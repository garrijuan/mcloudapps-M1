package mcloudapps.connectFour.views;

import mcloudapps.connectFour.models.Game;
import mcloudapps.utils.views.YesNoDialog;

public class ResumeView extends WithGameView {

    public ResumeView(Game game) {
        super(game);
    }

    public boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.game.reset();
        }
        return isResumed.isAffirmative();    }

}
    
