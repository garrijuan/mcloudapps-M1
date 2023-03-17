package mcloudapps.connectFour;

import mcloudapps.utils.Console;

public enum Error {
	FULL("The board is full of tokens"),
	WRONG_COLUMN("The column is not valid "),
	COLUMN_FULL("The column is full"),
    NOT_TOKEN("Run out of tokens"),
	NULL;

	private String message;

	Error(){
	}

	Error(String message){
		this.message = message;
	}

	void writeln() {
		if (!this.isNull()) {
			Console.getInstance().writeln(this.message);
		}
	}

	public boolean isNull() {
		return this == Error.NULL;
	}

}
