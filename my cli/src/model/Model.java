package model;

import algorithms.mazeGenerators.Maze3d;
/***
 * Model component in MVC.
 * @author Itamar
 *
 */
public interface Model {
	public void generate(String name, int x, int y, int z);
	public Maze3d getData(String name);
}
