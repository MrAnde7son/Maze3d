package model;

import java.io.IOException;

import algorithms.mazeGenerators.Maze3d;

public abstract class CommonModel implements Model {

	@Override
	public abstract void generate(String name, int x, int y, int z);

	@Override
	public abstract Maze3d getData(String name);
	
	@Override
	public void exit(){
		// TODO exit all threads 
	}
	
	/**
	 * Compresses and saves maze to file. 
	 */
	@Override
	public void saveMaze(String arg) throws IOException{}
	/**
	 * Decompress and loads maze from file. 
	 */
	@Override
	public void loadMaze(String arg)throws IOException {}

}
