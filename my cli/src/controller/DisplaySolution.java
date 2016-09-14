package controller;

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
		((MyModel)this.controller.getModel()).getSolution(cmd);
	}

}
