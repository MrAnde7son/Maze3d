package model;

import controller.Controller;
import algorithms.mazeGenerators.Maze3d;
/***
 * Model component in MVC. Designed to work with Maze3d.
 * @author Itamar
 *
 */
public class MyModel implements Model {
	
	private Controller controller;
	
	@Override
	public void generate(String name, int x, int y, int z) {
		// TODO Auto-generated method stub

	}

	@Override
	public Maze3d getData(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
