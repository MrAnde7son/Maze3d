package controller;

/***
 * exit command. Stops the exection of the programs with all its threads.
 * @author Itamar&Chen
 *
 */
public class Exit extends CommonCommand {

	public Exit(CommonController controller) {
		super(controller);
	}

	@Override
	public void doCommand(String cmd) {
		this.controller.getModel().exit();
		this.controller.getModel().exit();
	}

}
