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
		String[] params = cmd.split(" ");
		String name = params[0];
		System.out.println(this.controller.getModel().getData(name).toString());
	}

}
