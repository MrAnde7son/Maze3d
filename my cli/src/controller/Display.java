package controller;


/***
 * display command. Displays a given maze by its name.
 * @author Itamar&Chen
 *
 */
public class Display extends CommonCommand {

	public Display(CommonController controller) {
		super(controller);
	}

	@Override
	public void doCommand(String cmd) {
		this.controller.getModel().getData(cmd);
		
	}

}
