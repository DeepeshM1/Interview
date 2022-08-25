package main.java.command;

import java.util.Arrays;



public abstract class AbstractCommand implements Command {

	protected int width;
	protected int height;
	protected char[][] structure;
	private static final String LINE_SEPERATOR = System.getProperty("line.separator");


	/**
	 * @return the shape
	 */
	public char[][] getShape() {
		return structure;
	}

	/**
	 * @param shape
	 *            the shape to set
	 */
	public void setShape(char[][] shape) {
		this.structure = shape;
	}

	
	
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public void createStructure(int x1, int y1, int x2, int y2, char drawChar) {
		if (x1 == x2) {
			// vertical line
			for (int i = y1; i <= y2; i++) {
				structure[i][x1] = drawChar;
			}
		} else if (y1 == y2) {
			// horizontal line
			Arrays.fill(structure[y1], x1, x2 + 1, drawChar);
		} else {
			// Slanted line.
			double slope = (double) (y2 - y1) / (double) (x2 - x1);
			for (int i = y1; i <= y2; i++) {
				structure[i][(int) Math.ceil(x1 + (slope * i))] = drawChar;
			}
		}
	}

	public String getStrucutureString() {
		StringBuilder results = new StringBuilder();

		for (int i = 0; i < structure.length; ++i) {
			for (int j = 0; j < structure[i].length; j++) {
				results.append((structure[i][j]) == 0 ? " " : structure[i][j]);
			}
			results.append(LINE_SEPERATOR);
		}
		return results.toString();
	}

	protected void validate(int x1, int y1, int x2, int y2)
			throws Exception {
		if (x1 >= 1 && y1 >= 1 && x2 >= 1 && y2 >= 1 && x1 < width
				&& y1 < height && x2 < width && y2 < height && x1 <= x2
				&& y1 <= y2) {
			return;
		}
		throw new Exception("Input coordinates do not align with canvas border");
	}
	
	protected abstract void constructStructure();

	@Override
	public abstract void execute(String[] params) throws Exception;
}