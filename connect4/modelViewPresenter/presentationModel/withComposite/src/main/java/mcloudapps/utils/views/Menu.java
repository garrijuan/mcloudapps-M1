package mcloudapps.utils.views;

import mcloudapps.utils.models.Command;
import mcloudapps.utils.models.ClosedInterval;

import java.util.ArrayList;

public abstract class Menu {

    private static final String OPTION = "----- Choose one option -----";

	private ArrayList<Command> commandList;

	public Menu() {
		this.commandList = new ArrayList<Command>();
	}

	public void execute() {
		ArrayList<Command> activeCommands = new ArrayList<Command>();
		for (Command command: this.commandList) {
            if (command.isActive()){
                activeCommands.add(command);
            }
		}
		assert activeCommands.size() > 0;
		boolean error;
		int option;
		do {
			error = false;
			Console.getInstance().writeln(Menu.OPTION);
			for (int i = 0; i < activeCommands.size(); i++) {
				Console.getInstance().writeln((i + 1) + ") " + activeCommands.get(i).getTitle());
			}
			option = Console.getInstance().readInt("") - 1;
			if (!new ClosedInterval(0, activeCommands.size()-1).isIncluded(option)) {
				error = true;
			}
		} while (error);
		activeCommands.get(option).execute();
	}

	protected void addCommand(Command command) {
		this.commandList.add(command);
	}

}
