package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.PlayController;
import mcloudapps.connectFour.views.Message;

public class ActionCommand extends Command {

	ActionCommand(PlayController playController) {
		super(Message.ACTION_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		new PlayerView(this.playController).interact();
    	this.playController.next();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return true;
	}

}

