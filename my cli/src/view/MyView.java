package view;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;
import controller.MyController;
/***
 * View component in MVC. Designed to work with Maze3d.
 * @author Itamar
 *
 */
public class MyView extends CommonView {

	private MyController controller;
	
	@Override
	public void notify(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCommands(HashMap<String, Command> commands) {
		// TODO Auto-generated method stub

	}

	@Override
	public void display(Maze3d maze) {
		// TODO Auto-generated method stub
		
	}

	public MyController getController() {
		return controller;
	}

}
