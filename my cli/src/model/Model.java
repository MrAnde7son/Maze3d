package model;

import java.io.IOException;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
/***
 * Model component in MVC.
 * @author Itamar&Chen
 *
 */
public interface Model {
	public void generate(String name, int x, int y, int z);
	public void generateSolution(String cmd);
	public Solution<Position> getSolution(String name);
	public Maze3d getData(String name);
	public void exit();
	public void saveMaze(String arg) throws IOException;
	public void loadMaze(String arg) throws IOException;
}
