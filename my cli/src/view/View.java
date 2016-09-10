package view;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;
/***
 * View component in MVC.
 * @author Itamar
 *
 */
public interface View {
	public void notify(String name);
	public void display(Maze3d maze);
	public void setCommands(HashMap<String,Command> commands);
}
