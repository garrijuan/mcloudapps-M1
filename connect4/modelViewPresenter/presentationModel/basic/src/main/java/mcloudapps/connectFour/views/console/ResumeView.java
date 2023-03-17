package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.ResumeController;
import mcloudapps.connectFour.views.Message;
import mcloudapps.utils.views.YesNoDialog;

public class ResumeView{

    private ResumeController resumeController;

    public ResumeView(ResumeController resumeController) {
        this.resumeController = resumeController;
    }

    public boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.resumeController.reset();
        }
        return isResumed.isAffirmative();    }

}
    
