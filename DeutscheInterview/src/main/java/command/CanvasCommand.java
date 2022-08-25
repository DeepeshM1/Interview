package main.java.command;

public class CanvasCommand extends AbstractCommand {

	@Override
	public void execute(final String[] params)  {

		

		int width = Integer.parseInt(params[1]);
		int height = Integer.parseInt(params[2]);

		// set properties for canvas
		setWidth(width);
		setHeight(height);

		constructStructure();
		// Print canvas
		System.out.print(getStrucutureString());
	}

	protected void constructStructure() {
		structure = new char[height + 2][width];
		// Draw upper border
		createStructure(0, 0, width - 1, 0, '-');
		// Draw left border
		createStructure(0, 1, 0, height + 1, '|');
		// Draw right border
		createStructure(width - 1, 1, width - 1, height + 1, '|');
		// Draw lower border
		createStructure(0, height + 1, width - 1, height + 1, '-');
	}

	
}
