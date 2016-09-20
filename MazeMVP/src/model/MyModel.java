package model;

import java.util.Map;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;

/***
 * Implementation of Model in MVP for Maze3d.
 * @author Itamar&Chen
 *
 */
public class MyModel extends Observable implements Model {
	
	private ExecutorService executor;
	
	public MyModel() {
		executor = Executors.newFixedThreadPool(50);
	}		
		
	private Map<String, Maze3d> mazes = new ConcurrentHashMap<String, Maze3d>();
			
	@Override
	public void generateMaze(final String name, final int x, final int y, final int z) {
		executor.submit(new Callable<Maze3d>() {

			@Override
			public Maze3d call() throws Exception {
				Maze3d maze = (new GrowingTreeGenerator()).generate(x, y, z);
				mazes.put(name, maze);

				setChanged();
				notifyObservers("maze_ready " + name);		
				return maze;
			}
			
		});
			
	}

	@Override
	public Maze3d getMaze(String name) {
		return mazes.get(name);
	}
	
	public void exit() {
		executor.shutdownNow();
	}
}
