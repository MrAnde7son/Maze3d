package controller;

import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import model.MyModel;

/***
 * display_solution command. Displays the solution of a maze by its name.
 * @author Itamar & Chen
 *
 */
public class DisplaySolution extends CommonCommand {

	public DisplaySolution(CommonController controller) {
		super(controller);
	}

	@Override
	public void doCommand(String cmd) {
		Solution<Position> solution = ((MyModel)controller.getModel()).getSolution(cmd);
		if(solution == null)
			controller.notify("No solution for " + cmd + " maze");
		else
			controller.notify(solution.toString());
	}

}
