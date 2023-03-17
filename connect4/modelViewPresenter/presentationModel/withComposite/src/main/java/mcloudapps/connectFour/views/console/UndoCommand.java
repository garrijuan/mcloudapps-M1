package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.PlayController;
import mcloudapps.connectFour.views.Message;

public class UndoCommand extends Command {

    UndoCommand(PlayController playController) {
		super(Message.UNDO_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		this.playController.undo();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return this.playController.undoable();
	}
    
}
