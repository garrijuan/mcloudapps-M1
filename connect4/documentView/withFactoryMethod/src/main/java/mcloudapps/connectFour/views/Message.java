package mcloudapps.connectFour.views;

import mcloudapps.utils.views.Console;

public enum Message {
    TITLE("******** CONNECT FOUR ********"),
	HORIZONTAL_LINE("------------------------------"),
	VERTICAL_LINE(" | "),
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

	public void write() {
		Console.getInstance().write(this.message);
	}

	public void writeColor(String color) {
		assert this == Message.COLOR;
		Console.getInstance().write(this.message.replaceAll("#color", color));
	}

	public void writePlayer(String player) {
		assert this == Message.RESULT_WIN;
		Console.getInstance().write(this.message.replaceAll("#player", "" + player));
	} 
	
	public void writeln() {
		Console.getInstance().writeln(this.message);
	}

	public void writeln(String player) {
		assert this == Message.RESULT_WIN;
		Console.getInstance().writeln(this.message.replaceAll("#player", "" + player));
	}

	@Override
	public String toString() {
		return message;
	}    
}
