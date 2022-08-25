package main.java.command;

public class RectangleCommand extends LineCommand {

	@Override
	public void execute(String[] params) throws Exception  {
		super.execute(params);

	}
	
	protected void constructStructure() {
		createStructure(x1, y1, x2, y1, 'x');
		createStructure(x1, y1, x1, y2, 'x');
		createStructure(x2, y1, x2, y2, 'x');
		createStructure(x1, y2, x2, y2, 'x');
	}
}
