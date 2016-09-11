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
	public abstract void notify(String name);
	public abstract void display(Maze3d maze);
	public abstract void setCommands(HashMap<String,Command> commands);
	public void exit();
}
