package controller;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;

/***
 * generate_maze command. Generate a new instance of Maze3d.
 * @author Itamar
 *
 */
public class GenerateMaze extends CommonCommand {

	private String name;
	private Maze3d maze;
	
	public GenerateMaze(Controller controller){
		super(controller);
	}

	@Override
	public void doCommand(String cmd) {
		String[] params = cmd.split(" ");
		String name = params[0];
		// TODO perform in seperated thread
		Maze3d maze = (new GrowingTreeGenerator()).generate(Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]));
		((MyController)this.controller).getModel().addMaze(name, maze);
		this.controller.notify("maze " + name + " is ready!");
		
	}

}
