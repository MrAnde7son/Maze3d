package controller;

import java.util.HashMap;

import model.Model;
import view.View;
/***
 * Controller component in MVC. Designed to work with Maze3d.
 * @author Itamar & Chen
 *
 */
public class MyController extends CommonController {
	
	private HashMap<String, Command> commands;
	
	/**
	 * MyController constructor - get Model and View
	 * initialize the model and view in the CommonController
	 * create the HashMap from String to Command
	 * @param model - get object from type Model
	 * @param view - get object from type View
	 */
	
	public MyController(Model model, View view) {
		super(model, view);
		commands = new HashMap<>();
		commands.put("dir", new Dir(this));
		commands.put("display", new Display(this));
		commands.put("generate", new GenerateMaze(this));
		commands.put("solve", new Solve(this));
		commands.put("save", new SaveMaze(this));
		commands.put("load", new LoadMaze(this));
		commands.put("display_cross_section", new DisplayCrossSection(this));
		commands.put("display_solution", new DisplaySolution(this));
		commands.put("exit", new Exit(this));
		view.setCommands(commands);
	}
	
	@Override
	public void notify(String name) {
		this.view.notify(name);

	}

}
