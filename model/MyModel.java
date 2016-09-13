package model;

import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import controller.MyController;
import algorithms.mazeGenerators.Maze3d;
/***
 * Model component in MVC. Designed to work with Maze3d.
 * @author Itamar&Chen
 *
 */
public class MyModel extends CommonModel {
	
	protected MyController controller;
	protected HashMap<String,Maze3d> mazes;
	
	public MyModel(){
		this.mazes = new HashMap<>();
	}
	
	@Override
	public void generate(String name, int x, int y, int z) {
		// TODO Auto-generated method stub

	}

	@Override
	public Maze3d getData(String name) {
		return this.mazes.get(name);
	}

	public MyController getController() {
		return controller;
	}

	public HashMap<String, Maze3d> getMazes() {
		return mazes;
	}

	public void addMaze(String name,Maze3d maze){
		this.mazes.put(name, maze);
	}
	
	@Override
	public void loadMaze(String arg) throws IOException {
		String[] params = arg.split(" ");
		String name = params[0];
		InputStream in=new MyDecompressorInputStream(new FileInputStream(params[1] + ".maz"));
		byte[] maze=new byte[4096];
		in.read(maze);
		in.close();
		Maze3d loaded = new Maze3d(maze);
		addMaze(name, loaded);
	}
	@Override
	public void saveMaze(String arg) throws IOException {
		String[] params = arg.split(" ");
		Maze3d maze = getData(params[0]);
		OutputStream out = new MyCompressorOutputStream(new FileOutputStream(params[1] + ".maz"));
		out.write(maze.toByteArray());
		out.flush();
		out.close();
		
	}
	
}
