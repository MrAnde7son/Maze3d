package controller;

/***
 * display_by_cross_section command. Displays a 2D maze cutted by a given column.
 * @author Itamar
 *
 */
public class DisplayCrossSection extends CommonCommand {

	public DisplayCrossSection(Controller controller) {
		super(controller);
	}
	
	@Override
	public void doCommand(String str) {
		String[] parm = str.split(" ");
		
		String by = parm[0];
		int index = Integer.parseInt(parm[1]);
		String name = parm[1];
		
		controller.getModel().crossBy(by, index, name);
	}

}
