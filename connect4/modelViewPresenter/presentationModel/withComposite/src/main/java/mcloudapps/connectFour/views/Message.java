package mcloudapps.connectFour.views;

public enum Message {
    TITLE("******** CONNECT FOUR ********"),
	HORIZONTAL_LINE("------------------------------"),
	VERTICAL_LINE(" | "),
    ACTION_COMMAND("Do an action"),
    UNDO_COMMAND("Undo previous action"),
    REDO_COMMAND("Redo previous action"),	
    EMPTY(" "),
    NEW_LINE("\n"),
	COLOR("#color"),
	ENTER_COLUMN_TO_PUT("Player #player turn - Enter the column to put a token: "),
	RESULT_WIN("#player player: You win!!! :-)"), 
	RESULT_DRAW("Nobody wins: Draw :/"), 
	RESUME("Do you want to continue");

	private String message;

	Message(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}    
}
