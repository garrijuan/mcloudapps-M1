package mcloudapps.connectFour.views.console;

import mcloudapps.utils.views.Console;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.views.Message;

public class MessageView {

	public void write(Message message) {
		Console.getInstance().write(message.toString());
	}

	public void writeln(Message message) {
		Console.getInstance().writeln(message.toString());
	}

	public void writeColor(Color color) {
		Console.getInstance().write(Message.COLOR.toString().replaceAll("#color", color.toString()));
	}

	public void writeWinner(Color color) {
		Console.getInstance().writeln(Message.RESULT_WIN.toString().replaceAll("#player", "" + color.toString()));
	} 
 
}
