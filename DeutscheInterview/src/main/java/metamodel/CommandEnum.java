package main.java.metamodel;

import java.util.HashMap;
import java.util.Map;



public enum CommandEnum {
	CANVAS("C", 3), LINE("L", 5), RECTANGLE("R", 5), QUIT("Q", 1);
	
	private static final Map<String, CommandEnum> commandStructureMap = new HashMap<>();

	static {
		for (CommandEnum t : CommandEnum.values()) {
			commandStructureMap.put(t.commandChar, t);
		}
	}

	private final String commandChar;
	private final int numParams;

	public int getNumParams() {
		return numParams;
	}

	private CommandEnum(String commandChar, int numParams) {
		this.commandChar = commandChar;
		this.numParams = numParams;
	}

	public boolean equalsCommandChar(String other) {
		return commandChar.equals(other);
	}

	public String toString() {
		return this.commandChar;
	}

	public static CommandEnum get(String commandChar) {
		return commandStructureMap.get(commandChar);
	}
}

