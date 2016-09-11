package controller;

import algorithms.mazeGenerators.Maze3d;

/***
 * display command. Displays a given maze by its name.
 * @author Itamar
 *
 */
public class Display extends CommonCommand {

	public Display(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String cmd) {
		Maze3d maze = ((MyController)this.controller).getModel().getData(cmd);
		System.out.println(maze);
		
	}

}
