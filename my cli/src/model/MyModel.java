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
import algorithms.demo.Maze3dDomain;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFSSearcher;
import algorithms.search.DFSSearcher;
import algorithms.search.Solution;
/***
 * Model component in MVC. Designed to work with Maze3d.
 * @author Itamar&Chen
 *
 */
public class MyModel extends CommonModel {
	
	protected MyController controller;
	protected HashMap<String,Maze3d> mazes;
	protected HashMap<String, Solution<Position>> solutions;
	
	public MyModel(){
		this.mazes = new HashMap<>();
		this.solutions = new HashMap<>();
	}
	
	@Override
	public void generate(String name, int x, int y, int z) {
		Maze3d maze = new GrowingTreeGenerator().generate(x, y, z);
		mazes.put(name, maze);

	}
	
	@Override
	public void generateSolution(String arg) {
		String[] parm=arg.split(" ");
		
		if(parm.length != 2){
			controller.UpdateMessage("Invalid Command");
			return;
		}
		if(parm[1].equalsIgnoreCase("bfs")){
			Maze3d maze = mazes.get(parm[0]);
			if(maze != null){
				BFSSearcher<Position> bfs = new BFSSearcher<Position>();
				
				Solution<Position> bfsSolution = bfs.search(new Maze3dDomain(maze));
				solutions.put(parm[0], bfsSolution);
				controller.UpdateMessage("Solution for " + parm[0] + " is ready");
			}
			else{
				controller.UpdateMessage("Invalid name");
			}
		}
		else if(parm[1].equalsIgnoreCase("dfs")){
			Maze3d maze = mazes.get(parm[0]);
			if(maze != null){
				DFSSearcher<Position> dfs = new DFSSearcher<Position>();
				Solution<Position> dfsSolution = dfs.search(new Maze3dDomain(maze));
				solutions.put(parm[0], dfsSolution);
				controller.UpdateMessage("Solution for " + parm[0] + " is ready");
			}
			else{
				controller.UpdateMessage("Invalid name");
			}
		}
		else
			controller.UpdateMessage("Invalid algorithm");
		
	}
	
	@Override
	public Maze3d getData(String name) {
		return this.mazes.get(name);
	}

	public MyController getController() {
		return controller;
	}

	public void setController(MyController controller) {
		this.controller = controller;
	}
	
	public HashMap<String, Maze3d> getMazes() {
		return mazes;
	}

	public void addMaze(String name,Maze3d maze){
		this.mazes.put(name, maze);
	}
	
	public void addSolution(String name,Solution<Position> sol){
		this.solutions.put(name, sol);
	}
	
	public Solution<Position> getSolution(String name){
		return this.solutions.get(name);
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
