package main.java.command;

public class QuitCommand extends AbstractCommand {

	@Override
	public void execute(final String[] params) {
		System.exit(0);
	}

	@Override
	protected void constructStructure() {
		// TODO Auto-generated method stub
		
	}
}
