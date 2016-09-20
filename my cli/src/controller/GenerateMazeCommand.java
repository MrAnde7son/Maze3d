package controller;

import model.MyModel;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;

/***
 * generate_maze command. Generate a new instance of Maze3d.
 * @author Itamar&Chen
 *
 */
public class GenerateMaze extends CommonCommand {

	public GenerateMaze(CommonController controller){
		super(controller);
	}

	@Override
	public void doCommand(String cmd) {
		String[] params = cmd.split(" ");
		String name = params[0];
		// TODO perform in separated thread
		Maze3d maze = (new GrowingTreeGenerator()).generate(Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]));
		((MyModel)this.controller.getModel()).addMaze(name, maze);
		this.controller.UpdateMessage("maze " + name + " is ready!");
		
	}

}
