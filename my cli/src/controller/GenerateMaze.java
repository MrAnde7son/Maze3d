package controller;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;

/***
 * generate_maze command. Generate a new instance of Maze3d.
 * @author Itamar
 *
 */
public class GenerateMaze implements Command {

	private String name;
	private Maze3d maze;
	
	public GenerateMaze(String name, int x, int y, int z) {
		maze = (new GrowingTreeGenerator()).generate(x, y, z);
	}
	
	@Override
	public void doCommand() {
		// TODO Auto-generated method stub

	}

}
