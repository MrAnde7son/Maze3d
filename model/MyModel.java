package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFSSearcher;
import algorithms.search.DFSSearcher;
import algorithms.search.Maze3dDomain;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import algorithms.search.State;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

/**
 * MyModel class extends CommonModel
 * manage the size of the model
 */


public class MyModel extends CommonModel {

	ExecutorService threadpool;
	HashMap<Maze3d,String> mazeFile;
	
	/**
	 * Default Constructor of MyModel
	 */
	public MyModel() {
		threadpool = Executors.newFixedThreadPool(10);  //////////////////
		mazeFile = new HashMap<Maze3d,String>();
	}
	
	@Override
	public void generate(String name, int x, int y, int z) {
		threadpool.execute(new Runnable() {
			
			@Override
			public void run() {
				Maze3d maze = new GrowingTreeGenerator().generate(x, y, z);
				hashMaze.put(name,maze);
				controller.notify("maze " + name + " is ready");
			}
		});		
	}
	
	@Override
	public void getMazeByName(String name){
		Maze3d maze = hashMaze.get(name);
		if(maze == null)
			controller.notify("Not exist maze by name: " + name);
		else
			controller.notify(maze.toString()); 
	}

	@Override
	public void createSolution(String name) {
		String[] parm=name.split(" ");
		
		if(parm.length != 2){
			controller.notify("Invalid Command");
			return;
		}
		
		threadpool.execute(new Runnable() {
			
			@Override
			public void run() {
				if(parm[1].equalsIgnoreCase("bfs")){
					Maze3d maze = hashMaze.get(parm[0]);
					if(maze != null){
						Searcher<Position> bfs = new BFSSearcher<Position>();
						Searchable<Position> mazeDomain = new Maze3dDomain(maze);
						Solution<Position> bfsSolution = bfs.search(mazeDomain);
						hashSolution.put(parm[0], bfsSolution);
						controller.notify("Solution for " + parm[0] + " is ready");
					}
					else{
						controller.notify("Invalid name");
					}
				}
				else if(parm[1].equalsIgnoreCase("dfs")){
					Maze3d maze = hashMaze.get(parm[0]);
					if(maze != null){
						Searcher<Position> dfs = new DFSSearcher<Position>();
						Searchable<Position> mazeDomain = new Maze3dDomain(maze);
						Solution<Position> dfsSolution = dfs.search(mazeDomain);
						hashSolution.put(parm[0], dfsSolution);
						controller.notify("Solution for " + parm[0] + " is ready");
					}
					else{
						controller.notify("Invalid name");
					}
				}
				else
					controller.notify("Invalid algorithm");
			}
		});
	}

	@Override
	public void crossBy(String by, int index, String name) {
		Maze3d maze = hashMaze.get(name);
		
		String strMaze ="";
		int[][] maze2d = null;
		if(maze == null){
			controller.notify("Maze not exist");
			return;
		}
		try{
			switch(by){
			case "X":
				maze2d = maze.getCrossSectionByX(index);
				break;
			case "x":
				maze2d = maze.getCrossSectionByX(index);
				break;
			case "Y":
				maze2d = maze.getCrossSectionByY(index);
				break;
			case "y":
				maze2d = maze.getCrossSectionByY(index);
				break;
			case "Z":
				maze2d = maze.getCrossSectionByZ(index);
				break;
			case "z":
				maze2d = maze.getCrossSectionByZ(index);
				break;
			default:
				controller.notify("Invalid cross section");
				return;
			}
		}
		catch(IndexOutOfBoundsException e){
			controller.notify("Invalid index");
			return;
		}
		
		
		
		for(int i = 0; i < maze2d.length; i++){
			for(int j = 0; j < maze2d[i].length; j++)
				strMaze += String.valueOf(maze2d[i][j]) + " ";
			strMaze += '\n';
		}
		
		controller.notify(strMaze);
		
				
		
		
	}

	@Override
	public void saveMaze(String arg) {
		String[] parm = arg.split(" ");
		if(parm.length != 3){
			controller.notify("Invalid Command");
			return;
		}
		
		Maze3d maze = hashMaze.get(parm[1]);
		if(maze == null){
			controller.notify("Maze " + parm[1] + " not exist");
			return;
		}
		
		OutputStream out = null;
		try {
			out = new MyCompressorOutputStream(new FileOutputStream(parm[2] + ".maz"));
			out.write(maze.toByteArray());	
			mazeFile.put(maze, parm[2] + ".maz");
		} catch (FileNotFoundException e) {
			controller.notify(e.getMessage());
			return;
		} catch (IOException e) {
			controller.notify(e.getMessage());
			return;
		}
		finally{
			try {
				out.flush();
			} catch (IOException e) {
				controller.notify(e.getMessage());
			}
			try {
				out.close();
			} catch (IOException e) {
				controller.notify(e.getMessage());
			}
		}
		
		
		controller.notify("File " + parm[2] + " save");
		
	}

	@Override
	public void loadMaze(String arg) {
		String[] parm = arg.split(" ");
		Maze3d loaded = null;
		boolean isOpen = false;
		
		if(parm.length != 3){
			controller.notify("Invalid Command");
			return;
		}
		try{
			@SuppressWarnings("unused")
			File file = new File(parm[1] + ".maz");
		}
		catch(NullPointerException e){
			controller.notify("File not exist");
			return;
		}
			
		InputStream in=null;
		try {
			in = new MyDecompressorInputStream(new FileInputStream(parm[1] + ".maz"));
			isOpen = true;
			byte b[] = new byte[4096];
			in.read(b);
			loaded = new Maze3d(b);
		}
		catch (FileNotFoundException e) {
			controller.notify(e.getMessage());
			return;
		}
		catch (IOException e) {
			controller.notify(e.getMessage());
			return;
		}
		catch(NullPointerException e)
		{
			controller.notify(e.getMessage());
			return;
		}
		finally
		{
			try {
				if(isOpen)
					in.close();
			} catch (IOException e) 
			{
				controller.notify("Maze "+ parm[2]+" was unsuccessfully");
			}
		}
			
		hashMaze.put(parm[2], loaded);
		mazeFile.put(loaded, parm[1] + ".maz");
		controller.notify("Maze " + parm[2] + " loaded successfully");
	}
	
	@Override
	public void mazeSizeMemory(String name) {
		Maze3d maze = hashMaze.get(name);
		if(maze == null){
			controller.notify("Maze " + name + " not exist");
			return;
		}
		
		int size = 4*(maze.getX()*maze.getY()*maze.getZ() + 3 + 3 + 3);
		
		controller.notify("Maze " + name + " size in memory: " + size);
		
	}

	//////////////////////////////////////////////////
	@Override
	public void mazeSizeFile(String str) {
		
		try{
			String fielPath = mazeFile.get(hashMaze.get(str));
			if(fielPath == null){
				controller.notify("Maze " + str + " not exist in any file");
				return;
			}
			File maze = new File(fielPath);
			controller.notify("Maze file " + str + " size is: " + maze.length());
		}
		catch (NullPointerException e){
			controller.notify("Not exist " + str + " file");
		}
		
		
	}

	@Override///////////////////////////////
	public void exit(){
		threadpool.shutdown();
		try {
			while(!(threadpool.awaitTermination(10, TimeUnit.SECONDS)));
		} catch (InterruptedException e) {
			controller.notify(e.getMessage());
		}	
		
		
	}
}
