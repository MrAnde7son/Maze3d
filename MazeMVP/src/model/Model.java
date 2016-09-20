package model;

import algorithms.mazeGenerators.Maze3d;
/***
 * Model in MVP architecutr
 * @author Itamar&Chen
 *
 */
public interface Model {
	void generateMaze(String name, int x, int y, int z);
	Maze3d getMaze(String name);
	void exit();	
}
