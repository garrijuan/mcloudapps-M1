package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.views.Message;
import mcloudapps.utils.views.YesNoDialog;

public class ResumeView implements mcloudapps.connectFour.views.ResumeView {

    public boolean read() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        return isResumed.isAffirmative();    
    }

}
    
