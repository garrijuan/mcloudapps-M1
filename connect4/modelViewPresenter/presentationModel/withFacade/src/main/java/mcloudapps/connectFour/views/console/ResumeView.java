package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.Logic;
import mcloudapps.connectFour.views.Message;
import mcloudapps.connectFour.views.WithLogicView;
import mcloudapps.utils.views.YesNoDialog;

public class ResumeView extends WithLogicView {

    public ResumeView(Logic logic) {
        super(logic);
    }

    public boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.logic.reset();
        }
        return isResumed.isAffirmative();    }

}
    
