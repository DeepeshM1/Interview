package main.java.app;

import java.util.Scanner;

import main.java.command.CanvasCommand;
import main.java.command.Command;
import main.java.command.LineCommand;
import main.java.command.QuitCommand;
import main.java.command.RectangleCommand;
import main.java.metamodel.CommandEnum;

public class CanvasApp {
	public static CanvasCommand canvasCommand;
	private static Command inputCommand;
	
	
	  // main method  
	  public static void main(String args[])    
	  { 
		CanvasApp app = new CanvasApp();
		
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				try {
					System.out.print("enter command: ");
					app.validateAndInitialiseCommand(scanner.nextLine());
				} catch (Exception iie) {
					System.err.println(iie.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	  
	  
	  /**
	   * Validates input parameters, if input not as per expected standard then throws exception else executes the command.
	   * @param canvasDimension
	   * @throws Exception
	   */
	  private  void validateAndInitialiseCommand(String canvasDimension) throws Exception {
		  String[] canvasDetails = canvasDimension.split(" ");
		  int inputParameterLength = canvasDetails.length;
		  if(inputParameterLength >=1) {
			  String commandName = canvasDetails[0];
			  if(commandName.equalsIgnoreCase(CommandEnum.CANVAS.toString()) && inputParameterLength == CommandEnum.CANVAS.getNumParams()) {
				  canvasCommand = new CanvasCommand();
				  canvasCommand.execute(canvasDetails);
				  return;
			  }
			  else if (commandName.equalsIgnoreCase(CommandEnum.LINE.toString()) && inputParameterLength == CommandEnum.LINE.getNumParams()) {
				  validateCanvasOrExit();
				  inputCommand = new LineCommand();
				  
			  }
			  else if (commandName.equalsIgnoreCase(CommandEnum.RECTANGLE.toString()) && inputParameterLength == CommandEnum.RECTANGLE.getNumParams()) {
				  validateCanvasOrExit();
				  inputCommand = new RectangleCommand();
				 
			  }
			  else if (commandName.equalsIgnoreCase(CommandEnum.QUIT.toString()) && inputParameterLength == CommandEnum.QUIT.getNumParams()) {
				  inputCommand = new QuitCommand();
			  }
			  else {
				  throw new Exception("Invalid input : Please enter valid commands and respective parameters");
			  }
			  inputCommand.execute(canvasDetails);
		  }
		  else {
			  throw new Exception("Invalid input : Please enter valid commands and respective parameters");
		  }
			  
	  } 
	  
	  private void validateCanvasOrExit() throws Exception {
		  if(canvasCommand ==null) {
			  throw new Exception("Invalid input : Canvas is not available . Please  create a canvas with C <width> <height> ");
		  } 
	  }
		 
	  
}
