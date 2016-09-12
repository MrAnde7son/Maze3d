package controller;

import java.util.HashMap;

import model.CommonModel;
import view.CommonView;
/***
 * Controller component in MVC. Designed to work with Maze3d.
 * @author Itamar
 *
 */
public class MyController extends CommonController {
	
	private HashMap<String, Command> commands;
	
	public MyController(CommonModel model, CommonView view) {
		super(model, view);
		commands.put("dir", new Dir(this));
		commands.put("display", new Display(this));
		commands.put("generate", new GenerateMaze(this));
		commands.put("solve", new Solve(this));
		commands.put("save", new SaveMaze(this));
		commands.put("load", new LoadMaze(this));
		commands.put("display_cross_section", new DisplayCrossSection(this));
		commands.put("display_solution", new DisplaySolution(this));
		commands.put("exit", new Exit(this));
	}
	
	@Override
	public void notify(String name) {
		// TODO Auto-generated method stub

	}



}
