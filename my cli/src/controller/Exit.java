package controller;

/***
 * exit command. Stops the exection of the programs with all its threads.
 * @author Itamar
 *
 */
public class Exit extends CommonCommand {

	public Exit(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String cmd) {
		((MyController)this.controller).getModel().exit();
		((MyController)this.controller).getView().exit();
	}

}
