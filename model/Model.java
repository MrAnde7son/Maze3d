package model;

import java.io.IOException;

import algorithms.mazeGenerators.Maze3d;
/***
 * Model component in MVC.
 * @author Itamar
 *
 */
public interface Model {
	public abstract void generate(String name, int x, int y, int z);
	public abstract Maze3d getData(String name);
	public void exit();
	public void saveMaze(String arg) throws IOException;
	public void loadMaze(String arg) throws IOException ;
}
