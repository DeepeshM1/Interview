package main.java.command;

import main.java.app.CanvasApp;

public class LineCommand extends AbstractCommand {
	int x1,x2,y1,y2 =0;

	@Override
	public void execute(String[] params) throws Exception  {
		setHeight(CanvasApp.canvasCommand.getHeight());
		setWidth(CanvasApp.canvasCommand.getWidth());
		setShape(CanvasApp.canvasCommand.getShape());
		
		try {
			 x1 = Integer.parseInt(params[1]);
			 y1 = Integer.parseInt(params[2]);
			 x2 = Integer.parseInt(params[3]);
			 y2 = Integer.parseInt(params[4]);
			validate(x1, y1, x2, y2);
			constructStructure();
			//Print line
			System.out.print(getStrucutureString());
			
		}
		catch (NumberFormatException ex) {
			throw new Exception ("Invalid incoming parameters for Line command. Example input L 1 3 4 3");
		}

		

	}
	protected void constructStructure() {
		createStructure(x1, y1, x2, y2, 'x');
	}
}
