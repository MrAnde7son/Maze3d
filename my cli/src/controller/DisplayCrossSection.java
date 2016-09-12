package controller;


/***
 * display_by_cross_section command. Displays a 2D maze cutted by a given column.
 * @author Itamar&Erlich
 *
 */
public class DisplayCrossSection extends CommonCommand {

	public DisplayCrossSection(CommonController controller) {
		super(controller);
	}

	@Override
	public void doCommand(String cmd) {
		String[] params = cmd.split(" ");
		String name = params[0];
		String axis = params[1].toLowerCase();
		int num = Integer.parseInt(params[2]);
		switch(axis){
			case("x"):
				this.controller.getModel().getData(name).getCrossSectionByX(num);
			case("y"):
				this.controller.getModel().getData(name).getCrossSectionByY(num);
			case("z"):
				this.controller.getModel().getData(name).getCrossSectionByZ(num);
		}
	}

}
