package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.PlayController;
import mcloudapps.connectFour.views.Message;

public class RedoCommand extends Command {

    RedoCommand(PlayController playController) {
		super(Message.REDO_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		this.playController.redo();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return this.playController.redoable();
	}

}
