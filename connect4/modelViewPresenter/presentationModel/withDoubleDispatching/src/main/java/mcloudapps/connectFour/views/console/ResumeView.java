package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.ResumeController;
import mcloudapps.connectFour.views.Message;
import mcloudapps.utils.views.YesNoDialog;

public class ResumeView{

    public boolean interact(ResumeController resumeController) {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            resumeController.reset();
        }else {
            resumeController.nextState();
        }
        return isResumed.isAffirmative();    }

}
    
