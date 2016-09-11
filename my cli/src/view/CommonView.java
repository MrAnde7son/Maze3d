package view;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;

public abstract class CommonView implements View {

	@Override
	public abstract void notify(String name);

	@Override
	public abstract void display(Maze3d maze);

	@Override
	public abstract void setCommands(HashMap<String, Command> commands);
	
	@Override
	public void exit(){
		// TODO exit all threads 
	}
}
