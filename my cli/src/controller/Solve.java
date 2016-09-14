package controller;

import algorithms.demo.Maze3dDomain;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFSSearcher;
import algorithms.search.DFSSearcher;
import algorithms.search.Solution;
import model.MyModel;

/***
 * solve command. Solves a given maze.
 * @author Itamar
 *
 */
public class Solve extends CommonCommand {

	public Solve(CommonController controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String cmd) {
		String[] params = cmd.split(" ");
		String name = params[0];
		String algorithm = params[1].toLowerCase();
		
		Maze3d maze = this.controller.getModel().getData(name);
		Solution<Position> sol = new Solution<Position>();
		switch(algorithm){
		case("bfs"):
			sol = (new BFSSearcher<Position>()).search(new Maze3dDomain(maze));
		case("dfs"):
			sol = (new DFSSearcher<Position>()).search(new Maze3dDomain(maze));
		}
		
		((MyModel)this.controller.getModel()).addSolution(name, sol);
		this.controller.notify("Solution for " + name + " is ready.");
	}

}
